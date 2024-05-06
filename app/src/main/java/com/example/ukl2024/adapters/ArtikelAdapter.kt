package com.example.ukl2024.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ukl2024.databinding.ArtikelItemLayoutBinding
import com.example.ukl2024.models.ArtikelModel

class ArtikelAdapter (val onClick : (ArtikelModel) -> Unit, val artikelList : ArrayList<ArtikelModel>) : RecyclerView.Adapter<ArtikelAdapter.ArtikelViewHolder>() {
    inner class ArtikelViewHolder (val binding : ArtikelItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ArtikelModel) {
            binding.apply {
                image.setImageResource(item.image)
                tvNama.text = item.nama
                root.setOnClickListener {
                    onClick(item)
                }
            }
        }

    }

    val artikels : MutableList<ArtikelModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtikelViewHolder {
        val binding = ArtikelItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtikelViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artikelList.size
    }

    override fun onBindViewHolder(holder: ArtikelViewHolder, position: Int) {
        holder.bind(artikelList[position])
    }

}