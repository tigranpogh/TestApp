package info.xbet.x.sports

import android.app.Application
import com.onesignal.OneSignal


class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

        // promptForPushNotifications will show the native Android notification permission prompt.
        // We recommend removing the following code and instead using an In-App Message to prompt for notification permission (See step 7)
        OneSignal.promptForPushNotifications()
    }

    companion object {
        private const val ONESIGNAL_APP_ID = "4a5b8a72-c740-4de0-bcbe-5a6077d12421"
    }
}