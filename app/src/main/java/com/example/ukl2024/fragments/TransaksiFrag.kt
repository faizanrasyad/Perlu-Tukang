package com.example.ukl2024.fragments

import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ukl2024.R
import com.example.ukl2024.adapters.TransaksiAdapter
import com.example.ukl2024.databinding.FragmentTransaksi2Binding
import com.example.ukl2024.models.TransaksiModel
import kotlin.math.tan

class TransaksiFrag : Fragment() {
    private lateinit var newRv : RecyclerView
    private lateinit var newArrayList : ArrayList<TransaksiModel>
    lateinit var nama : Array<String>
    lateinit var tanggal : Array<String>
    lateinit var perusahaan : Array<String>

    private lateinit var binding : FragmentTransaksi2Binding

    private fun onClick(transaksiModel: TransaksiModel) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nama = arrayOf(
            "Suyanti Repair",
            "Fahrul Computer Service",
            "Bengkel Motor Setiya",
            "Konstruktor Baja Andalan"
        )

        tanggal = arrayOf(
            "23/02/2023 07:00",
            "25/10/2023 12:00",
            "04/10/2023 01:00",
            "09/09/2023 08:00"
        )

        perusahaan = arrayOf(
            "PT Suyanti Repair",
            "CV Fahrul Sukasuka",
            "PT Sang Setiya",
            "PT Andalanku"
        )

        newArrayList = arrayListOf<TransaksiModel>()
        getData()

    }

    private fun getData() {
        for (i in nama.indices){
            Log.d("Nama", nama[i].toString())
            val transaksi = TransaksiModel(nama[i], tanggal[i], perusahaan[i])
            newArrayList.add(transaksi)
            Log.d("New Array List Nama",newArrayList[i].nama)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTransaksi2Binding.inflate(inflater, container, false)
        val view = binding.root
        newRv = binding.rvTransaksi
        newRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newRv.setHasFixedSize(true)
        Log.d("New Array List Nama Create View",newArrayList[0].nama)
        newRv.adapter = TransaksiAdapter(::onClick, newArrayList)
        return view


    }


}