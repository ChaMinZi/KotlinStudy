package com.example.kotlinstudy.database

import androidx.room.*

@Entity(tableName = "bookmarkcity_table")
data class BookmarkCityEntity (
    @PrimaryKey() var city_id: Int = 0
    , @ColumnInfo(name="bookmark_city") var name: String? = ""
    , @ColumnInfo(name="bookmark_url") var url: String? = ""
)