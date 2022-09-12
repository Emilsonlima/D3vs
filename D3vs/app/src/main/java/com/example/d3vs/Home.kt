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

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.layout_recycler,fragment)
        fragmentTransaction.commit()
    }
}