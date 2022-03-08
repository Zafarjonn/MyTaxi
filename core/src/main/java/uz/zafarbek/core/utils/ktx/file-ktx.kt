package uz.zafarbek.core.utils.ktx

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.OpenableColumns
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


const val additionalInfoFileName = "additional_info_file_name"

fun Uri.toContent(context: Context): File? {
    val resolver = context.contentResolver

    val cursor = resolver.query(this, null, null, null, null)
    cursor?.moveToFirst()
    val index = (cursor?.getColumnIndex(OpenableColumns.DISPLAY_NAME)) ?: -1
    val name = cursor?.getString(index) ?: "CONTENT_NAME"
    cursor?.close()

    val file = File(context.filesDir, name)
    val out = FileOutputStream(file)
    val ins = resolver.openInputStream(this) ?: return null

    ins.copyTo(out)
    ins.close()
    out.close()

    return file
}

fun Uri.getFileName(context: Context): String {
    val resolver = context.contentResolver
    val cursor = resolver.query(this, null, null, null, null)
    cursor?.moveToFirst()
    val index = (cursor?.getColumnIndex(OpenableColumns.DISPLAY_NAME)) ?: -1
    val name = cursor?.getString(index) ?: additionalInfoFileName
    cursor?.close()
    return name
}

fun Uri.writeAdditionalInfoFile(context: Context): File? {
    val resolver = context.contentResolver

    val cursor = resolver.query(this, null, null, null, null)
    cursor?.moveToFirst()
    val name = "$additionalInfoFileName.${resolver.getType(this)?.split("/")?.last()}"
    cursor?.close()

    val file = File(context.filesDir, name)
    val out = FileOutputStream(file)
    val ins = resolver.openInputStream(this) ?: return null

    ins.copyTo(out)
    ins.close()
    out.close()

    return file
}

fun Context.getAdditionalInfoFile(extension: String): File? {
    val file: File = File(filesDir, "$additionalInfoFileName.$extension")
    return if (file.exists()) file else null
}

fun InputStream.toContent(context: Context, extension: String): File {
    use {
        val file: File = File(context.filesDir, "$additionalInfoFileName.$extension")
        FileOutputStream(file).use { output ->
            val buffer = ByteArray(4 * 1024)
            var read: Int
            while (read(buffer).also { read = it } != -1) {
                output.write(buffer, 0, read)
            }
            output.flush()
        }
        return file
    }
}

fun Context.clearInternalCache() {
    val dir: File = filesDir
    if (dir.isDirectory) {
        val children: Array<String>? = dir.list()
        for (i in children?.indices ?: 0..0) {
            children?.get(i)?.let {
                File(dir, it).delete()
            }
        }
    }
}

fun openFile(activity: Activity, selectedItem: File) {
    val uri = FileProvider.getUriForFile(
        activity.applicationContext,
        activity.packageName + ".fileprovider",
        selectedItem
    )
    val mime: String? = activity.contentResolver.getType(uri)

    val intent = Intent()
    intent.action = Intent.ACTION_VIEW
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    intent.setDataAndType(uri, mime)
    return activity.startActivity(intent)
}