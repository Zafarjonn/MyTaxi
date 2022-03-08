package uz.zafarbek.domain.mapper

interface ResponseModelMapper<Response, Model> {

    fun mapFromResponse(response: Response): Model

    fun mapToResponse(model: Model): Response

    open fun mapFromResponseList(list: List<Response>): List<Model> {
        return ArrayList<Model>().apply {
            list.forEach {
                add(mapFromResponse(it))
            }
        }
    }
}