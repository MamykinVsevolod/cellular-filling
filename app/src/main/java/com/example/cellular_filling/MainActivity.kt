package com.example.cellular_filling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.example.cellular_filling.ui.MainScreen
import com.example.cellular_filling.ui.theme.CellularfillingTheme
import com.example.cellular_filling.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
        private val viewModel: MainViewModel by lazy {
        val savedStateViewModelFactory = SavedStateViewModelFactory(application, this)
        ViewModelProvider(this, savedStateViewModelFactory).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CellularfillingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(viewModel = viewModel)
                }
            }
        }
    }
}
