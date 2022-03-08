package uz.zafarbek.core.utils.ktx

import android.content.Context
import android.graphics.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import uz.zafarbek.core.R
import java.util.*

fun Context.createImage(
    width: Int = 200,
    height: Int = 200,
    color: Int = R.color.black,
    firstName: String?,
    lastName: String?
): Bitmap? {
    val internalWidth = if (width == 0) 200 else width
    val internalHeight = if (height == 0) 200 else height

    val bitmap = Bitmap.createBitmap(
        internalWidth,
        internalHeight,
        Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    val paint2 = Paint()
    paint2.color = ContextCompat.getColor(this, color)
    canvas.drawRect(0f, 0f, internalWidth.toFloat(), internalHeight.toFloat(), paint2)
    val paint = Paint()
    paint.color = Color.WHITE
    paint.textSize = internalWidth / 3f
    val bold = ResourcesCompat.getFont(this, R.font.internal_noto_sans_jp_bold)
    paint.typeface = bold
    paint.textScaleX = 1f
    var internalFirstName = " "
    var internalLastName = " "
    if (firstName?.isNotBlank() == true) internalFirstName = firstName
    if (lastName?.isNotBlank() == true) internalLastName = lastName
    val text = "${internalFirstName.first().uppercase()}${internalLastName.first().uppercase()}"
    val bounds = Rect()
    paint.isAntiAlias = true
    paint.getTextBounds(text, 0, text.length, bounds)
    canvas.drawText(
        text,
        (internalWidth / 2f) - (bounds.width() / 2),
        (internalHeight / 2f) + (bounds.height() / 2),
        paint
    )
    return bitmap
}

fun Context.clearGlideMemory() {
    Glide.get(this).clearMemory()
}


fun Context.clearGlideDiskCache() {
    Glide.get(this).clearDiskCache()
}