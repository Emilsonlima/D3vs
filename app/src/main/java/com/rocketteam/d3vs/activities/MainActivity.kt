package com.rocketteam.d3vs.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.rocketteam.d3vs.BuildConfig
import com.rocketteam.d3vs.R

class MainActivity : AppCompatActivity() {

    private var btRegistrar: Button? = null
    private var btEntrar: Button? = null
    private var account: GoogleSignInAccount? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        //BtEntrar
        btEntrar = findViewById(R.id.btEntrar)
        btEntrar!!.setOnClickListener { btEntrarOnClick(it) }

        //BtRegistrar
        btRegistrar = findViewById(R.id.btregistrar)
        btRegistrar!!.setOnClickListener { btRegistrarOnClick(it) }
    }

    override fun onStart() {
        super.onStart()
    }

    private fun btRegistrarOnClick(it: View?) {
        var activityCadastro: Intent = Intent(this, Cadastro::class.java)
        startActivity(activityCadastro)
    }

    private fun btEntrarOnClick(it: View?) {
        var activityLogin: Intent = Intent(this, Login::class.java)
        startActivity(activityLogin)
    }
}