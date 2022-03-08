package uz.zafarbek.domain.ports.datastore

import kotlinx.coroutines.flow.Flow

interface DatastorePort {

    suspend fun setToken(token: String?)

    suspend fun setFirstName(firstName: String?)

    suspend fun setLastName(lastName: String?)

    suspend fun setEmail(email: String?)

    suspend fun setProfilePhoto(photo: String?)

    suspend fun setHasSeenOnBoard(bool: Boolean?)

    fun getToken(): Flow<String?>

    fun getFirstName(): Flow<String?>

    fun getLastName(): Flow<String?>

    fun getEmail(): Flow<String?>

    fun getProfilePhoto(): Flow<String?>

    fun getHasSeenOnBoard(): Flow<Boolean?>

    suspend fun clearAll()
}