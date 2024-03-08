package com.alithya.boilerplate.platform

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

/**
 * created by Josue Lubaki
 * date : 2023-12-04
 * version : 1.0.0
 */

actual fun createSettings(context : Any?): Settings {
    val ctx = context as Context
    val delegate = ctx.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    return SharedPreferencesSettings(delegate)
}