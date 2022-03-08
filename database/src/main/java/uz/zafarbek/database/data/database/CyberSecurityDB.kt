package uz.zafarbek.database.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import uz.zafarbek.database.data.dao.*
import uz.zafarbek.database.util.Converters
import uz.zafarbek.domain.data.database.*

@Database(
    entities = [
        CourseEntity::class,
        InformationEntity::class,
        SectionEntity::class,
        TestEntity::class,
        TopicEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class CyberSecurityDB : RoomDatabase() {

    abstract fun getCourseDao(): CourseDao

    abstract fun getInformationDao(): InformationDao

    abstract fun getSectionDao(): SectionDao

    abstract fun getTestDao(): TestDao

    abstract fun getTopicDao(): TopicDao

}


