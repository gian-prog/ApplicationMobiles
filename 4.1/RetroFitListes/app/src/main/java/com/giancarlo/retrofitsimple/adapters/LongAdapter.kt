package com.giancarlo.retrofitsimple.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.giancarlo.retrofitsimple.databinding.LongItemBinding

class LongAdapter : ListAdapter<Long, LongAdapter.LongViewHolder>(LongDiffCallback) {

    inner class LongViewHolder(private val binding: LongItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Long) {
            binding.tvElement.text = item.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LongViewHolder {
        val binding: LongItemBinding = LongItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LongViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LongViewHolder, position: Int) {
        val item: Long = getItem(position)
        holder.bind(item)
    }
}

object LongDiffCallback : DiffUtil.ItemCallback<Long>() {
    override fun areItemsTheSame(oldItem: Long, newItem: Long): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Long, newItem: Long): Boolean {
        return oldItem == newItem
    }
}