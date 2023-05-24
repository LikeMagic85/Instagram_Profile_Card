package com.like_magic.instagramprofilecard.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.like_magic.instagramprofilecard.InstagramModel
import com.like_magic.instagramprofilecard.R

@Composable
fun InstagramProfileCard(instagramModel: InstagramModel, onClickListener:(InstagramModel)-> Unit) {

    Card(
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 4.dp
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = "Instagram logo"
                )
            }
            UserStatistics(topText = "6950", bottomText = "Posts")
            UserStatistics(topText = "436M", bottomText = "Followers")
            UserStatistics(topText = "78", bottomText = "Following")
        }
        FillCardRow(
            text = "Instagram ${instagramModel.id}",
            fontSize = 32,
            fontFamily = FontFamily.Cursive
        )
        FillCardRow(
            text = instagramModel.title,
            fontSize = 16,
            fontFamily = FontFamily.Default
        )
        FillCardRow(
            text = "www.facebook.com/emotional_health",
            fontSize = 16,
            fontFamily = FontFamily.Default
        )
        FollowButton(isFollowed = instagramModel.isFollowed) {
            onClickListener(instagramModel)
        }

    }

}

@Composable
private fun UserStatistics(topText: String, bottomText: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            Text(
                text = topText,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive
            )
        }
        Box() {
            Text(text = bottomText)
        }
    }
}

@Composable
private fun FillCardRow(text: String, fontSize: Int, fontFamily: FontFamily) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(start = 16.dp, bottom = 4.dp)
    ) {
        Text(
            text = text,
            fontSize = fontSize.sp,
            fontFamily = fontFamily
        )
    }
}

@Composable
private fun FollowButton(
    isFollowed: Boolean,
    clickListener:()->Unit
){
    val color = if (isFollowed) {
        MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)

    } else {
        MaterialTheme.colorScheme.primary
    }
    Button(
        onClick = { clickListener() },
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Text(text = setText(isFollowed))
    }
}

private fun setText(state: Boolean): String {
    return if (state) "Unfollow" else "Follow"
}