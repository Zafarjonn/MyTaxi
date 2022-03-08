package uz.zafarbek.domain.mapper

interface ResponseEntityMapper<Response, Entity> {

    fun mapFromResponse(response: Response): Entity

    fun mapToResponse(entity: Entity): Response

    open fun mapFromResponseList(list: List<Response>): List<Entity> {
        return ArrayList<Entity>().apply {
            list.forEach {
                add(mapFromResponse(it))
            }
        }
    }
}