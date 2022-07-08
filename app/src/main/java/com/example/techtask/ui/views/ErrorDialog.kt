package com.example.techtask.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun ErrorDialog(
    titleText: String,
    message: String,
    buttonText: String,
    onButtonClicked: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {},
        backgroundColor = Color.White,
        title = {
            Text(text = titleText)
        },
        text = {
            Text(message)
        },
        confirmButton = {

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .clickable { onButtonClicked() }, verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = buttonText,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 3.dp),
                    textAlign = TextAlign.Center
                )
            }
        },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
    )
}