package uz.zafarbek.domain.repositories

import android.util.Log
import uz.zafarbek.domain.data.database.CourseEntity
import uz.zafarbek.domain.data.database.InformationEntity
import uz.zafarbek.domain.data.database.TestEntity
import uz.zafarbek.domain.data.database.TopicEntity
import uz.zafarbek.domain.data.ui.*
import uz.zafarbek.domain.mappers.CourseEMMapper
import uz.zafarbek.domain.mappers.InformationEMMapper
import uz.zafarbek.domain.mappers.TopicsEMMapper
import uz.zafarbek.domain.ports.database.*
import uz.zafarbek.domain.ports.datastore.DatastorePort
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val coursePort: DatabaseCoursePort,
    private val informationPort: DatabaseInformationPort,
    private val sectionPort: DatabaseSectionPort,
    private val testPort: DatabaseTestPort,
    private val topicPort: DatabaseTopicPort,
    private val datastorePort: DatastorePort,
    private val topicsEMMapper: TopicsEMMapper,
    private val courseEMMapper: CourseEMMapper,
    private val informationEMMapper: InformationEMMapper
) {

    suspend fun getCourses(): List<Course> {

        val courses = coursePort.getAll()

        return courses.map {
            val sections = sectionPort.getById(*it.sections?.toTypedArray() ?: arrayOf())
            sections.size
            it.toUi().copy(sections = sections.map { it.toUi() })
        }
    }

    suspend fun getTopic(ids: List<String>): List<Topic> {

        return topicPort.getById(*ids.toTypedArray()).map { topic ->
            val informations =
                informationPort.getById(*topic.information?.toTypedArray() ?: arrayOf())
                    .map { it.toUi() }
            val tests =
                testPort.getById(*topic.tests?.toTypedArray() ?: arrayOf()).map { it.toUi() }

            topic.toUi().copy(information = informations, tests = tests)
        }
    }

    suspend fun getSectionTopic(id: String): List<Topic> {

        val topicIds = sectionPort.getById(id).getOrNull(0)?.topics ?: listOf()

        return topicPort.getById(*topicIds.toTypedArray()).map { topic ->
            val informations =
                informationPort.getById(*topic.information?.toTypedArray() ?: arrayOf())
                    .map { it.toUi() }
            val tests =
                testPort.getById(*topic.tests?.toTypedArray() ?: arrayOf()).map { it.toUi() }

            topic.toUi().copy(information = informations, tests = tests)
        }
    }

    suspend fun getTopicInformation(id: String):List<Information>{
        val informationIds=topicPort.getById(id).getOrNull(0)?.information?: listOf()

        return informationPort.getById(*informationIds.toTypedArray()).map {information->
            information.toUi()
        }
    }

    suspend fun getTopicTests(id: String):List<Test>{
        val testIds=topicPort.getById(id).getOrNull(0)?.tests?: listOf()

        return testPort.getById(*testIds.toTypedArray()).map {test->
            test.toUi()
        }
    }

    suspend fun getInformation(): List<Information> {
        val information = informationPort.getAll()
        return informationEMMapper.mapFromEntityList(information)
    }

    suspend fun insertCourses(course: List<CourseEntity>) {
        coursePort.insertAll(course)
    }

    suspend fun insertTopics(topics: List<TopicEntity>) {
        topicPort.insertAllTopics(topics)
    }

    suspend fun insertSections(section: List<Section>) {
        sectionPort.insertAll(section)
    }

    suspend fun insertInformation(information: List<InformationEntity>) {
        informationPort.insertAll(information)
    }

    suspend fun insertTests(test: List<TestEntity>) {
        testPort.insertAll(test)
    }

    fun getHasSeenOnBoarding() = datastorePort.getHasSeenOnBoard()

//    suspend fun getTopic(id: String): Topic {
//        return coursePort.getAll()
//    }
}