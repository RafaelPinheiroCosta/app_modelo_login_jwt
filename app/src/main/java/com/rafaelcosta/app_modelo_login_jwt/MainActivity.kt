package com.rafaelcosta.app_modelo_login_jwt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.rafaelcosta.app_modelo_login_jwt.ui.navigation.AppNavGraph
import com.rafaelcosta.app_modelo_login_jwt.ui.theme.App_modelo_login_jwtTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_modelo_login_jwtTheme {
                val nav = rememberNavController()
                AppNavGraph(nav)
            }
        }
    }
}
