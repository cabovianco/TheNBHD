package com.cabovianco.thenbhd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.cabovianco.thenbhd.navigation.AppNavigation
import com.cabovianco.thenbhd.ui.theme.TheNBHDTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheNBHDTheme {
                AppNavigation()
            }
        }
    }

}
