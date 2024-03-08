package com.alithya.boilerplate

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.alithya.boilerplate.core.presentation.theme.BoilerPlateTheme
import com.alithya.boilerplate.core.utils.ProvideAppNavigator
import com.alithya.boilerplate.features.login.presentation.LoginScreen
import com.alithya.boilerplate.main.MainViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
@Preview
fun App(
    mainViewModel: MainViewModel = koinInject(),
) {

    val darkTheme = when (mainViewModel.appTheme.collectAsState().value) {
        1 -> true
        else -> false
    }

    KoinContext {
        BoilerPlateTheme(
            darkTheme = darkTheme
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.surface
            ){
                Navigator(
                    screen = LoginScreen()
                ) { navigator ->
                    ProvideAppNavigator(
                        navigator = navigator,
                        content = { SlideTransition(navigator = navigator) }
                    )
                }
            }
        }
    }
}