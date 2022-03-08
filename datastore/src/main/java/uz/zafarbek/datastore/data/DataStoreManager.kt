package uz.zafarbek.datastore.data

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import uz.zafarbek.datastore.utils.DataStoreKeys
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(DataStoreKeys.DATA_STORE)

class DataStoreManager @Inject constructor(application: Application) {
    private val dataStore = application.dataStore
    private val tokenKey = stringPreferencesKey(DataStoreKeys.TOKEN)
    private val hasSeenOnBoardKey = booleanPreferencesKey(DataStoreKeys.HAS_SEEN_ONBOARD)
    private val firstNameKey = stringPreferencesKey(DataStoreKeys.FIRST_NAME)
    private val lastNameKey = stringPreferencesKey(DataStoreKeys.LAST_NAME)
    private val emailKey = stringPreferencesKey(DataStoreKeys.EMAIL_KEY)
    private val profilePhotoKey = stringPreferencesKey(DataStoreKeys.PROFILE_PHOTO)


    suspend fun setToken(token: String?) {
        dataStore.edit { data ->
            if (token != null) {
                data[tokenKey] = token
            } else {
                data.remove(tokenKey)
            }
        }
    }

    suspend fun setHasSeenOnboard(bool: Boolean?) {
        dataStore.edit { data ->
            if (bool != null) {
                data[hasSeenOnBoardKey] = bool
            } else {
                data.remove(hasSeenOnBoardKey)
            }
        }
    }


    suspend fun setFirstName(firstName: String?) {
        dataStore.edit { data ->
            if (firstName != null) {
                data[firstNameKey] = firstName
            } else {
                data.remove(firstNameKey)
            }
        }
    }

    suspend fun setLastName(lastName: String?) {
        dataStore.edit { data ->
            if (lastName != null) {
                data[lastNameKey] = lastName
            } else {
                data.remove(lastNameKey)
            }
        }
    }

    suspend fun setEmail(email: String?) {
        dataStore.edit { data ->
            if (email != null) {
                data[emailKey] = email
            } else {
                data.remove(emailKey)
            }
        }
    }

    suspend fun setProfilePhoto(photo: String?) {
        dataStore.edit { data ->
            if (photo != null) {
                data[profilePhotoKey] = photo
            } else {
                data.remove(profilePhotoKey)
            }
        }
    }

    fun getToken() = dataStore.data.map {
        it[tokenKey]
    }

    fun getFirstName() = dataStore.data.map {
        it[firstNameKey]
    }

    fun getLastName() = dataStore.data.map {
        it[lastNameKey]
    }

    fun getPhoneNumber() = dataStore.data.map {
        it[emailKey]
    }

    fun getProfilePhoto() = dataStore.data.map {
        it[profilePhotoKey]
    }

    fun getHasSeenOnboard() = dataStore.data.map {
        it[hasSeenOnBoardKey]
    }

    suspend fun clearAll() {
        dataStore.edit {
            it.clear()
        }
    }
}
