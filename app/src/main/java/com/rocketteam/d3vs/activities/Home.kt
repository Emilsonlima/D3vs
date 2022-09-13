package com.rocketteam.d3vs.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rocketteam.d3vs.R
import com.rocketteam.d3vs.activities.fragments.HistoricFragment
import com.rocketteam.d3vs.activities.fragments.HomeFragment
import com.rocketteam.d3vs.activities.fragments.PesquisaFragment
import com.rocketteam.d3vs.activities.model.CardTutor

public class Home : AppCompatActivity() {

    private val homefragment = HomeFragment()
//    private val pesquisafragment = PesquisaFragment()
    private val historicfragment = HistoricFragment()
    private var bottom_navigation: BottomNavigationView? = null;
    private var fragmentContainer: View? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        supportActionBar!!.hide()
        replaceFragment(homefragment)
        bottom_navigation = findViewById(R.id.bottom_navigation);
        fragmentContainer = findViewById(R.id.fragment_container);

        //HistoricFragment

        //Era pra reconhecer, não to entendento o pq de não estar ok.
        bottom_navigation!!.setOnItemSelectedListener {
            Log.i("Navigation", it.itemId.toString());
            Log.i("Navigation", R.drawable.ic_home.toString());
            when (it.toString()) {
                "Perfil" -> {
                    Log.i("Navigation", "Home");
                    replaceFragment(homefragment)
                }
                "Busca" -> {
                    Log.i("Navigation", "Search");
                    replaceFragment(
                        PesquisaFragment.newInstance(arrayOf())
                    )
//                    val b = Bundle()
//                    b.putString("param1", "Teste");
                }
                "Histórico" -> {
                    Log.i("Navigation", "Históric");
                    replaceFragment(historicfragment)
                }
            }
            true
        }

        //ViewPesquisaFragment
        fragmentContainer = layoutInflater.inflate(
            R.layout.fragment_pesquisa,
            findViewById(R.id.fragment_container),
            false
        );
        //RecyclerView da tela Pesquisa
        val recyclerView_tutores =
            fragmentContainer!!.findViewById<RecyclerView>(R.id.recyclerView_tutores)
        val l = LinearLayoutManager(this)
        l.orientation = LinearLayoutManager.VERTICAL
        recyclerView_tutores.layoutManager = l

        recyclerView_tutores.setHasFixedSize(true)

        //Configurar o Adapter e criar lista de objetos
//        val listatutores: MutableList<CardTutor> = mutableListOf()
//        val adaptertutor = AdapterCard(this, listatutores )
//        Log.i("Adapter", adaptertutor.toString())
//        recyclerView_tutores.swapAdapter(adaptertutor, true)
//
//        val tutor1 = CardTutor(
//            R.drawable.avattutor,
//            "Tutor de Teste",
//            "Descrição de um tutor para testes",
//            "Java, Kotlin, C++",
//            "Nível 3"
//        )
//        listatutores.add(tutor1)
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}