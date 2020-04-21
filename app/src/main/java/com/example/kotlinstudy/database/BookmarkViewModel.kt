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

    fun getBookmarkById(id: Int): LiveData<BookmarkCityEntity> {
        return repository.getBookmarkById(id)
    }

    fun insert(bookmark: BookmarkCityEntity) {
        repository.insert(bookmark)
    }

    fun delete(city_id: Int) {
        repository.delete(city_id)
    }
}