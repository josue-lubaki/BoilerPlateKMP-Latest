package com.alithya.boilerplate.di

import org.koin.core.module.Module
import org.koin.dsl.module
import com.alithya.boilerplate.platform.createSettings
import com.russhwolf.settings.Settings
import org.koin.android.ext.koin.androidContext

actual fun platformModule(): Module = module {
    single<Settings> { createSettings(context = androidContext()) }
}

val androidModule = module {

}