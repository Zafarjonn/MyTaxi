package uz.zafarbek.domain.repositories

import uz.zafarbek.domain.ports.datastore.DatastorePort
import javax.inject.Inject

class MainRepository @Inject constructor(

    private val datastorePort: DatastorePort,
) {

    fun getHasSeenOnBoarding() = datastorePort.getHasSeenOnBoard()

//    suspend fun getTopic(id: String): Topic {
//        return coursePort.getAll()
//    }
}