package com.like_magic.instagramprofilecard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel:ViewModel() {

    private val initialList = mutableListOf<InstagramModel>().apply {
        repeat(500){
            add(
                InstagramModel(
                    id= it,
                    title = "Title: $it",
                    isFollowed = Random.nextBoolean()
                )
            )
        }
    }

    private val _models = MutableLiveData<List<InstagramModel>>(initialList)
    val models:LiveData<List<InstagramModel>>
        get() = _models

    fun changeFollowingStatus(instagramModel: InstagramModel) {
        val modifiedList = _models.value?.toMutableList() ?: mutableListOf()
        modifiedList.replaceAll{
            if(it==instagramModel){
                it.copy(isFollowed = !it.isFollowed)
            }else{
                it
            }
        }
        _models.value = modifiedList
    }

    fun deleteItem(model:InstagramModel){
        val modifiedList = _models.value?.toMutableList() ?: mutableListOf()
        modifiedList.remove(model)
        _models.value = modifiedList
    }
}