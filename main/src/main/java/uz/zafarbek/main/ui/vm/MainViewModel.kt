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
import uz.zafarbek.domain.data.ui.*

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : BaseViewModel() {

    private val _coursesState = MutableLiveData<List<Course>>(emptyList())
    val coursesState: LiveData<List<Course>> = _coursesState


    val hasSeenOnBoard = MutableStateFlow<Boolean?>(null)


    fun getHasSeenOnBoard() = repository.getHasSeenOnBoarding().onEach {
        hasSeenOnBoard.emit(it)
    }.launchIn(viewModelScope)

    val courses: List<Order> = listOf(
//        Order()
    )


}