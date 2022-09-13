package com.rocketteam.d3vs.activities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rocketteam.d3vs.R
import com.rocketteam.d3vs.activities.adapter.AdapterCard
import com.rocketteam.d3vs.activities.model.CardTutor

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val FOTO_PARAM = "param1"
private const val NOME_PARAM = "param2"
private const val DESC_PARAM = "param3"
private const val LING_PARAM = "param4"
private const val NIVL_PARAM = "param5"



/**
 * A simple [Fragment] subclass.
 * Use the [PesquisaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PesquisaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var adapter: AdapterCard
    private lateinit var recyclerview: RecyclerView
    private lateinit var tutorArrayList: ArrayList<CardTutor>

    lateinit var foto: IntArray;
    lateinit var nome: Array<String>
    lateinit var descricao: Array<String>
    lateinit var linguagem: Array<String>
    lateinit var nivel: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getIntArray(FOTO_PARAM).let{ it2 -> foto = it2!! }
            it.getStringArray(NOME_PARAM).let { it2 -> nome = it2!! }
            it.getStringArray(DESC_PARAM).let { it2 -> descricao = it2!! }
            it.getStringArray(LING_PARAM).let { it2 -> linguagem = it2!! }
            it.getStringArray(NIVL_PARAM).let { it2 -> nivel = it2!! }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pesquisa, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @param param2 Parameter 3.
         * @param param2 Parameter 4.
         * @param param2 Parameter 5.
         * @return A new instance of fragment PesquisaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(Tutor: Array<CardTutor>) =
            PesquisaFragment().apply {
                arguments = Bundle().apply {
                    val foto = ArrayList<Int>()
                    val nome = ArrayList<String>()
                    val descricao = ArrayList<String>()
                    val linguagem =  ArrayList<String>()
                    val nivel = ArrayList<String>()

                    Tutor.forEach {
                        foto.add(it.foto)
                        nome.add(it.nome)
                        descricao.add(it.descricao)
                        linguagem.add(it.linguagem)
                        nivel.add(it.nivel)
                    }

                    putIntArray(FOTO_PARAM, foto.toIntArray())
                    putStringArray(NOME_PARAM, nome.toTypedArray())
                    putStringArray(DESC_PARAM, descricao.toTypedArray())
                    putStringArray(LING_PARAM, linguagem.toTypedArray())
                    putStringArray(NIVL_PARAM, nivel.toTypedArray())
                }
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerview = view.findViewById(R.id.recyclerView_tutores)
        recyclerview.layoutManager = layoutManager
        recyclerview.setHasFixedSize(true)
        adapter = AdapterCard(tutorArrayList)
        recyclerview.adapter = adapter

    }

    private fun dataInitialize(){
        tutorArrayList = arrayListOf<CardTutor>()
//
//        foto = arrayOf(
//            R.drawable.avattutor,
//            R.drawable.avattutor,
//            R.drawable.avattutor,
//        ).toIntArray()
//
//        nome = arrayOf(
//            "Um nome qualquer",
//            "Um nome qualquer 2",
//            "Um nome qualquer 3",
//        )
//
//        descricao = arrayOf(
//            "Descrição Qualquer",
//            "Descrição Qualquer 2",
//            "Descrição Qualquer 3"
//        )
//
//        linguagem = arrayOf(
//            "Linguagem Qualquer",
//            "Linguagem Qualquer 2",
//            "Linguagem Qualquer 3",
//        )
//
//        nivel = arrayOf(
//            "Nivel qualquer",
//            "Nivel qualquer 2",
//            "Nivel qualquer 3"
//        )
        println(foto.size);

        for (i in foto.indices){
            println(i);
            val tutores = CardTutor(foto[i],nome[i], descricao[i],linguagem[i],nivel[i])
            tutorArrayList.add(tutores)
        }

    }


}