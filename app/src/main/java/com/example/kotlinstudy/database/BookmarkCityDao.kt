package com.example.kotlinstudy.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BookmarkCityDao : BaseDao<BookmarkCityEntity> {

    // Query
    @Query("SELECT * from bookmarkcity_table")
    fun getAll(): LiveData<List<BookmarkCityEntity>>

    @Query("SELECT * FROM bookmarkcity_table WHERE city_id = :city_id")
    fun getBookmarkById(city_id: Int) : LiveData<BookmarkCityEntity>

    @Query("DELETE FROM bookmarkcity_table WHERE city_id = :city_id")
    open fun deleteById(city_id: Int): Unit
}