package uz.zafarbek.navigation

interface Navigator {
    fun navigate(direction: Direction, args: Any? = null, toRight: Boolean? = null)
}