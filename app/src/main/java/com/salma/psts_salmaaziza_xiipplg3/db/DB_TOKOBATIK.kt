package com.salma.psts_salmaaziza_xiipplg3.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TB_PESANAN::class], version = 1)
    abstract class DB_TOKOBATIK : RoomDatabase(){
    abstract fun pesananDao() : PESANAN_DAO

    companion object{
        @Volatile
        private var INSTANCE: DB_TOKOBATIK? = null
        private var key= Any()

        @Synchronized
        fun getInstance(context: Context) : DB_TOKOBATIK{
            if (INSTANCE==null){
                INSTANCE= Room.databaseBuilder(context, DB_TOKOBATIK::class.java,
                "Toko Batik")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }
    }