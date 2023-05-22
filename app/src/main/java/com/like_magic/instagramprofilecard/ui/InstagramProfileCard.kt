package com.like_magic.instagramprofilecard.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun InstagramProfileCard() {
    Card(
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 4.dp
        ),
        border = BorderStroke(1.dp, Color.Black),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier.padding(4.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Box(
                modifier = Modifier.size(50.dp)
            )
            SetValue(topText = "6950", bottomText = "Posts")
            SetValue(topText = "436M", bottomText = "Followers")
            SetValue(topText = "78", bottomText = "Following")
        }
    }

}

@Composable
private fun SetValue(topText:String, bottomText:String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            Text(text = topText)
        }
        Box() {
            Text(text = bottomText)
        }
    }
}