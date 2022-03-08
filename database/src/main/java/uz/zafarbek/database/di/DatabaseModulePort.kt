package uz.zafarbek.database.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.zafarbek.database.port.*
import uz.zafarbek.domain.ports.database.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModulePort {

    @Singleton
    @Binds
    abstract fun provideCourseDatabasePort(plug: CoursePlug): DatabaseCoursePort

    @Singleton
    @Binds
    abstract fun provideInformationDatabasePort(plug: InformationPlug): DatabaseInformationPort

    @Singleton
    @Binds
    abstract fun provideSectionDatabasePort(plug: SectionPlug): DatabaseSectionPort

    @Singleton
    @Binds
    abstract fun provideTestDatabasePort(plug: TestPlug): DatabaseTestPort

    @Singleton
    @Binds
    abstract fun provideTopicDatabasePort(plug: TopicPlug): DatabaseTopicPort
}