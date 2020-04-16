package com.example.kotlinstudy.database

import androidx.room.*

@Entity(tableName = "bookmarkcity_table")
data class BookmarkCityEntity (
    @PrimaryKey(autoGenerate = true) var userId: Int = 0
    , @ColumnInfo(name = "bookmark_NO") var no: Int = 0
    , @ColumnInfo(name="bookmark_city") var name: String? = ""
    , @ColumnInfo(name="bookmark_url") var url: String? = ""
    , @ColumnInfo(name="bookmark_favorite") var favorite : Int = 0
)