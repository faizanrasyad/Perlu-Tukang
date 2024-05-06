package com.example.ukl2024.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.ukl2024.R
import com.example.ukl2024.adapters.ArtikelAdapter
import com.example.ukl2024.adapters.GambarAdapter
import com.example.ukl2024.adapters.JasaAdapter
import com.example.ukl2024.databinding.FragmentBeranda2Binding
import com.example.ukl2024.models.ArtikelModel
import com.example.ukl2024.models.GambarModel
import com.example.ukl2024.models.JasaModel

class BerandaFrag : Fragment() {
    private lateinit var binding : FragmentBeranda2Binding

    private lateinit var rvJasa : RecyclerView
    private lateinit var jasaArrayList : ArrayList<JasaModel>
    lateinit var namaJasa : Array<String>
    lateinit var jarak : Array<String>
    lateinit var alamat : Array<String>

    private lateinit var rvArtikel : RecyclerView
    private lateinit var artikelArrayList : ArrayList<ArtikelModel>
    lateinit var namaArtikel : Array<String>
    lateinit var imageArtikel : Array<Int>

    private lateinit var rvGambar : RecyclerView
    private lateinit var gambarArrayList : ArrayList<GambarModel>
    lateinit var image : Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Arrays of Jasa
        namaJasa = arrayOf(
            "Nguyen Comp",
            "Kapunkap Service",
            "Jowo Jaya Center",
            "Toto Tolata"
        )
        jarak = arrayOf(
            "5.02",
            "20.65",
            "8.55",
            "3.43",
        )
        alamat = arrayOf(
            "Jl. Kemerdekaan Jaya Abadi Gg.4 No.32",
            "Jl. Sokearno Hatta Gg.50 No.65",
            "Jl. Malang - Gresik No. 673",
            "Jl. Danau Ranau Gg.5 No.6"
        )
        jasaArrayList = arrayListOf<JasaModel>()

        //Arrays of Artikel
        namaArtikel = arrayOf(
            "Update Aplikasi Perlu Tukang",
            "Update Terbaru Untuk Mitra (Tukang)",
            "Update Terbaru Untuk Konsumen"
        )
        imageArtikel = arrayOf(
            R.drawable.konstruksi1,
            R.drawable.konstruksi2,
            R.drawable.konstruksi3
        )
        artikelArrayList = arrayListOf<ArtikelModel>()

        //Arrays of Gambar
        image = arrayOf(
            R.drawable.airport,
            R.drawable.konstruksi1,
            R.drawable.konstruksi2,
            R.drawable.konstruksi3,
            R.drawable.kuli_jawa_1,
            R.drawable.kuli_jawa_2,
            R.drawable.kuli_jawa_3
        )
        gambarArrayList = arrayListOf<GambarModel>()

        getData()
    }

    private fun getData() {
        for (i in namaJasa.indices){
            val jasa = JasaModel(namaJasa[i], jarak[i], alamat[i])
            jasaArrayList.add(jasa)
        }
        for (i in namaArtikel.indices){
            val artikel = ArtikelModel(namaArtikel[i], imageArtikel[i])
            artikelArrayList.add(artikel)
        }
        for (i in image.indices){
            val gambar = GambarModel(image[i])
            gambarArrayList.add(gambar)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBeranda2Binding.inflate(inflater, container, false)
        val view = binding.root

        rvJasa = binding.rvJasa
        rvArtikel = binding.rvArtikel
        rvGambar = binding.rvGambar

        rvJasa.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvArtikel.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvGambar.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        rvArtikel.setHasFixedSize(true)

        rvJasa.adapter = JasaAdapter(::onClickJasa, jasaArrayList)
        rvArtikel.adapter = ArtikelAdapter(::onClickArtikel, artikelArrayList)
        rvGambar.adapter = GambarAdapter(::onClickGambar, gambarArrayList)

        val snapHelperGambar : LinearSnapHelper = LinearSnapHelper()
        snapHelperGambar.attachToRecyclerView(rvGambar)
        rvGambar.smoothScrollBy(10, 0)

        val snapHelperJasa : LinearSnapHelper = LinearSnapHelper()
        snapHelperJasa.attachToRecyclerView(rvJasa)
        rvJasa.smoothScrollBy(10, 0)

        return view
    }

    private fun onClickGambar(gambarModel: GambarModel) {

    }

    private fun onClickArtikel(artikelModel: ArtikelModel) {

    }

    private fun onClickJasa(jasaModel: JasaModel) {

    }

}