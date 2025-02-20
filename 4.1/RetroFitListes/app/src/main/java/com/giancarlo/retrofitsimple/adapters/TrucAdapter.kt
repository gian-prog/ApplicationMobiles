package com.giancarlo.retrofitsimple.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.giancarlo.retrofitsimple.databinding.TrucItemBinding
import com.giancarlo.retrofitsimple.transfer.Truc

class TrucAdapter : ListAdapter<Truc, TrucAdapter.TrucViewHolder>(TrucDiffCallback) {

    inner class TrucViewHolder(private val binding: TrucItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Truc) {
            binding.tvElement.text = "a: ${item.a}, b: ${item.b}, c: ${item.c}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrucViewHolder {
        val binding: TrucItemBinding = TrucItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrucViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrucViewHolder, position: Int) {
        val item: Truc = getItem(position)
        holder.bind(item)
    }
}

object TrucDiffCallback : DiffUtil.ItemCallback<Truc>() {
    override fun areItemsTheSame(oldItem: Truc, newItem: Truc): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Truc, newItem: Truc): Boolean {
        return oldItem == newItem
    }
}