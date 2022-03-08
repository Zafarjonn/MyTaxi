package uz.zafarbek.core.utils

import uz.zafarbek.core.utils.ktx.*
import java.text.SimpleDateFormat
import java.util.*

class Time(
    var year: Int = getYear(),
    var month: Int = getMonth(),
    var day: Int = getDay(),
    var hour: Int = getHour(),
    var minute: Int = getMinute(),
    var second: Int = 0
) {

    private val calendar = GregorianCalendar(TimeZone.getDefault())

    init {
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, day)
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, second)
    }

    private val dateFormat =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())

    private val simpleDateFormat =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    fun toRemoteString(): String {
        return dateFormat.format(calendar.timeInMillis - calendar.get(Calendar.ZONE_OFFSET))
    }

    fun toSimpleString(): String {
        return simpleDateFormat.format(calendar.timeInMillis)
    }

    fun timeInMillis(): Long = calendar.timeInMillis

    fun add(param: Int, amount: Int) {
        calendar.add(param, amount)
    }

    fun minus(param: Int, amount: Int) {
        calendar.add(param, -1 * amount)
    }
}

fun String.toTime(): Time {
    val date = GregorianCalendar(TimeZone.getDefault())
    this.let {
        val dateFormat =
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        if (it.isEmpty()) return Time(
            year = date.get(Calendar.YEAR),
            month = date.get(Calendar.MONTH),
            day = date.get(Calendar.DAY_OF_MONTH),
            hour = date.get(Calendar.HOUR_OF_DAY),
            minute = date.get(Calendar.MINUTE),
            second = date.get(Calendar.SECOND)
        )
        date.timeInMillis = (dateFormat.parse(it)?.time ?: 0) + date.get(Calendar.ZONE_OFFSET)
        return Time(
            year = date.get(Calendar.YEAR),
            month = date.get(Calendar.MONTH),
            day = date.get(Calendar.DAY_OF_MONTH),
            hour = date.get(Calendar.HOUR_OF_DAY),
            minute = date.get(Calendar.MINUTE),
            second = date.get(Calendar.SECOND)
        )
    }
}

fun String.toSimpleTime(): Time {
    val date = GregorianCalendar(TimeZone.getDefault())
    this.let {
        val dateFormat =
            SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        if (it.isEmpty()) return Time(
            year = date.get(Calendar.YEAR),
            month = date.get(Calendar.MONTH),
            day = date.get(Calendar.DAY_OF_MONTH),
            hour = date.get(Calendar.HOUR_OF_DAY),
            minute = date.get(Calendar.MINUTE),
            second = date.get(Calendar.SECOND)
        )
        date.timeInMillis = dateFormat.parse(it)?.time ?: 0
        return Time(
            year = date.get(Calendar.YEAR),
            month = date.get(Calendar.MONTH),
            day = date.get(Calendar.DAY_OF_MONTH),
            hour = date.get(Calendar.HOUR_OF_DAY),
            minute = date.get(Calendar.MINUTE),
            second = date.get(Calendar.SECOND)
        )
    }
}

fun Long.toTime(): Time {
    val date = GregorianCalendar(TimeZone.getDefault())
    date.timeInMillis = this
    return Time(
        year = date.get(Calendar.YEAR),
        month = date.get(Calendar.MONTH),
        day = date.get(Calendar.DAY_OF_MONTH),
        hour = date.get(Calendar.HOUR_OF_DAY),
        minute = date.get(Calendar.MINUTE),
        second = date.get(Calendar.SECOND)
    )
}

val Time.regularMonth
    get() = month + 1
