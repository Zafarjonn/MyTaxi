package uz.zafarbek.main.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.zafarbek.core.utils.ktx.inflater
import uz.zafarbek.main.databinding.ItemSettingMarginBinding
import uz.zafarbek.main.databinding.ItemSettingsBinding
import uz.zafarbek.main.ui.enums.SettingsItems

class SettingsAdapter: RecyclerView.Adapter<MainVH>() {
    private val data = SettingsItems.values()
    private var listener: ((SettingsItems) -> Unit)? = null
    private var context: Context? = null
    inner class SettingsVH(private val binding: ItemSettingsBinding) : MainVH(binding) {
        override fun bind(position: Int) = with(binding) {
            val item = data[position]
            text.text = item.text?.let { context?.getString(it) }
            nextText.visibility= View.GONE
            item.nextText?.let {
                nextText.text = it
                nextText.visibility= View.VISIBLE
                chevron.visibility= View.GONE
            }
            binding.root.setOnClickListener {
                listener?.invoke(item)
            }
        }
    }

    inner class SeparatorVH( binding: ItemSettingMarginBinding) : MainVH(binding) {
        override fun bind(position: Int) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVH {
        context = parent.context;
        return if (viewType == 1)  SettingsVH(
            ItemSettingsBinding.inflate(
                parent.inflater(),
                parent,
                false
            )
        )
        else SeparatorVH(ItemSettingMarginBinding.inflate(parent.inflater(), parent, false))
    }

    override fun onBindViewHolder(holder: MainVH, position: Int) = holder.bind(position)

    override fun getItemCount(): Int = data.size

    fun setListener(listener: (SettingsItems) -> Unit) {
        this.listener = listener
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position].text == null) return 2 else 1
    }
}