package com.salma.psts_salmaaziza_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.salma.psts_salmaaziza_xiipplg3.databinding.ActivityEditBinding
import com.salma.psts_salmaaziza_xiipplg3.db.DB_TOKOBATIK
import com.salma.psts_salmaaziza_xiipplg3.db.TB_PESANAN

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    private val db by lazy { DB_TOKOBATIK.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kode = intent.getStringExtra("kodePesanan").toString().toInt()
        val data = db.pesananDao().getDataKode(kode)

        binding.edjenis.setText(data[0].jenis)
        binding.ednama.setText(data[0].nama)
        binding.edharga.setText(data[0].harga.toString())
        binding.edkuantiti.setText(data[0].kuantiti.toString())
        binding.txtselesai.setOnClickListener {
            if (binding.edjenis.text.isNotEmpty() &&
                binding.ednama.text.isNotEmpty() &&
                binding.edharga.text.isNotEmpty() &&
                binding.edkuantiti.text.isNotEmpty()) {

                db.pesananDao().editData(TB_PESANAN(
                        kode,
                         binding.edjenis.text.toString(),
                         binding.ednama.text.toString(),
                         binding.edharga.text.toString().toInt(),
                         binding.edkuantiti.text.toString().toInt()
                    ))

                Toast.makeText(applicationContext, "Data berhasil diubah",
                Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, RecyclerViewActivityy::class.java))
                onBackPressed()
            }else{
                Toast.makeText(applicationContext, "Ubah data terlebih dahulu",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}