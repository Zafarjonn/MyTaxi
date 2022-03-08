package uz.zafarbek.domain.repositories

import uz.zafarbek.domain.ports.datastore.DatastorePort
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val datastorePort: DatastorePort
) {

    suspend fun setHAsSeenOnBoarding(bool: Boolean) {
        datastorePort.setHasSeenOnBoard(bool)
    }

    fun getHasSeenOnBoarding() = datastorePort.getHasSeenOnBoard()

}