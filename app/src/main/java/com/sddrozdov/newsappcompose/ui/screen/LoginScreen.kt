package com.sddrozdov.newsappcompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sddrozdov.newsappcompose.R
import com.sddrozdov.newsappcompose.ui.navigation.Screen

@Composable
fun LoginScreen(
    onNavigateTo: (Screen) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 110.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.log_image_news),
            contentDescription = "Login image news",
            modifier = Modifier.padding(top = 15.dp)
        )
        OutlinedTextField(
            value = "Email",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Email),
                    contentDescription = ""
                )
            }, modifier = Modifier.padding(top = 15.dp)
        )
        OutlinedTextField(
            value = "Password",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Lock),
                    contentDescription = ""
                )
            }, modifier = Modifier.padding(top = 15.dp),
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}