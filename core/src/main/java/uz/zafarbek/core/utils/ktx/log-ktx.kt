package uz.zafarbek.core.utils.ktx

import android.util.Log

fun loggerD(message: Any?) {
    Log.d("APP_DEBUG", message.toString())
}

fun loggerE(message: Any?) {
    Log.e("APP_ERROR", message.toString())
}

fun loggerW(message: Any?) {
    Log.w("APP_WARNING", message.toString())
}

fun String.print() {
    Log.d("PRINT_LOG", this)
}