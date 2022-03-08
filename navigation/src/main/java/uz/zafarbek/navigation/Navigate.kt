package uz.zafarbek.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import uz.zafarbek.core.R

class Navigate {

    lateinit var navController: NavController

    private val navBuilder = NavOptions.Builder()

    fun navigate(direction: Direction, args: Any? = null, toRight: Boolean? = null) {
        if (toRight != null) {
            if (toRight)
                navBuilder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left)
                    .setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right)
                    .setPopUpTo(uz.zafarbek.navigation.R.id.app_nav_graph, true)
            else
                navBuilder.setEnterAnim(R.anim.slide_in_left).setExitAnim(R.anim.slide_out_right)
                    .setPopEnterAnim(R.anim.slide_in_right).setPopExitAnim(R.anim.slide_out_left)
                    .setPopUpTo(uz.zafarbek.navigation.R.id.app_nav_graph, true)
        } else {
            navBuilder.setPopUpTo(uz.zafarbek.navigation.R.id.app_nav_graph, true)
        }
        when (direction) {
            Direction.Main -> {
                navController.navigate(AppNavGraphDirections.toMain(), navBuilder.build())
            }
            Direction.Entrance -> {
                navController.navigate(AppNavGraphDirections.toEntrance(), navBuilder.build())
            }
        }

    }
}