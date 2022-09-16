package com.rocketteam.d3vs.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.rocketteam.d3vs.R
import com.rocketteam.d3vs.db.D3vsDataBase
import com.rocketteam.d3vs.db.entities.Aluno
import com.rocketteam.d3vs.db.entities.Interesses
import com.rocketteam.d3vs.db.entities.Usuario
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CriarPerfil : AppCompatActivity() {

    private var btSalvar: Button? = null;
    private var btTutor: Button? = null;
    private var btEstudante: Button? = null;
    private var imagePerfil: ImageButton? = null;
    private var edtPersonName: EditText? = null;
    private var edtCpf: EditText? = null;
    private var edtDate: EditText? = null;
    private var edtQualificacao: EditText? = null;
    private var edtEmailAddress: EditText? = null;
    private var edtPassword: EditText? = null;

    private var db: D3vsDataBase? = null;
    private var account: GoogleSignInAccount? = null
    private var saved: Boolean = false

    companion object {
        fun newInstance(Context: Context, Email: String, Senha: String): Intent {
            val perfil = Intent(Context, CriarPerfil::class.java)
            val bundle = Bundle()
            bundle.putString("Email", Email)
            bundle.putString("Senha", Senha)
            perfil.putExtras(bundle)
            return perfil
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_perfil)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        var email: String = ""
        var senha: String = ""

        intent.extras.let {
            email = it!!.getString("Email").let { s -> s ?: "" }
            senha = it.getString("Senha").let { s -> s ?: "" }
        }

        db = D3vsDataBase.getInstance(this);

        //btEstudante
        btEstudante = findViewById(R.id.btEstudante);
        btEstudante!!.isEnabled = false;
        btEstudante!!.setOnClickListener { btEstudanteOnClick(it); }

        //btTutor
        btTutor = findViewById(R.id.btTutor);
        btTutor!!.setOnClickListener { btTutorOnClick(it); }

        //btSalvar
        btSalvar = findViewById(R.id.btSalvar);
        btSalvar!!.setOnClickListener { btSalvarOnClick(it); }

        //imagePerfil
//        imagePerfil = findViewById(R.id.imageButton3);

        //edtPersonName
        edtPersonName = findViewById(R.id.editTextTextPersonName);

        //edtCpf
        edtCpf = findViewById(R.id.editTextcpf);

        //edtDate
        edtDate = findViewById(R.id.editTextDate);
        edtDate!!.setOnFocusChangeListener { view, b -> if (!b) edtDateOnLostFocus(view) }

        //edtQualificacao
        edtQualificacao = findViewById(R.id.editTextqualificacao);
        edtQualificacao!!.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus)
                edtQualificacaoOnFocusLost(v)
        }

        //edtEmailAddress
        edtEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        edtEmailAddress!!.text.let {
            it.clear()
            it.append(email)
        }

        //edtpassword
        edtPassword = findViewById(R.id.editTextTextPassword);
        edtPassword!!.text.let {
            it.clear()
            it.append(senha)
        }

        //
        imagePerfil = findViewById(R.id.imageButton3)
    }

    private fun edtDateOnLostFocus(view: View?) {
        edtDate!!.let {
            it.text.append(it.text.let{ it ->
                val oldText = it.toString()
                it.clear()
                oldText.replace('-', '/')
            })

            when (it.text.length) {
                8 -> it.text.insert(2, "/").insert(5, "/")
                6 -> it.text.insert(2, "/").insert(5, "/").insert(6, "19")
                else -> {}
            }
        }
    }

    override fun onStart() {
        super.onStart()

        account = GoogleSignIn.getLastSignedInAccount(this)
        account.let { it ->
            if (it == null) return
            edtEmailAddress!!.text.let {
                it.clear()
                it.append(account!!.email)
            }
            edtPersonName!!.text.let {
                it.clear()
                it.append(account!!.givenName + " " + account!!.familyName)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun edtQualificacaoOnFocusLost(v: View?) {
        if (edtQualificacao!!.text.lastIndexOf(';') < edtQualificacao!!.text.length - 1)
            edtQualificacao!!.text.append(";")
    }

    private fun btSalvarOnClick(it: View?) {
        try {
            val email = edtEmailAddress!!.text.toString()
            val interesses = ArrayList<Interesses>()
            edtQualificacao!!.text.toString().split(';').forEach {
                interesses.add(Interesses(Interesse = it))
            }
            if (db!!.AlunoDAO().findByEmail(email) == null) {
                Toast.makeText(
                    this,
                    R.string.emailAlunoJaRegistrado,
                    Toast.LENGTH_SHORT
                )
            }

            db!!.AlunoDAO().insert(
                Aluno = Aluno(),
                Usuario(
                    Nome = edtPersonName!!.text.toString(),
                    Email = email,
                    Senha = edtPassword!!.text.toString(),
                    Cpf = edtCpf!!.text.toString(),
                    DtNasc = LocalDate.parse(edtDate!!.text.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    GoogleAuth = if (account != null) account!!.id else null
                ),
                interesses.toTypedArray()
            )
            Toast.makeText(
                this,
                R.string.cadastradoSucesso,
                Toast.LENGTH_SHORT
            ).show()
            saved = true
            finish()
        } catch (ex: Exception) {
            Log.e("Insert CriarPerfil", ex.stackTraceToString())
            Toast.makeText(
                this,
                R.string.erroCriarPerfil,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun btTutorOnClick(it: View?) {
        startActivity(
            CriarperfilTutor.newInstance(
                this,
                edtEmailAddress!!.text.toString(),
                edtPassword!!.text.toString()
            )
        )
        finish()
    }

    private fun btEstudanteOnClick(it: View?) {

    }

}