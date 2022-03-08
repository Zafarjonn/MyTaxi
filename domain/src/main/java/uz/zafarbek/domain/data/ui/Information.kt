package uz.zafarbek.domain.data.ui

import androidx.recyclerview.widget.DiffUtil

data class Information(
    val id: String,
    val audio: Int,
    val text: String,
    val isCompleted: Boolean
){
    companion object {
        object Comparator : DiffUtil.ItemCallback<Information>() {
            override fun areItemsTheSame(oldItem: Information, newItem: Information): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Information, newItem: Information): Boolean {
                return oldItem == newItem
            }
        }
    }
}

