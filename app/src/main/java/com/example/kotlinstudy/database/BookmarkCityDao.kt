package com.example.kotlinstudy.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.ArrayList

@Dao
interface BookmarkCityDao {
    // insert
    @Insert
    fun insert(bookmarkCityEntity: BookmarkCityEntity)

    // Query
    @Query("SELECT * from bookmarkcity_table")
    fun getAll(): List<BookmarkCityEntity>
}