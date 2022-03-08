package uz.zafarbek.database.port

import kotlinx.coroutines.flow.Flow
import uz.zafarbek.database.data.dao.CourseDao
import uz.zafarbek.domain.data.database.CourseEntity
import uz.zafarbek.domain.data.ui.Course
import uz.zafarbek.domain.mappers.CourseEMMapper
import uz.zafarbek.domain.ports.database.DatabaseCoursePort
import javax.inject.Inject

class CoursePlug @Inject constructor(
    private val dao: CourseDao,
    private val courseEMMapper: CourseEMMapper
) : DatabaseCoursePort {

    override suspend fun insert(vararg data: CourseEntity) {
        dao.insert(*data)
    }

    override suspend fun insertAll(data: List<CourseEntity>) {
        dao.insertCourses(data)
    }

    override suspend fun update(data: CourseEntity) {
        dao.update(data)
    }

    override suspend fun updateState(id: String, isComplete: Boolean) {
        dao.setCompleteState(id, isComplete)
    }

    override suspend fun getAll(): List<CourseEntity> {
        return dao.getAll()
    }

    override suspend fun getById(vararg ids: String): List<CourseEntity> {
        return dao.getById(*ids)
    }

}