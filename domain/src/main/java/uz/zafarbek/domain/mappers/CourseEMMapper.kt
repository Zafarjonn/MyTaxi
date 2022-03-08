package uz.zafarbek.domain.mappers


import uz.zafarbek.domain.mapper.EntityModelMapper
import uz.zafarbek.domain.data.database.CourseEntity
import uz.zafarbek.domain.data.ui.Course
import javax.inject.Inject

class CourseEMMapper @Inject constructor(
    private val sectionEMMapper: SectionEMMapper
) : EntityModelMapper<CourseEntity, Course>() {

    override fun mapFromEntity(entity: CourseEntity): Course =
        Course(
            id = entity.id,
            title = entity.title,
            icon = entity.icon,
            sections = null,
            isCompleted = entity.isCompleted

        )

    override fun mapToEntity(model: Course): CourseEntity =
        CourseEntity(
            id = model.id,
            title = model.title,
            icon = model.icon,
            sections = model.sections?.map { it.id },
            isCompleted = model.isCompleted
        )
}