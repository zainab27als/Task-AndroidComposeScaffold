package com.nbk.coffeeapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nbk.coffeeapplication.ui.theme.CoffeeApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeApplicationTheme {
                CoffeeApp()
            }
        }
    }
}

@Composable
fun CoffeeApp() {
    val scaffoldState = rememberScaffoldState()
    val coffeeBrown = Color(0xFF6F4E37)
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Welcome to CoffeeTime!") },
                backgroundColor = coffeeBrown,
                contentColor = Color.White
            )
        },
        bottomBar = {
            BottomNavigation(backgroundColor = coffeeBrown) {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    selected = false,
                    onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Welcome Home! How about a fresh brew?")
                        }
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Menu, contentDescription = "Menu") },
                    selected = false,
                    onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Explore our coffee menu!")
                        }
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Your coffee is brewing!")
                    }
                },
                backgroundColor = coffeeBrown,
                contentColor = Color.White
            ) {
                Text("☕")
            }
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF3E5AB))
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Welcome to CoffeeTime!\nBrew Happiness with Every Cup.",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = coffeeBrown
                )
            }
        }
    )
}
