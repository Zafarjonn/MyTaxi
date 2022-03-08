package uz.zafarbek.datastore.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.zafarbek.datastore.plugs.DataStorePlug
import uz.zafarbek.domain.ports.datastore.DatastorePort
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreModulePort {

    @Singleton
    @Binds
    abstract fun provideDataStorePort(storage: DataStorePlug): DatastorePort
}