package uz.zafarbek.domain.mapper

abstract class EntityModelMapper<Entity, Model> {

    abstract fun mapFromEntity(entity: Entity): Model

    abstract fun mapToEntity(model: Model): Entity

    open fun mapToEntityList(list: List<Model>): List<Entity> {
        return ArrayList<Entity>().apply {
            list.forEach {
                add(mapToEntity(it))
            }
        }
    }

    open fun mapFromEntityList(list: List<Entity>): List<Model> {
        return ArrayList<Model>().apply {
            list.forEach {
                if (it != null)
                    add(mapFromEntity(it))
            }
        }
    }
}