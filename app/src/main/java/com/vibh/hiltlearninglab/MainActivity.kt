package com.vibh.hiltlearninglab

import android.content.SharedPreferences
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
import com.vibh.hiltlearninglab.core.GreetingService
import com.vibh.hiltlearninglab.core.repository.UserRepository
import com.vibh.hiltlearninglab.ui.theme.HiltLearningLabTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.core.content.edit
import com.vibh.hiltlearninglab.ui.home.HomeScreen
import com.vibh.hiltlearninglab.ui.navigation.AppNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var greetingService: GreetingService
    @Inject
    lateinit var appPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("greetingService: ${greetingService.message()}")
        appPreferences.edit { putString("name", "Vibhanshu") }
        println("appPreferences: ${appPreferences.getString("name","Guest")}")
        enableEdgeToEdge()
        setContent {
            HiltLearningLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    AppNavigation(paddingValues = paddingValues)
                }
            }
        }
    }
}