package com.example.kotlinstudy.database

import androidx.room.*

@Dao
interface BaseDao<ET> {
    // onConflict = OnConflictStrategy.REPLACE : PrimaryKey가 겹치는 것이 있으면 덮어 쓴다
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: ET)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: Array<out ET>)

    @Update
    fun update(entity: ET)

    @Delete
    fun delete(entity: ET)
}