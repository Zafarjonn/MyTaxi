package uz.zafarbek.core.utils.ktx

import kotlinx.coroutines.flow.MutableStateFlow

fun <T> MutableStateFlow<T?>.set(value: T, default: T? = null) {
    this.value = value
    this.value = default
}
