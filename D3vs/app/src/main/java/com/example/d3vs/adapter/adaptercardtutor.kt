package com.example.d3vs.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.d3vs.R
import com.example.d3vs.R.id.FotoTutor
import com.example.d3vs.model.cardTutor
import com.google.android.material.imageview.ShapeableImageView

class AdapterCard(private val tutorList: ArrayList<cardTutor>) : RecyclerView.Adapter<AdapterCard.MyviewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.tutores_item,parent, false)
        return MyviewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentItem = tutorList[position]
        holder.foto.setImageResource(currentItem.foto)
        holder.nome.text = currentItem.nome
        holder.descricao.text = currentItem.descricao
        holder.linguagem.text = currentItem.linguagem
        holder.nivel.text = currentItem.nivel
    }

    override fun getItemCount(): Int {
        return tutorList.size
    }

    class MyviewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

        val foto : ShapeableImageView = itemView.findViewById(FotoTutor)
        val nome: TextView = itemView.findViewById(R.id.nm_tutor)
        val descricao: TextView = itemView.findViewById(R.id.des_tutor)
        val  linguagem: TextView = itemView.findViewById(R.id.ds_linguagem)
        val nivel: TextView = itemView.findViewById(R.id.dsnivel)


    }


}