package com.example.testapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.ActivityOpenLinkBinding

class OpenLinkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOpenLinkBinding
    private val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenLinkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val savedUrl = sharedPreferences.getString("url_key", "")

        binding.webView.webViewClient = WebViewClient()
        val webSettings = binding.webView.settings
        webSettings.javaScriptEnabled = true
        if (savedInstanceState != null) {
            binding.webView.restoreState(savedInstanceState)
        } else {
            binding.webView.loadUrl(savedUrl!!)
        }
        binding.webView.settings.domStorageEnabled = true
        binding.webView.settings.javaScriptCanOpenWindowsAutomatically = true
        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        val mWebSettings = binding.webView.settings
        mWebSettings.javaScriptEnabled = true
        mWebSettings.loadWithOverviewMode = true
        mWebSettings.useWideViewPort = true
        mWebSettings.domStorageEnabled = true
        mWebSettings.databaseEnabled = true
        mWebSettings.setSupportZoom(false)
        mWebSettings.allowFileAccess = true
        mWebSettings.allowContentAccess = true
        mWebSettings.loadWithOverviewMode = true
        mWebSettings.useWideViewPort = true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.webView.saveState(outState);
        super.onSaveInstanceState(outState)
    }


    private fun WebView.goBackOr(action: () -> Unit) {
        if (this.canGoBack()) {
            this.goBack()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (event.action === KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    binding.webView.goBackOr {
                        finish()
                    }
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}