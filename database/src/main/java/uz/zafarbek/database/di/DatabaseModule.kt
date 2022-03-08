package uz.zafarbek.database.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.zafarbek.database.data.dao.*
import uz.zafarbek.database.data.database.CyberSecurityDB
import uz.zafarbek.database.util.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun mainDatabase(application: Application): CyberSecurityDB {
        return Room.databaseBuilder(
            application,
            CyberSecurityDB::class.java,
            Constants.CyberSecurityDB
        )
            .fallbackToDestructiveMigration().addCallback(
                object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)

                    }
                }
            ).build()
    }

    @Provides
    @Singleton
    fun courseDao(db: CyberSecurityDB): CourseDao {
        return db.getCourseDao()
    }

    @Provides
    @Singleton
    fun informationDao(db: CyberSecurityDB): InformationDao {
        return db.getInformationDao()
    }

    @Provides
    @Singleton
    fun sectionDao(db: CyberSecurityDB): SectionDao {
        return db.getSectionDao()
    }

    @Provides
    @Singleton
    fun testDao(db: CyberSecurityDB): TestDao {
        return db.getTestDao()
    }

    @Provides
    @Singleton
    fun topicDao(db: CyberSecurityDB): TopicDao {
        return db.getTopicDao()
    }
}