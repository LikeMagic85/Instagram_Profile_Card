package com.like_magic.instagramprofilecard.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun InstagramProfileCard() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.fillMaxHeight()) {

        }
        Column() {
            Box() {
                Text(text = "6950")
            }
            Box() {
                Text(text = "Posts")
            }
        }
        Column() {
            Box() {
                Text(text = "436M")
            }
            Box() {
                Text(text = "followers")
            }
        }
        Column() {
            Box() {
                Text(text = "76")
            }
            Box() {
                Text(text = "following")
            }
        }
    }
}