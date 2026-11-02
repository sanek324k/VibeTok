package com.vibetok

import de.robv.android.xposed.*
import de.robv.android.xposed.callbacks.XC_LoadPackage

class VibeTok : IXposedHookLoadPackage {
    private val region = "US" // потом вынесем в настройки

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName != "com.zhiliaoapp.musically" &&
            lpparam.packageName != "com.ss.android.ugc.trill") return

        listOf("getSimCountryIso", "getNetworkCountryIso").forEach { name ->
            XposedHelpers.findAndHookMethod(
                "android.telephony.TelephonyManager", lpparam.classLoader, name,
                object : XC_MethodHook() {
                    override fun afterHookedMethod(p: MethodHookParam) {
                        p.result = region.lowercase()
                    }
                })
        }
    }
}
