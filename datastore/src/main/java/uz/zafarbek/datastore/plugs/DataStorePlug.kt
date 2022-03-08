package uz.zafarbek.datastore.plugs

import kotlinx.coroutines.flow.Flow
import uz.zafarbek.datastore.data.DataStoreManager
import uz.zafarbek.domain.ports.datastore.DatastorePort
import javax.inject.Inject

class DataStorePlug @Inject constructor(private val dataStoreManager: DataStoreManager) :
    DatastorePort {

    override suspend fun setToken(token: String?) {
        dataStoreManager.setToken(token)
    }

    override suspend fun setFirstName(firstName: String?) {
        dataStoreManager.setFirstName(firstName)
    }

    override suspend fun setLastName(lastName: String?) {
        dataStoreManager.setLastName(lastName)
    }

    override suspend fun setEmail(email: String?) {
        dataStoreManager.setEmail(email)
    }

    override suspend fun setProfilePhoto(photo: String?) {
        dataStoreManager.setProfilePhoto(photo)
    }

    override suspend fun setHasSeenOnBoard(bool: Boolean?) {
        dataStoreManager.setHasSeenOnboard(bool)
    }

    override fun getToken(): Flow<String?> = dataStoreManager.getToken()

    override fun getFirstName(): Flow<String?> = dataStoreManager.getFirstName()

    override fun getLastName(): Flow<String?> = dataStoreManager.getLastName()

    override fun getEmail(): Flow<String?> = dataStoreManager.getPhoneNumber()

    override fun getProfilePhoto(): Flow<String?> = dataStoreManager.getProfilePhoto()

    override fun getHasSeenOnBoard(): Flow<Boolean?> = dataStoreManager.getHasSeenOnboard()

    override suspend fun clearAll() {
        dataStoreManager.clearAll()
    }
}