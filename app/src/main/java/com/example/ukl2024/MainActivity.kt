package com.example.ukl2024

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.ukl2024.databinding.ActivityMainBinding
import com.example.ukl2024.fragments.AkunFrag
import com.example.ukl2024.fragments.BerandaFrag
import com.example.ukl2024.fragments.DaftarTukangFrag
import com.example.ukl2024.fragments.IsiSaldoFrag
import com.example.ukl2024.fragments.TransaksiFrag

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        replaceFrag(BerandaFrag())
        binding.apply {
            bottomNavBar.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.beranda -> replaceFrag(BerandaFrag())
                    R.id.transaksi -> replaceFrag(TransaksiFrag())
                    R.id.akun -> replaceFrag(AkunFrag())
                    R.id.daftar_tukang -> replaceFrag(DaftarTukangFrag())
                    R.id.isi_saldo -> replaceFrag(IsiSaldoFrag())
                    else -> {}
                }
                true
            }
        }
    }

    private fun replaceFrag(fragment: Fragment) {
        val fragManager = supportFragmentManager
        val fragTransaction = fragManager.beginTransaction()

        fragTransaction.replace(R.id.frameLayout, fragment)
        fragTransaction.commit()
    }
}