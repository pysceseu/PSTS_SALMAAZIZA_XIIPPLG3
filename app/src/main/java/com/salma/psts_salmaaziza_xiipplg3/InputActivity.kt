package com.salma.psts_salmaaziza_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.salma.psts_salmaaziza_xiipplg3.databinding.ActivityInputBinding
import com.salma.psts_salmaaziza_xiipplg3.db.DB_TOKOBATIK
import com.salma.psts_salmaaziza_xiipplg3.db.TB_PESANAN

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding
    private lateinit var database: DB_TOKOBATIK
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database= DB_TOKOBATIK.getInstance(applicationContext)
        binding.imgBack.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivityy::class.java))}
        binding.txtselesai.setOnClickListener{
            if (binding.edjenis.text.isNotEmpty()&&
                binding.ednama.text.isNotEmpty()&&
                binding.edharga.text.isNotEmpty()&&
                binding.edkuantiti.text.isNotEmpty()
            ) {
                database.pesananDao().inputData(TB_PESANAN(
                    0,
                    binding.edjenis.text.toString(),
                    binding.ednama.text.toString(),
                    binding.edharga.text.toString().toInt(),
                    binding.edkuantiti.text.toString().toInt()
                ))
                binding.edjenis.setText("")
                binding.ednama.setText("")
                binding.edharga.setText("")
                binding.edkuantiti.setText("")
                startActivity(Intent(this, RecyclerViewActivityy::class.java))
            }else{
                Toast.makeText(applicationContext, "silahkan isi semua data terlebih dahulu",
                Toast.LENGTH_SHORT).show()
            }
        }
    }
}