package com.rocketteam.d3vs.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.rocketteam.d3vs.R
import com.rocketteam.d3vs.db.D3vsDataBase
import com.rocketteam.d3vs.db.entities.Qualificacoes
import com.rocketteam.d3vs.db.entities.Tutor
import com.rocketteam.d3vs.db.entities.Usuario

class Login : AppCompatActivity() {
    private var edtSenha: EditText? = null;
    private var edtEmail: EditText? = null;
    private var btGoogle: Button? = null;
    private var btEntrar: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //btEntrar
        btEntrar = findViewById(R.id.btLoginEntrar);
        btEntrar!!.setOnClickListener { btEntrarOnClick(it) };

        //btGoogle
        btGoogle = findViewById(R.id.btGoogle);
        btGoogle!!.setOnClickListener { btGoogleOnClick(it) };

        //edtEmail
        edtEmail = findViewById(R.id.ds_email);

        //edtSenha
        edtSenha = findViewById(R.id.ds_senha);

        val db = D3vsDataBase.getInstance(this)
        db.TutorDAO().insert(
            Tutor(
                Descricao = "Descrição Qualquer"
            ),
            Usuario(
                Nome = "Thiago Momberg Plens",
                Senha = "160412",
                Email = "t@t.com",
                Discriminacao = "tutor"
            ),
            Qualificacoes = arrayOf(
                Qualificacoes(
                    Linguagem = "JS"
                ),
                Qualificacoes(
                    Linguagem = "React"
                )
            )
        )

        db.TutorDAO().listAll().forEach() { tutor ->
            tutor.Tutor.Descricao.let { Log.i("Tutor Descrição: ", it!!) }
            Log.i("Usuario Nome: ", tutor.Usuario.Nome)
            tutor.Qualificacoes.forEach { qualificacao ->
                Log.i("Qualificação: ", qualificacao.Linguagem)
            }
            println("-------------------------")
        }

    }

    private fun btGoogleOnClick(it: View?) {

    }

    private fun btEntrarOnClick(it: View?) {
        var homeActivity: Intent = Intent(this, Home::class.java);
        startActivity(homeActivity);
    }
}