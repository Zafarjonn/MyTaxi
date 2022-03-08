package uz.zafarbek.main.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.zafarbek.core.base.BaseViewModel
import uz.zafarbek.domain.repositories.MainRepository
import javax.inject.Inject
import uz.zafarbek.core.R
import uz.zafarbek.domain.data.database.CourseEntity
import uz.zafarbek.domain.data.database.InformationEntity
import uz.zafarbek.domain.data.database.TestEntity
import uz.zafarbek.domain.data.database.TopicEntity
import uz.zafarbek.domain.data.ui.*

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : BaseViewModel() {

    private val _coursesState = MutableLiveData<List<Course>>(emptyList())
    val coursesState: LiveData<List<Course>> = _coursesState

    private val _topicState = MutableLiveData<List<Topic>>(emptyList())
    val topicState: LiveData<List<Topic>> = _topicState

    private val _informationState = MutableLiveData<List<Information>>(emptyList())
    val informationState: LiveData<List<Information>> = _informationState

    private val _testState = MutableLiveData<List<Test>>(emptyList())
    val testState: LiveData<List<Test>> = _testState

    val hasSeenOnBoard = MutableStateFlow<Boolean?>(null)

    fun getAllCourses() = viewModelScope.launch {
        _coursesState.postValue(repository.getCourses())
    }

    fun getTopicsById(ids: List<String>) = viewModelScope.launch {
        _topicState.postValue(repository.getTopic(ids))
    }

    fun getSectionTopics(id: String) = viewModelScope.launch {
        _topicState.postValue(repository.getSectionTopic(id))
    }

    fun getTopicInformation(id:String)=viewModelScope.launch {
        _informationState.postValue(repository.getTopicInformation(id))
    }

    fun getTopicTests(id:String)=viewModelScope.launch {
        _testState.postValue(repository.getTopicTests(id))
    }

    fun insertCourses() = viewModelScope.launch {
        repository.insertCourses(courses)
    }

    fun insertTopics() {
        viewModelScope.launch {
            repository.insertTopics(topics)
        }
    }

    fun insertSections() {
        viewModelScope.launch {
            repository.insertSections(section)
        }
    }

    fun insertInformation() {
        viewModelScope.launch {
            repository.insertInformation(information)
        }
    }

    fun insertTests() = viewModelScope.launch {
        repository.insertTests(tests)
    }

    fun getHasSeenOnBoard() = repository.getHasSeenOnBoarding().onEach {
        hasSeenOnBoard.emit(it)
    }.launchIn(viewModelScope)

    private val courses: List<CourseEntity> = listOf(
        CourseEntity(
            id = "c1",
            title = "Fundamental ma'lumotlar ",
            icon = R.drawable.ic_warning,
            sections = listOf(
                "c1_s1",
                "c1_s2"
            ),
            isCompleted = false
        )
    )

    private val section: List<Section> = listOf(
        Section(
            id = "c1_s1",
            isComplete = false,
            title = "Bugungi raqamli dunyo",
            icon = R.drawable.ic_warning,
            topics = listOf(
                "c1_s1_t1",
                "c1_s1_t2",
                "c1_s1_t3",
                "c1_s1_t4",
                "c1_s1_t5",
                "c1_s1_t6"
            )
        ),
        Section(
            id = "c1_s2",
            isComplete = false,
            title = "Bugungi raqamli dunyo",
            icon = R.drawable.ic_warning,
            topics = listOf(
                "c1_s2_t1",
                "c1_s2_t2",
            )
        ),
    )


    val topics: List<TopicEntity> = listOf(
        TopicEntity(
            id = "c1_s1_t1",
            isComplete = false,
            image = R.drawable.c1_sec1_top1,
            information = listOf(
                "c1_s1_t1_i1",
                "c1_s1_t1_i2",
                "c1_s1_t1_i3",
                "c1_s1_t1_i4",
                "c1_s1_t1_i5"
            ),
            tests = listOf()
        ),
        TopicEntity(
            id = "c1_s1_t2",
            isComplete = false,
            image = R.drawable.c1_sec1_top2,
            information = listOf(
                "c1_s1_t2_i1",
                "c1_s1_t2_i2",
                "c1_s1_t2_i3",
                "c1_s1_t2_i4",
                "c1_s1_t2_i5"
            ),
            tests = listOf()
        ),
        TopicEntity(
            id = "c1_s1_t3",
            isComplete = false,
            image = R.drawable.c1_sec1_top3,
            information = listOf(
                "c1_s1_t3_i1",
                "c1_s1_t3_i2",
                "c1_s1_t3_i3",
            ),
            tests = listOf()
        ),
        TopicEntity(
            id = "c1_s1_t4",
            isComplete = false,
            image = R.drawable.c1_sec1_top4,
            information = listOf(
                "c1_s1_t4_i1",
                "c1_s1_t4_i2",
                "c1_s1_t4_i3",
                "c1_s1_t4_i4",
                "c1_s1_t4_i5",
                "c1_s1_t4_i6",
                "c1_s1_t4_i7",
                "c1_s1_t4_i8"
            ),
            tests = listOf()
        ),
        TopicEntity(
            id = "c1_s1_t5",
            isComplete = false,
            image = R.drawable.c1_sec1_top2,
            information = listOf(
                "c1_s1_t5_i1",
                "c1_s1_t5_i2",
                "c1_s1_t5_i3",
                "c1_s1_t5_i4"
            ),
            tests = listOf()
        ),
        TopicEntity(
            id = "c1_s1_t6",
            isComplete = false,
            image = null,
            information = listOf(),
            tests = listOf(
                "c1_s1_t6_t1"
            )
        ),
//section 2
        TopicEntity(
            id = "c1_s2_t1",
            isComplete = false,
            image = null,
            information = listOf(),
            tests = listOf(
                "c1_s2_t1_t1"
            )
        ),
        TopicEntity(
            id = "c1_s2_t2",
            isComplete = false,
            image = null,
            information = listOf(
                "c1_s2_t2_i1",
                "c1_s2_t2_i2",
                "c1_s2_t2_i3",
                "c1_s2_t2_i4",
            ),
            tests = listOf()
        ),
    )

    private val tests: List<TestEntity> = listOf(
        TestEntity(
            id = "c1_s1_t6_t1",
            question = "Xavfsizlik sifati yoki holati - xavfdan xoli bo'lish bu",
            variants = listOf(
                "Xavfsizlik",
                "Tahdid",
                "Aktiv",
                "Yuqoridagilardan hech qaysisi"
            ),
            correct = "Xavfsizlik",
            isComplete = false
        ),
        TestEntity(
            id = "c1_s2_t1_t1",
            question = "Maxfiy ma'lumotlar sizib chiqmasligini ta'minlash uchun amalga oshirilishi kerak bo'lgan eng mos xavfsizlik maqsadini/xizmatini tanlang.\n" +
                    "To'g'ri javobni tanlang\n",
            variants = listOf("Maxfiylik", "Yaxlitlik", "Mavjudligi", "Repudiation"),
            correct = "Maxfiylik",
            isComplete = false
        )
    )

    private val information: List<InformationEntity> = listOf(
        InformationEntity(
            id = "c1_s1_t1_i1",
            audio = R.raw.c1_s1_t1_i1,
            text = "Texnologiya bugungi dunyoning deyarli barcha jabhalarini qamrab oldi.",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t1_i2",
            audio = R.raw.c1_s1_t1_i2,
            text = "Kechqurundan tonggacha biz raqamli tarzda shug'ullanamiz.",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t1_i3",
            audio = R.raw.c1_s1_t1_i3,
            text = "Uydagi smartfonlardan tortib, barcha kundalik ehtiyojlarimizni qondirish, pul o'tkazmalarini amalga oshirish uchun,",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t1_i4",
            audio = R.raw.c1_s1_t1_i4,
            text = "toziq-ovqat mahsulotlarini to'ldirishga buyurtma berish",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t1_i5",
            audio = R.raw.c1_s1_t1_i5,
            text = "hamma narsa bir marta bosish masofasida",
            isCompleted = false
        ),
        //topic2
        InformationEntity(
            id = "c1_s1_t2_i1",
            audio = R.raw.c1_s1_t2_i1,
            text = "Ish joyidagi odatiy kun intranet/internet serverlariga ulanishni o'z ichiga oladi.",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t2_i2",
            audio = R.raw.c1_s1_t2_i2,
            text = "Dam olish kunlaridagi dam olish kunlarida mehmonlar mijozning buyurtmasini planshet orqali qabul qilishni o'z ichiga oladi.",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t2_i3",
            audio = R.raw.c1_s1_t2_i3,
            text = "Mijoz hisobni kredit/debet karta orqali to'laydi",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t2_i4",
            audio = R.raw.c1_s1_t2_i4,
            text = "Ushbu operatsiyalarning barchasi Internetga kirishni o'z ichiga oladi.",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t2_i5",
            audio = R.raw.c1_s1_t2_i5,
            text = "Shu sababli, har bir kishi raqamli ma'lumotlardan foydalanish va uni himoya qilish bilan bog'liq xavflardan xabardor bo'lishi muhimdir.",
            isCompleted = false
        ),

        //topic3
        InformationEntity(
            id = "c1_s1_t3_i1",
            audio = R.raw.c1_s1_t3_i1,
            text = "Bugungi kunda onlayn ilovalarga ish stoli kompyuterlari, noutbuklar, mobil telefonlar va boshqalar orqali kirish mumkin.",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t3_i2",
            audio = R.raw.c1_s1_t3_i2,
            text = "Ushbu ilovalar bir-biriga juda bog'langan.",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t3_i3",
            audio = R.raw.c1_s1_t3_i3,
            text = "Ularning kirish qulayligi ularni zaif qiladi",
            isCompleted = false
        ),
        //topic4
        InformationEntity(
            id = "c1_s1_t4_i1",
            audio = R.raw.c1_s1_t4_i1,
            text = "Masalan, xuddi shu uyali telefondan foydalanuvchi ijtimoiy tarmoq veb-saytidagi holatini yangilashi mumkin",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t4_i2",
            audio = R.raw.c1_s1_t4_i2,
            text = "U keyingi daqiqada onlayn tarzda pul o'tkazishi mumkin",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t4_i3",
            audio = R.raw.c1_s1_t4_i3,
            text = "U davlat ma'lumotlar bazasidan shaxsiy identifikatsiya ma'lumotlariga kirish uchun xuddi shu uyali telefondan foydalanishi mumkin.",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t4_i4",
            audio = R.raw.c1_s1_t4_i4,
            text = "Bundan tashqari, u turli xil bank, ijtimoiy tarmoq ilovalari va hokazolarda ro'yxatdan o'tish uchun bir xil elektron pochta hisobidan foydalanishi mumkin",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t4_i5",
            audio = R.raw.c1_s1_t4_i5,
            text = "Ushbu hisobning zaif paroli xakerlar uchun vasvasadir",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t4_i6",
            audio = R.raw.c1_s1_t4_i6,
            text = "Ushbu elektron pochta hisobiga kirish orqali ular ushbu hisob bilan bog'langan boshqa ilovalarga kirishlari mumkin..",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t4_i7",
            audio = R.raw.c1_s1_t4_i7,
            text = "Shuningdek, foydalanuvchini maxfiy ma'lumotlarni oshkor qilishga undash uchun ushbu hisob orqali spam-xat yuborilishi mumkin, bu esa tajovuzkorga uning bank ilovasiga kirishiga yordam beradi.",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t4_i8",
            audio = R.raw.c1_s1_t4_i8,
            text = "Zaif elektron pochta hisobi boshqa ilovalarni ham himoyasiz qilishi mumkin.",
            isCompleted = false
        ),
        //topic5
        InformationEntity(
            id = "c1_s1_t5_i1",
            audio = R.raw.c1_s1_t5_i1,
            text = "Xavfsizlik nima?",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t5_i2",
            audio = R.raw.c1_s1_t5_i2,
            text = "Mutlaq xavfsizlik degan narsa yo'q",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t5_i3",
            audio = R.raw.c1_s1_t5_i3,
            text = "Xavfsizlik sifati yoki holati",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s1_t5_i4",
            audio = R.raw.c1_s1_t5_i4,
            text = "Kiberxavfsizlik - bu internetga ulangan tizimlarni, jumladan apparat, dasturiy ta'minot va ma'lumotlarni kiberhujumlardan himoya qilish.",
            isCompleted = false
        ),
        //cor2 top2
        InformationEntity(
            id = "c1_s2_t2_i1",
            audio = R.raw.c1_s2_t2_i1,
            text = "Korxonalar strategik tashabbuslarni amalga oshirish va innovatsiyalarni osonlashtirish uchun mobil va bulut kabi yangi texnologiyalardan tobora ko'proq foydalanmoqda",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s2_t2_i2",
            audio = R.raw.c1_s2_t2_i2,
            text = "Garchi ushbu tashabbuslar biznes uchun ko'plab imtiyozlarni taqdim etsa-da, yangi rivojlanayotgan texnologiya landshafti, shuningdek, nozik korporativ ma'lumotlarga tahdid soladigan jiddiy xavfsizlik xavflarini ham keltirib chiqarishi mumkin.",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s2_t2_i3",
            audio = R.raw.c1_s2_t2_i3,
            text = "Xavfsizlik triadasi:",
            isCompleted = false
        ),
        InformationEntity(
            id = "c1_s2_t2_i4",
            audio = R.raw.c1_s2_t2_i4,
            text = "Maxfiylik, yaxlitlik, mavjudlik",
            isCompleted = false
        )
    )

}