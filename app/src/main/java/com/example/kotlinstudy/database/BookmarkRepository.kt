package com.example.kotlinstudy.database

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Runnable
import java.util.concurrent.Executor
import java.util.concurrent.Executors


class BookmarkRepository(application: Application) {

    private val bookmarkCityDao: BookmarkCityDao by lazy {
        val database = AppDatabase.getInstance(application)
        database.BookmarkCityDao()
    }

    private val bookmarks: LiveData<List<BookmarkCityEntity>> by lazy {
        bookmarkCityDao.getAll()
    }

    fun getAll(): LiveData<List<BookmarkCityEntity>> { return bookmarks }

    fun getBookmarkById(city_id: Int): LiveData<BookmarkCityEntity> {
        return bookmarkCityDao.getBookmarkById(city_id)
    }

    fun insert(bookmark: BookmarkCityEntity) {
        val addRunaable = object : Runnable {
            override fun run() {
                bookmarkCityDao.insert(bookmark)
            }
        }
        val diskIO: Executor = Executors.newSingleThreadExecutor()
        diskIO.execute(addRunaable)
    }

    fun delete(city_id: Int) {
        val addRunaable = object : Runnable {
            override fun run() {
                bookmarkCityDao.deleteById(city_id)
            }
        }
        val diskIO: Executor = Executors.newSingleThreadExecutor()
        diskIO.execute(addRunaable)
    }
}