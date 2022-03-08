package uz.zafarbek.core.utils.ktx

import android.content.Context
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addDivider(context: Context? = null) {
    val dividerItemDecoration = DividerItemDecoration(
        context ?: this.context,
        LinearLayoutManager.VERTICAL
    )
    addItemDecoration(dividerItemDecoration)
}

inline fun <reified T : RecyclerView.ViewHolder> RecyclerView.forEachVisibleHolder(
    action: (T) -> Unit
) {
    for (i in 0 until childCount) {
        action(getChildViewHolder(getChildAt(i)) as T)
    }
}
