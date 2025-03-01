package com.cabovianco.thenbhd.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cabovianco.thenbhd.ui.screen.Screen
import com.cabovianco.thenbhd.ui.screen.view.AlbumScreen
import com.cabovianco.thenbhd.ui.screen.view.SongScreen
import com.cabovianco.thenbhd.ui.theme.jetBrainsFont

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.AlbumScreen.route,
            modifier = Modifier.padding(it)
        ) {
            composable(Screen.AlbumScreen.route) {
                AlbumScreen()
            }

            composable(Screen.SongScreen.route) {
                SongScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "THE NEIGHBOURHOOD",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = jetBrainsFont,
                textAlign = TextAlign.Center
            )
        },
        modifier = modifier
    )
}

@Composable
private fun BottomNavigationBar(modifier: Modifier = Modifier, navController: NavController) {
    val screens = listOf(Screen.AlbumScreen, Screen.SongScreen)
    val actualRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar(
        modifier = modifier.fillMaxWidth()
    ) {
        screens.forEach {
            val isSelected = it.route == actualRoute

            NavigationBarItem(
                selected = isSelected,
                onClick = { if (!isSelected) navController.navigate(it.route) },
                icon = {
                    Icon(
                        painter = painterResource(it.iconId),
                        contentDescription = null
                    )
                },
                label = { Text(text = it.name) },
                alwaysShowLabel = false
            )
        }
    }
}
