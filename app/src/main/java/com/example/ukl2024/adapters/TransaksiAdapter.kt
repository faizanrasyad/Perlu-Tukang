package com.example.ukl2024.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ukl2024.databinding.FragmentTransaksi2Binding
import com.example.ukl2024.databinding.TransaksiItemLayoutBinding
import com.example.ukl2024.models.TransaksiModel

class TransaksiAdapter (val onCLick : (TransaksiModel) -> Unit, val transaksiList : ArrayList<TransaksiModel>) : RecyclerView.Adapter<TransaksiAdapter.TransaksiViewHolder>() {
    inner class TransaksiViewHolder(val binding : TransaksiItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TransaksiModel) {
            binding.apply {
                tvNama.text = item.nama
                tvTanggal.text = item.tanggal
                tvPerusahaan.text = item.perusahaan
                root.setOnClickListener {
                    onCLick(item)
                }
            }
        }
    }

    val transaksis : MutableList<TransaksiModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaksiViewHolder {
        val binding = TransaksiItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransaksiViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return transaksiList.size
    }

    override fun onBindViewHolder(holder: TransaksiViewHolder, position: Int) {
        holder.bind(transaksiList[position])
    }

}