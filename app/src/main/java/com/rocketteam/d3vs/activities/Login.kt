package com.rocketteam.d3vs.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.rocketteam.d3vs.R
import com.rocketteam.d3vs.db.D3vsDataBase
import com.rocketteam.d3vs.db.entities.Qualificacoes
import com.rocketteam.d3vs.db.entities.Tutor
import com.rocketteam.d3vs.db.entities.Usuario

class Login : AppCompatActivity() {

    private var edtSenha: EditText? = null
    private var edtEmail: EditText? = null
    private var btGoogle: SignInButton? = null
    private var btEntrar: Button? = null
    private var toolBar2: Toolbar? = null

    private var db: D3vsDataBase? = null
    var gso: GoogleSignInOptions? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
            .requestProfile()
            .requestEmail().build()

        //toolBar2
        toolBar2 = findViewById(R.id.toolbar2)

        //btEntrar
        btEntrar = findViewById(R.id.btLoginEntrar);
        btEntrar!!.setOnClickListener { btEntrarOnClick(it) };

        //btGoogle
        btGoogle = findViewById(R.id.btGoogle);
        val txtBtGoogle: TextView = btGoogle!!.getChildAt(0) as TextView
        txtBtGoogle.text = resources.getString(R.string.continuar_com_o_goggle)
        btGoogle!!.setOnClickListener { btGoogleOnClick(it) };

        //edtEmail
        edtEmail = findViewById(R.id.ds_email);

        //edtSenha
        edtSenha = findViewById(R.id.ds_senha);

        db = D3vsDataBase.getInstance(this);

    }

    override fun onResume() {
        super.onResume()
        try {
            when (val account = GoogleSignIn.getLastSignedInAccount(this)) {
                null -> Toast.makeText(this, R.string.NaoLogado, Toast.LENGTH_SHORT).show()
                else -> {
                    if (db!!.AlunoDAO().autenticar(account.id!!)) {
                        startActivity(Home.newInstance(this, account.email!!))
                        finish()
                    }
                }
            }
        } catch (ex: Exception) {
            Toast.makeText(
                this,
                "Erro ao entrar com o google",
                Toast.LENGTH_SHORT
            ).show()
            Log.e("Google SignIn", ex.stackTraceToString())
        }
    }

    private fun btGoogleOnClick(it: View?) {
        try {
            var client = com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(this, gso!!)
            val signInIntent: Intent = client.signInIntent
            startActivity(signInIntent)
        } catch (ex: Exception) {
            Toast.makeText(
                this,
                "Erro ao entrar com o google",
                Toast.LENGTH_SHORT
            )
            Log.e("Google SignIn", ex.stackTraceToString())
        }
    }

    private fun btEntrarOnClick(it: View?) {
        var auth =
            db!!.AlunoDAO().autenticar(edtEmail!!.text.toString(), edtSenha!!.text.toString());
//        Log.i("Auth", "$auth/${edtEmail!!.text.toString()}/${edtSenha!!.text.toString()}");
        if (auth) {
            var homeActivity: Intent = Home.newInstance(this, edtEmail!!.text.toString());
            startActivity(homeActivity);
        } else
            Toast.makeText(this, R.string.dadosIncorretos, Toast.LENGTH_SHORT).show()
    }
}