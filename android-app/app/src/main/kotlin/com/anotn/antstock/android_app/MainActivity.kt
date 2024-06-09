package com.anotn.antstock.android_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import com.anotn.antstock.android_app.ui.AntstockApp
import com.anotn.antstock.android_app.ui.rememberAntstockAppState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ui.ui.theme.AndroidappTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel : MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        var uiState : MainActivityUiState by mutableStateOf(MainActivityUiState.Loading)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewModelScope.launch {
                    viewModel.uiState.collect {
                        uiState = it
                    }
                }
            }
        }

        // Keep the splash screen on-screen until the UI state is loaded. This condition is
        // evaluated each time the app needs to be redrawn so it should be fast to avoid blocking
        // the UI.
        splashScreen.setKeepOnScreenCondition {
            when (uiState) {
                MainActivityUiState.Loading -> true
                is MainActivityUiState.Success -> false
            }
        }

        enableEdgeToEdge()

        setContent {
            val darkTheme = shouldUseDarkTheme(uiState)

            DisposableEffect(darkTheme) {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.auto(
                        android.graphics.Color.TRANSPARENT,
                        android.graphics.Color.TRANSPARENT,
                    ) {darkTheme},
                    navigationBarStyle = SystemBarStyle.auto(
                        lightScrim,
                        darkScrim,
                    ) {darkTheme},
                )
                onDispose {  }
            }
            val appState = rememberAntstockAppState(
            )
            CompositionLocalProvider() {
                AndroidappTheme(
                    darkTheme = darkTheme,
                    dynamicColor = !shouldDisableDynamicTheming(uiState),
                ) {
                    AntstockApp(appState)
                }
            }
        }
    }
    override fun onResume() {
        super.onResume()
    }
    override fun onPause() {
        super.onPause()
    }
}

@Preview
@Composable
fun PreviewAntstockApp() {
    AndroidappTheme {
        AntstockApp(rememberAntstockAppState())
    }
}

/**
 * Returns `true` if the dynamic color is disabled, as a function of the [uiState].
 */
@Composable
private fun shouldDisableDynamicTheming(
    uiState: MainActivityUiState,
): Boolean = when (uiState) {
    MainActivityUiState.Loading -> false
    is MainActivityUiState.Success -> true
}

/**
 * Returns `true` if dark theme should be used, as a function of the [uiState] and the
 * current system context.
 */
@Composable
private fun shouldUseDarkTheme(
    uiState: MainActivityUiState): Boolean = when
        (uiState) {
            MainActivityUiState.Loading -> isSystemInDarkTheme()
            is MainActivityUiState.Success -> true
        }

private val lightScrim = android.graphics.Color.argb(0xe6, 0xFF, 0xFF, 0xFF)

private val darkScrim = android.graphics.Color.argb(0x80, 0x1b, 0x1b, 0x1b)