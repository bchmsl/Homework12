package com.bchmsl.homework12.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bchmsl.homework12.databinding.LayoutItemBinding
import com.bchmsl.homework12.extensions.toEuro
import com.bchmsl.homework12.model.Model

class ModelsAdapter : ListAdapter<Model, ModelsAdapter.ModelViewHolder>(ModelCallback()) {
    var onItemClickListener : ((Model) -> Unit)? = null
    inner class ModelViewHolder(private val binding: LayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val currentItem = currentList[adapterPosition]
            binding.apply {
                tvModel.text = currentItem.fullModelName
                tvPrice.text = currentItem.price?.toEuro() ?: "Price coming soon"
                ivImage.setImageResource(currentItem.image)
                root.setOnClickListener { onItemClickListener?.invoke(currentItem) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        return ModelViewHolder(
            LayoutItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bind()
    }

    class ModelCallback : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Model, newItem: Model) = oldItem == newItem
    }
}