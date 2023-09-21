package com.salma.psts_salmaaziza_xiipplg3.db

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.salma.psts_salmaaziza_xiipplg3.R

class AdapterActivity(val list: ArrayList<TB_PESANAN>, var listener: OnClickListener):
        RecyclerView.Adapter<AdapterActivity.ViewHolder>(){
            class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
                val jenis= itemView.findViewById<TextView>(R.id.txtjenis)
                val nama= itemView.findViewById<TextView>(R.id.txtnama)
                val harga= itemView.findViewById<TextView>(R.id.txtharga)
                val kuantiti= itemView.findViewById<TextView>(R.id.txtkuantiti)
                val hapus= itemView.findViewById<ImageView>(R.id.imghapus)
                val edit= itemView.findViewById<ImageView>(R.id.imgedit)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_adapter, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.jenis.text= list[position].jenis
        holder.nama.text= list[position].nama
        holder.harga.text= list[position].harga.toString()
        holder.kuantiti.text= list[position].kuantiti.toString()
        holder.hapus.setOnClickListener{
            listener.onDelete(list[position])
        }
        holder.edit.setOnClickListener{
            listener.onEdit(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(newList: List<TB_PESANAN>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    interface OnClickListener{
        fun onDelete(tbPesanan: TB_PESANAN)
        fun onEdit(tbPesanan: TB_PESANAN)
    }
        }