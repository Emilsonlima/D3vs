package com.example.d3vs.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.d3vs.R
import com.example.d3vs.model.cardTutor

class AdapterCard(private val context: Context, private val tutores: MutableList<cardTutor>): RecyclerView.Adapter<AdapterCard.CardTutorViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : CardTutorViewHolder{
        val itemLista = LayoutInflater.from(context).inflate(R.layout.tutores_item,parent,false)
        val holder = CardTutorViewHolder(itemLista)
        return holder
    }

    override fun onBindViewHolder(holder: CardTutorViewHolder, position: Int){
        holder.foto.setImageResource(tutores[position].foto)
        holder.nome.text=tutores[position].nome
        holder.descricao.text = tutores[position].descricao
        holder.linguagem.text = tutores[position].linguagem
        holder.nivel.text = tutores[position].nivel
    }

    override fun getItemCount():Int = tutores.size

    inner class CardTutorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val foto = itemView.findViewById<ImageView>(R.id.FotoTutor)
        val nome = itemView.findViewById<TextView>(R.id.nm_tutor)
        val descricao = itemView.findViewById<TextView>(R.id.des_tutor)
        val linguagem = itemView.findViewById<TextView>(R.id.ds_linguagem)
        val nivel = itemView.findViewById<TextView>(R.id.dsnivel)

    }

}