package uz.zafarbek.navigation.ktx

import androidx.fragment.app.Fragment
import uz.zafarbek.navigation.Navigator

val Fragment.navController: Navigator
    get() = activity as Navigator