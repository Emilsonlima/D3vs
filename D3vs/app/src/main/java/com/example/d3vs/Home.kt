package com.example.d3vs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.d3vs.adapter.AdapterCard
import com.example.d3vs.fragments.HistoricFragment
import com.example.d3vs.fragments.PesquisaFragment
import com.example.d3vs.fragments.homeFragment
import com.example.d3vs.model.cardTutor
import com.google.android.material.bottomnavigation.BottomNavigationView


public class Home : AppCompatActivity() {

    private val homefragment = homeFragment()
    private val pesquisafragment = PesquisaFragment()
    private val historicfragment = HistoricFragment()
    private var bottom_navigation: BottomNavigationView? = null;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar!!.hide()
        replaceFragment(homefragment)


        bottom_navigation!!.setOnItemSelectedListener{
            when(it.itemId){
                R.drawable.ic_home -> replaceFragment(homefragment)
                R.drawable.ic_search -> replaceFragment(pesquisafragment)
                R.drawable.ic_menu_book -> replaceFragment(historicfragment)
            }
            true
        }



        //RecyclerView da tela Pesquisa

        val  recyclerView_tutores = findViewById<RecyclerView>(R.id.recyclerView_tutores)
        recyclerView_tutores.layoutManager = LinearLayoutManager(this)
        recyclerView_tutores.setHasFixedSize(true)

        //Configurar o Adapter e criar lista de objetos
        val listatutores: MutableList<cardTutor> = mutableListOf()
        val adaptertutor = AdapterCard(this, listatutores )
        recyclerView_tutores.adapter = adaptertutor

        val tutor1 = cardTutor(
            R.drawable.avattutor,
            "Tutor de Teste",
            "Descrição de um tutor para testes",
            "Java, Kotlin, C++",
            "Nível 3"
        )
        listatutores.add(tutor1)
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}