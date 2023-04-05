package com.example.githubuser.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubuser.data.local.DatabaseModule

class FavoriteViewModel(private val databaseModule: DatabaseModule) : ViewModel() {

    fun getUserFavorite() = databaseModule.githubDao.loadAll()

    class Factory(private val db: DatabaseModule) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = FavoriteViewModel(db) as T
    }
}