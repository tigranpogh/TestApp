package info.xbet.x.sports

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testapp.BuildConfig
import com.example.testapp.R
import com.example.testapp.databinding.FragmentSplashBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import java.util.*


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private val sharedPrefFile = "kotlinsharedpreference"
    private var url = ""
    val DEFAULTS: HashMap<String, Any> =
        hashMapOf(
            "NEXT_BUTTON_TEXT" to "NEXT",
            "NEXT_BUTTON_COLOR" to "#0091FF"
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences: SharedPreferences =
            requireContext().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val savedUrl = sharedPreferences.getString("url_key", "")

        if (savedUrl == "") {
            try {
                val remoteConfig = getFirebaseRemoteConfig()
                url = remoteConfig.getString("url")
                Toast.makeText(requireContext(), url, Toast.LENGTH_LONG).show()
            } catch (ex: java.lang.Exception) {
                Toast.makeText(requireContext(), ex.message, Toast.LENGTH_LONG).show()
            }
            if (url == "" || fromEmulator() || !isSimSupport()) {
                loadFragment(SportFragment())
            } else {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("url_key", url)
                editor.apply()
                startActivity(Intent(requireContext(), OpenLinkActivity::class.java))
            }
        } else {
            if (checkForInternet()) {
                startActivity(Intent(requireContext(), OpenLinkActivity::class.java))
            } else {
                loadFragment(NoConnectionFragment())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun checkForInternet(): Boolean {
        val connectivityManager =
            requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false

            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                else -> false
            }
        } else {
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

    private fun fromEmulator(): Boolean {
        if (BuildConfig.DEBUG) return false // when developer use this build on

        val phoneModel = Build.MODEL
        val buildProduct = Build.PRODUCT
        val buildHardware = Build.HARDWARE
        val brand = Build.BRAND
        var result = (Build.FINGERPRINT.startsWith("generic")
                || phoneModel.contains("google_sdk")
                || phoneModel.lowercase(Locale.getDefault()).contains("droid4x")
                || phoneModel.contains("Emulator")
                || phoneModel.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || buildHardware == "goldfish"
                || brand.contains("google")
                || buildHardware == "vbox86"
                || buildProduct == "sdk"
                || buildProduct == "google_sdk"
                || buildProduct == "sdk_x86"
                || buildProduct == "vbox86p"
                || Build.BOARD.lowercase(Locale.getDefault()).contains("nox")
                || Build.BOOTLOADER.lowercase(Locale.getDefault()).contains("nox")
                || buildHardware.lowercase(Locale.getDefault()).contains("nox")
                || buildProduct.lowercase(Locale.getDefault()).contains("nox"))
        if (result) return true
        result = result or (Build.BRAND.startsWith("generic") &&
                Build.DEVICE.startsWith("generic"))
        if (result) return true
        result = result or ("google_sdk" == buildProduct)
        return result
    }

    private fun isSimSupport(): Boolean {
        val tm =
            requireContext().getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager //gets the current TelephonyManager
        return tm.simState != TelephonyManager.SIM_STATE_ABSENT
    }

    private fun loadFragment(homeFragment: Fragment) {
        val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, homeFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun getFirebaseRemoteConfig(): FirebaseRemoteConfig {

        val remoteConfig = Firebase.remoteConfig

        val configSettings = remoteConfigSettings {
            if (BuildConfig.DEBUG) {
                minimumFetchIntervalInSeconds = 0 // Kept 0 for quick debug
            } else {
                minimumFetchIntervalInSeconds = 60 * 60 // Change this based on your requirement
            }
        }

        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(DEFAULTS)

        remoteConfig.fetchAndActivate().addOnCompleteListener {
//            Logger.d(TAG, "addOnCompleteListener")
        }

        return remoteConfig
    }
}