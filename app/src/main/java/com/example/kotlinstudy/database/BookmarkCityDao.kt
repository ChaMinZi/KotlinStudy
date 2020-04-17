package com.example.kotlinstudy.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.ArrayList

@Dao
interface BookmarkCityDao : BaseDao<BookmarkCityEntity> {

    // Query
    @Query("SELECT * from bookmarkcity_table")
    fun getAll(): LiveData<List<BookmarkCityEntity>>
}