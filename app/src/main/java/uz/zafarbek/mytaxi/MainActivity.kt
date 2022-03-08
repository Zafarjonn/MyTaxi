package uz.zafarbek.mytaxi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.zafarbek.mytaxi.R
import uz.zafarbek.mytaxi.databinding.ActivityMainBinding
import uz.zafarbek.navigation.Direction
import uz.zafarbek.navigation.Navigate
import uz.zafarbek.navigation.Navigator

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Navigator {

    private val binding: ActivityMainBinding by viewBinding()

    private lateinit var navController: NavController

    private val navigator = Navigate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.navController
        navigator.navController = navController

    }

    override fun navigate(direction: Direction, args: Any?, toRight: Boolean?) {
        navigator.navigate(direction, args, toRight)
    }
}