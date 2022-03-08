package uz.zafarbek.core.utils.ktx

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import uz.zafarbek.core.R


@SuppressLint("QueryPermissionsNeeded")
fun Context.composeEmail(subject: String) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        type = "text/plain"
        data = Uri.parse("mailto:")
        putExtra(Intent.EXTRA_EMAIL, "")
        putExtra(Intent.EXTRA_SUBJECT, subject)
    }
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(Intent.createChooser(intent, getString(R.string.continue_via)))
    } else Toast.makeText(this, "No app found to handle this operation", Toast.LENGTH_SHORT).show()
}

fun Context.composeMmsMessage(message: String) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse("sms:")  // This ensures only SMS apps respond
        putExtra("sms_body", message)
    }
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(Intent.createChooser(intent, getString(R.string.continue_via)))
    } else Toast.makeText(this, "No app found to handle this operation", Toast.LENGTH_SHORT).show()
}

fun Context.composeAll(message: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "*/*"
        putExtra(Intent.EXTRA_SUBJECT, message)
    }
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(Intent.createChooser(intent, getString(R.string.continue_via)))
    } else Toast.makeText(this, "No app found to handle this operation", Toast.LENGTH_SHORT).show()
}

fun Context.composeCall(phoneNumber: String) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse("tel:$phoneNumber")
    }
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(Intent.createChooser(intent, getString(R.string.continue_via)))
    } else Toast.makeText(this, "No app found to handle this operation", Toast.LENGTH_SHORT).show()
}

fun Context.openWebPage(url: String) {
    val uri: Uri = Uri.parse(url)
    val intent = Intent(Intent.ACTION_VIEW, uri)
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(Intent.createChooser(intent, getString(R.string.continue_via)))
    } else Toast.makeText(this, "No app found to handle this operation", Toast.LENGTH_SHORT).show()
}

fun Activity?.hideKeyboard() = this?.currentFocus?.let {
    val inputManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(it.windowToken, 0)
}

fun EditText?.showKeyboard() = this?.let {
    val inputManager =
        this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.showSoftInput(this, InputMethodManager.SHOW_FORCED)
}

//fun Context.shareRoute(destination: LocationEntity) {
//    val uri = formMapUrl(destination.latitude, destination.longitude, 300, 200, 15)
//    val intent = Intent(Intent.ACTION_SEND).apply {
//        type = "*/*"
//        putExtra(Intent.EXTRA_TEXT, uri)
//    }
//    if (intent.resolveActivity(packageManager) != null) {
//        startActivity(Intent.createChooser(intent, getString(R.string.continue_via)))
//    } else Toast.makeText(this, "No app found to handle this operation", Toast.LENGTH_SHORT).show()
//}

//fun formMapUrl(
//    lat: Double,
//    lon: Double,
//    width: Int,
//    height: Int,
//    zoom: Int,
//): String {
//    val density = 1f
//    val scale = 2.coerceAtMost(ceil(density.toDouble()).toInt())
//    val k: String = getString(R.string.maps_api_key)
//    return if (!TextUtils.isEmpty(k)) {
//        String.format(Locale.US,
//            "https://maps.googleapis.com/maps/api/staticmap?center=%.6f,%.6f&zoom=%d&size=%dx%d&maptype=roadmap&scale=%d&key=%s",
//            lat,
//            lon,
//            zoom,
//            width,
//            height,
//            scale,
//            k)
//    } else {
//        String.format(Locale.US,
//            "https://maps.googleapis.com/maps/api/staticmap?center=%.6f,%.6f&zoom=%d&size=%dx%d&maptype=roadmap&scale=%d",
//            lat,
//            lon,
//            zoom,
//            width,
//            height,
//            scale)
//    }
//}
