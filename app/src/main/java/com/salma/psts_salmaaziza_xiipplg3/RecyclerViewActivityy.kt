package com.salma.psts_salmaaziza_xiipplg3

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.salma.psts_salmaaziza_xiipplg3.databinding.ActivityRecyclerViewActivityyBinding
import com.salma.psts_salmaaziza_xiipplg3.db.AdapterActivity
import com.salma.psts_salmaaziza_xiipplg3.db.DB_TOKOBATIK
import com.salma.psts_salmaaziza_xiipplg3.db.TB_PESANAN
import kotlinx.coroutines.*

class  RecyclerViewActivityy : AppCompatActivity() {
    private val db by lazy { DB_TOKOBATIK.getInstance(this) }
    private lateinit var binding: ActivityRecyclerViewActivityyBinding
    private lateinit var adapter: AdapterActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRecyclerViewActivityyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter= AdapterActivity(arrayListOf(), object : AdapterActivity.OnClickListener{
            override fun onDelete(tbPesanan: TB_PESANAN) {
                hapusData(tbPesanan)
            }

            override fun onEdit(tbPesanan: TB_PESANAN) {
                editData(tbPesanan)
            }
        })
        binding.listData.adapter= adapter
        binding.listData.layoutManager= LinearLayoutManager(applicationContext, VERTICAL, false)
        binding.listData.addItemDecoration(DividerItemDecoration(applicationContext, VERTICAL))

        binding.btnAdd.setOnClickListener{
            startActivity(Intent(this, InputActivity::class.java))
        }
    }
    private fun hapusData(tbPesanan: TB_PESANAN){
        val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("Konfirmasi hapus data")
            setMessage("Anda yakin ingin menghapus data ${tbPesanan.nama}?")
            setNegativeButton("Batal"){
                dialogInterface: DialogInterface,i:Int->
                dialogInterface.dismiss()
            }
            setPositiveButton("Hapus"){
                dialogInterface: DialogInterface,i:Int->
                dialogInterface.dismiss()
                CoroutineScope(Dispatchers.IO).launch {
                    db.pesananDao().hapusData(tbPesanan)
                    finish()
                    startActivity(intent)
                }
                getData()
            }
            dialog.show()
        }
    }

    private fun editData(tbPesanan: TB_PESANAN){
        startActivity(Intent(this, EditActivity::class.java).
                putExtra("kodePesanan", tbPesanan.kode.toString()))
    }

    override fun onResume() {
        super.onResume()
        getData()
    }
    fun getData(){
        binding.listData.layoutManager= LinearLayoutManager(this)
        CoroutineScope(Dispatchers.IO).launch {
            val data= db.pesananDao().getAllData()
            adapter.setData(data)
            withContext(Dispatchers.Main){
                adapter.notifyDataSetChanged()
            }
        }
        binding.listData.adapter= adapter
    }
}