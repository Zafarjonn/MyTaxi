package uz.zafarbek.main.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class MainVH( binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(position: Int)
}