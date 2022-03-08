package uz.zafarbek.main.ui.enums

import uz.zafarbek.main.R


enum class HomeType(val value:String, val text:Int){
    INDEX("index", R.string.index),
    DESCRIPTION("Description",R.string.description);

    companion object{
        fun findByValue(value: String) = values().find { it.value==value }?:INDEX
    }
}