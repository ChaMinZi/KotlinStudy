package com.example.kotlinstudy.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class BookmarkViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BookmarkRepository by lazy {
        BookmarkRepository(application)
    }

    private val bookmarks: LiveData<List<BookmarkCityEntity>> by lazy {
        repository.getAll()
    }

    fun getAll() = bookmarks

    fun insert(bookmark: BookmarkCityEntity) {
        repository.insert(bookmark)
    }
}