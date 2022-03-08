package uz.zafarbek.datastore.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.zafarbek.datastore.data.DataStoreManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {

    @Singleton
    @Provides
    fun dataStoreManager(application: Application): DataStoreManager {
        return DataStoreManager(application)
    }
}
