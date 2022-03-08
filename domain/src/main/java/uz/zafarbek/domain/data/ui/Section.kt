package uz.zafarbek.domain.data.ui

import androidx.recyclerview.widget.DiffUtil

data class Section(
    val id: String,
    val isComplete: Boolean,
    val title: String,
    val icon: Int,
    val topics: List<String>?,
) {
    companion object {
        object Comparator : DiffUtil.ItemCallback<Section>() {
            override fun areItemsTheSame(oldItem: Section, newItem: Section): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Section, newItem: Section): Boolean {
                return oldItem == newItem
            }
        }
    }
}
