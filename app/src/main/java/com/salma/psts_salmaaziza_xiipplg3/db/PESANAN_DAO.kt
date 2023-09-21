package com.salma.psts_salmaaziza_xiipplg3.db

import androidx.room.*

@Dao
interface PESANAN_DAO {
    @Insert
    fun inputData(vararg tbPesanan: TB_PESANAN)
    @Delete
    fun hapusData(vararg tbPesanan: TB_PESANAN)
    @Update
    fun editData(vararg tbPesanan: TB_PESANAN)
    @Query("SELECT * FROM tbPesanan")
    fun getAllData() : List<TB_PESANAN>
    @Query("SELECT * FROM tbPesanan WHERE KODE_PESAN=:kodePesanan")
    fun getDataKode(kodePesanan: Int) : List<TB_PESANAN>

}