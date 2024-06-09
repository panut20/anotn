package com.anotn.antstock.android_app

import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow<MainActivityUiState>(
        MainActivityUiState.Success("initial data")
    )
    val uiState: StateFlow<MainActivityUiState> = _uiState.asStateFlow()
}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val data : String) : MainActivityUiState
}