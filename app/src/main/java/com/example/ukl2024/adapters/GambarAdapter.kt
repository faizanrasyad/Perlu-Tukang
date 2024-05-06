package com.example.ukl2024.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ukl2024.databinding.GambarItemLayoutBinding
import com.example.ukl2024.fragments.BerandaFrag
import com.example.ukl2024.models.GambarModel
import kotlinx.coroutines.withContext

class GambarAdapter (val onClick : (GambarModel) -> Unit, val gambarList : ArrayList<GambarModel>) : RecyclerView.Adapter<GambarAdapter.GambarViewHolder>(){
    inner class GambarViewHolder(val binding : GambarItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GambarModel) {
            binding.apply {
                image.setImageResource(item.titleImage)
                root.setOnClickListener {
                    onClick(item)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GambarViewHolder {
        val binding = GambarItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GambarViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return gambarList.size
    }

    override fun onBindViewHolder(holder: GambarViewHolder, position: Int) {
        holder.bind(gambarList[position])
    }
}