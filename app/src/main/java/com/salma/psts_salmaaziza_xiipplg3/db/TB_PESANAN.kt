package com.salma.psts_salmaaziza_xiipplg3.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbPesanan")
data class TB_PESANAN(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "KODE_PESAN")
    val kode: Int,
    @ColumnInfo(name = "JENIS")
    val jenis: String,
    @ColumnInfo(name = "NAMA")
    val nama: String,
    @ColumnInfo(name = "HARGA")
    val harga: Int,
    @ColumnInfo(name = "KUANTITI")
    val kuantiti: Int
)
