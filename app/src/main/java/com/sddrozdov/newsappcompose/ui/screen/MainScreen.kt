package com.sddrozdov.newsappcompose.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.sddrozdov.newsappcompose.ui.navigation.Screen

@Composable
fun MainScreen(
    onNavigateTo:(Screen) -> Unit
){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(text = "MainScreen")
    }
}