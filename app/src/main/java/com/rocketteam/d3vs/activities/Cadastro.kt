package com.rocketteam.d3vs.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignIn.getLastSignedInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.rocketteam.d3vs.R


class Cadastro : AppCompatActivity() {

    val RC_SIGN_IN = 2
    var btEntrar: Button? = null
    var btGoogle: SignInButton? = null
    var edtEmail: EditText? = null
    var edtSenha: EditText? = null
    var gso: GoogleSignInOptions? = null

    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
            .requestProfile()
            .requestEmail().build()

        //btEntrar
        btEntrar = findViewById(R.id.btLoginEntrar)
        btEntrar!!.setOnClickListener { btEntrarOnClick(it) }

        //btGoogle
        btGoogle = findViewById(R.id.btGoogle)
        val txtBtGoogle: TextView = btGoogle!!.getChildAt(0) as TextView
        txtBtGoogle.text = resources.getString(R.string.continuar_com_o_goggle)
        btGoogle!!.setOnClickListener { btGoogleOnClick(it) }

        //edtEmail
        edtEmail = findViewById(R.id.ds_email)

        //edtSenha
        edtSenha = findViewById(R.id.ds_senha)
    }

    override fun onResume() {
        super.onResume()
        when (val account = getLastSignedInAccount(this)) {
            null -> Toast.makeText(this, R.string.NaoLogado, Toast.LENGTH_SHORT)
            else -> {
                startActivity(
                    CriarPerfil.newInstance(
                        this,
                        "",
                        ""
                    )
                )
                finish()
            }
        }
    }

    private fun btEntrarOnClick(it: View?) {
        if (edtEmail!!.text.isEmpty() || edtSenha!!.text.isEmpty()){
            Toast.makeText(
                this,
                "Um dos campos não está preenchido.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        startActivity(
            CriarPerfil.newInstance(
                this,
                edtEmail!!.text.toString(),
                edtSenha!!.text.toString()
            )
        )
        finish()
    }

    private fun btGoogleOnClick(it: View?) {
        GoogleSign()
    }

    private fun GoogleSign() {
        var client = com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(this, gso!!)
        val signInIntent: Intent = client.signInIntent
        startActivity(signInIntent)
    }
}