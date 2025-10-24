package com.rafaelcosta.app_modelo_login_jwt.ui.session


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelcosta.app_modelo_login_jwt.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

sealed interface AuthState {
    data object Loading : AuthState
    data object Unauthenticated : AuthState
    data object Authenticated : AuthState
}

@HiltViewModel
class AuthStateViewModel @Inject constructor(repo: AuthRepository) : ViewModel() {
    val state = repo.tokenFlow()
        .map { token ->
            if (token.isNullOrBlank())
                AuthState.Unauthenticated
            else AuthState.Authenticated
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            AuthState.Loading)
}