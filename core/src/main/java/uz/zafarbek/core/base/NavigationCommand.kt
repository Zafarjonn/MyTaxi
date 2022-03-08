package uz.zafarbek.core.base

import androidx.navigation.NavDirections
import androidx.navigation.Navigator

data class NavigationCommand(
    val direction: NavDirections,
    val navExtras: Navigator.Extras? = null
)