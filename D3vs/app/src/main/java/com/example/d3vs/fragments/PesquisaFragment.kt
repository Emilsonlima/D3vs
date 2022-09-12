package com.example.d3vs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.d3vs.R
import com.example.d3vs.adapter.AdapterCard
import com.example.d3vs.model.cardTutor

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



/**
 * A simple [Fragment] subclass.
 * Use the [PesquisaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PesquisaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: AdapterCard
    private lateinit var recyclerview: RecyclerView
    private lateinit var tutorArrayList: ArrayList<cardTutor>

    lateinit var foto: Array<Int>
    lateinit var nome: Array<String>
    lateinit var descricao: Array<String>
    lateinit var linguagem: Array<String>
    lateinit var nivel: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)


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
         * @return A new instance of fragment PesquisaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PesquisaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
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
        tutorArrayList = arrayListOf<cardTutor>()

        foto = arrayOf(
            R.drawable.avattutor,
            R.drawable.avattutor,
            R.drawable.avattutor,
        )

        nome = arrayOf(

        )

        descricao = arrayOf(

        )

        linguagem = arrayOf(

        )

        nivel = arrayOf(

        )

        for (i in foto.indices){
            val tutores = cardTutor(foto[i],nome[i], descricao[i],linguagem[i],nivel[i])
            tutorArrayList.add(tutores)
        }

    }


}