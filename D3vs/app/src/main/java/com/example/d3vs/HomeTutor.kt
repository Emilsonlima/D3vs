package com.example.d3vs.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.d3vs.R
import com.example.d3vs.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeTutor : AppCompatActivity() {

    private val homefragmenttutor = hometutorFragment()
    private val historicfragmenttutor = HistorictutorFragment()
    private val carteirafragmenttutor = CarteiraFragment()
    private var bottom_navigationtutor: BottomNavigationView? = null;

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_tutor)
        supportActionBar!!.hide()
        replaceFragment(homefragmenttutor)

        bottom_navigationtutor!!.setOnItemSelectedListener{
            when(it.itemId){
                R.drawable.ic_home -> replaceFragment(homefragmenttutor)
                R.drawable.ic_menu_book -> replaceFragment(historicfragmenttutor)
                R.drawable.ic_monetization -> replaceFragment(carteirafragmenttutor)
            }
            true
    }

}}