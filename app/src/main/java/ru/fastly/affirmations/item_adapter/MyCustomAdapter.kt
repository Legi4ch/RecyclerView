package ru.fastly.affirmations.item_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.fastly.affirmations.databinding.ListItemBinding
import ru.fastly.affirmations.model.Affirmation

class MyCustomAdapter (
    private val context: Context,
    private val dataset: List<Affirmation>,
    private var onItemClicked: ((item:Affirmation)->Unit)
    ):RecyclerView.Adapter<MyCustomAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataset[position])

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    inner class ItemViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (item: Affirmation) = binding.apply {
            itemTitle.text = context.resources.getString(item.stringResourceId)
            itemImage.setImageResource(item.imageResourceId)
            root.setOnClickListener { onItemClicked(item) }
        }
    }


}