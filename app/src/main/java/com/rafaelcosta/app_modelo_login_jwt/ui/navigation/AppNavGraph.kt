package com.rafaelcosta.app_modelo_login_jwt.ui.navigation

import androidx.compose.runtime.collectAsState
import com.rafaelcosta.app_modelo_login_jwt.ui.home.HomeScreen
import com.rafaelcosta.app_modelo_login_jwt.ui.login.LoginScreen
import com.rafaelcosta.app_modelo_login_jwt.ui.session.AuthState
import com.rafaelcosta.app_modelo_login_jwt.ui.session.AuthStateViewModel
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(nav: NavHostController) {
    val vm: AuthStateViewModel = hiltViewModel()
    val authState = vm.state.collectAsState().value

    NavHost(nav, startDestination = when (authState) {
        AuthState.Authenticated -> "home"
        else -> "login"
    }) {
        composable("login") {
            LoginScreen(onLoginSuccess = {
                nav.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            })
        }
        composable("home") {
            HomeScreen(onLogout = {
                nav.navigate("login") {
                    popUpTo("home") { inclusive = true }
                }
            })
        }
    }
}
