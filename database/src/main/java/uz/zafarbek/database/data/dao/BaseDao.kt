package uz.zafarbek.database.data.dao

import androidx.room.*

interface BaseDao<E> {

    @Insert
    suspend fun insert(vararg entity: E)

    @Delete
    suspend fun delete(vararg entity: E)

    @Update
    suspend fun update(vararg entity: E)

}