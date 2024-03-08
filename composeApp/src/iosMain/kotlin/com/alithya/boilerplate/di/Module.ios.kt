package com.alithya.boilerplate.di

import com.alithya.boilerplate.platform.createSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single<Settings> { createSettings() }
}