package com.example.ukl2024.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ukl2024.databinding.JasaItemLayoutBinding
import com.example.ukl2024.models.JasaModel

class JasaAdapter (val onCLick : (JasaModel) -> Unit, val jasaList : ArrayList<JasaModel>) : RecyclerView.Adapter<JasaAdapter.JasaViewHolder>() {
    inner class JasaViewHolder(val binding : JasaItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: JasaModel) {
            binding.apply {
                tvNama.text = item.nama
                tvJarak.text = "(${item.jarak} Km)"
                tvAlamat.text = item.alamat
                root.setOnClickListener {
                    onCLick(item)
                }
            }
        }

    }

    val jasas : MutableList<JasaModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JasaViewHolder {
        val binding = JasaItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JasaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return jasaList.size
    }

    override fun onBindViewHolder(holder: JasaViewHolder, position: Int) {
        holder.bind(jasaList[position])
    }

}