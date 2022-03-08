package uz.zafarbek.domain.ports.database

import uz.zafarbek.domain.data.database.CourseEntity
import uz.zafarbek.domain.data.ui.Course


interface DatabaseCoursePort {

    suspend fun insert(vararg data: CourseEntity)

    suspend fun insertAll(data:List<CourseEntity>)

    suspend fun update(data: CourseEntity)

    suspend fun updateState(id: String, isComplete: Boolean)

    suspend fun getAll(): List<CourseEntity>

    suspend fun getById(vararg ids: String): List<CourseEntity>

}