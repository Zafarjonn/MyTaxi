package uz.zafarbek.core.utils.ktx

import android.app.DatePickerDialog
import androidx.fragment.app.Fragment
import uz.zafarbek.core.R
import uz.zafarbek.core.utils.Time
import java.text.SimpleDateFormat
import java.util.*


fun Fragment.showDatePicker(
    date: Time = Time(),
    minDate: Time? = null,
    maxDate: Time? = null,
    title: String? = null,
    onDateSelected: (year: Int, month: Int, day: Int) -> Unit
) {
    DatePickerDialog(
        requireContext(),
        R.style.DatePickerTheme,
        { _, y, m, d -> onDateSelected(y, m, d) },
        date.year,
        date.month,
        date.day
    ).apply {
        minDate?.let {
            datePicker.minDate = minDate.timeInMillis()
        }
        maxDate?.let {
            datePicker.maxDate = maxDate.timeInMillis()
        }
        title?.let {
            setMessage(title)
        }
    }.show()
}
fun String?.formatToLongDate(simpleDateFormat: SimpleDateFormat): Long {
    this?.let {
        if (it.isEmpty()) return -1
        return simpleDateFormat.parse(it)?.time ?: 0
    } ?: run {
        return -1
    }
}
fun getYear() = Calendar.getInstance().get(Calendar.YEAR)

fun getMonth() = Calendar.getInstance().get(Calendar.MONTH)

fun getDay() = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

fun getHour() = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

fun getMinute() = Calendar.getInstance().get(Calendar.MINUTE)
