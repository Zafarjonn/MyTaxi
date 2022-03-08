package uz.zafarbek.main.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.observeOn
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.core.utils.ktx.OnActionListener
import uz.zafarbek.domain.data.ui.Course
import uz.zafarbek.main.R
import uz.zafarbek.main.databinding.FragmentIndexBinding
import uz.zafarbek.main.ui.adapter.CoursesAdapter

import uz.zafarbek.main.ui.enums.HomeType
import uz.zafarbek.main.ui.vm.MainViewModel


@AndroidEntryPoint
class IndexFragment : BaseFragment(R.layout.fragment_index) {

    override val viewModel: MainViewModel by viewModels()
    private lateinit var type: HomeType
    private val binding: FragmentIndexBinding by viewBinding()
    private val adapter = CoursesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllCourses()
        binding.recyclerCourses.adapter = adapter
        viewModel.getHasSeenOnBoard()
        insertData()
        adapter.onClick = OnActionListener {
            navigate(MainFragmentDirections.actionMainFragmentToTeachingFragment(it.id))
        }
    }

    private fun insertData(){
        if (viewModel.hasSeenOnBoard.value == true){
            viewModel.insertTests()
            viewModel.insertInformation()
            viewModel.insertTopics()
            viewModel.insertSections()
            viewModel.insertCourses()
        }

    }

    private val getCoursesObserver=Observer<List<Course>>{
        adapter.submitList(it)
    }

    override fun onResume() {
        super.onResume()
        viewModel.coursesState.observe(viewLifecycleOwner,getCoursesObserver)
    }


    companion object {
        fun instance(type: HomeType) = IndexFragment().apply {
            this.type = type
        }
    }
}