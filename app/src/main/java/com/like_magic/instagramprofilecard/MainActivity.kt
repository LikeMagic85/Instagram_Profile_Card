package com.like_magic.instagramprofilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.like_magic.instagramprofilecard.ui.InstagramProfileCard
import com.like_magic.instagramprofilecard.ui.theme.InstagramProfileCardTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContent {
            InstagramProfileCardTheme() {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                        .padding(all = 8.dp)
                ) {
                    val models = viewModel.models.observeAsState(listOf())
                    LazyColumn{
                        items(models.value, key = {it.id}){ it ->
                            val dismissState = rememberDismissState()
                            if(dismissState.isDismissed(DismissDirection.EndToStart)){
                                viewModel.deleteItem(it)
                            }
                            SwipeToDismiss(
                                state = dismissState,
                                background = {
                                    Box(modifier = Modifier
                                        .padding(16.dp)
                                        .background(Color.Red.copy(alpha = 0.5f))
                                        .fillMaxSize(),
                                        contentAlignment = Alignment.CenterEnd
                                    ){
                                        Text(
                                            modifier = Modifier.padding(16.dp),
                                            text = "Delete item",
                                            color = Color.White,
                                            fontSize = 24.sp
                                        )
                                    }
                                },
                                dismissThresholds = {
                                    FractionalThreshold(0.5f)
                                },
                                directions = setOf(DismissDirection.EndToStart)
                            ) {
                                InstagramProfileCard(
                                    instagramModel = it,
                                    onClickListener = {item->
                                        viewModel.changeFollowingStatus(item)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
