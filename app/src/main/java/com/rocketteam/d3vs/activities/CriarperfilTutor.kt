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
import com.rocketteam.d3vs.db.entities.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CriarperfilTutor : AppCompatActivity() {


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
    private var edtDescricao: EditText? = null;

    private var db: D3vsDataBase? = null;
    private var account: GoogleSignInAccount? = null

    companion object {
        fun newInstance(Context: Context, Email: String, Senha: String): Intent {
            val perfil = Intent(Context, CriarperfilTutor::class.java)
            val bundle = Bundle()
            bundle.putString("Email", Email)
            bundle.putString("Senha", Senha)
            perfil.putExtras(bundle)
            return perfil
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criarperfil_tutor)
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
        btEstudante!!.setOnClickListener { btEstudanteOnClick(it); }

        //btTutor
        btTutor = findViewById(R.id.btTutor);
        btTutor!!.isEnabled = false;
        btTutor!!.setOnClickListener { btTutorOnClick(it); }

        //btSalvar
        btSalvar = findViewById(R.id.btSalvar);
        btSalvar!!.setOnClickListener { btSalvarOnClick(it); }

        //imagePerfil
        imagePerfil = findViewById(R.id.imageButton3);

        //edtPersonName
        edtPersonName = findViewById(R.id.editTextTextPersonName);

        //edtCpf
        edtCpf = findViewById(R.id.editTextcpf);

        //edtDate
        edtDate = findViewById(R.id.editTextDate);

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

        //edtPassword
        edtPassword = findViewById(R.id.editTextTextPassword);
        edtPassword!!.text.let {
            it.clear()
            it.append(senha)
        }

        //edtDescricao
        edtDescricao = findViewById(R.id.editTextTextMultiLine);
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

    private fun edtQualificacaoOnFocusLost(v: View?) {
        if (edtQualificacao!!.text.lastIndexOf(';') < edtQualificacao!!.text.length - 1)
            edtQualificacao!!.text.append(";")
    }

    private fun btSalvarOnClick(it: View?) {
        try {
            val email = edtEmailAddress!!.text.toString()
            val qualificacoes = ArrayList<Qualificacoes>()
            edtQualificacao!!.text.toString().split(';').forEach {
                qualificacoes.add(Qualificacoes(Linguagem = it))
            }
            if (db!!.TutorDAO().findByEmail(email) == null) {
                Toast.makeText(
                    this,
                    R.string.emailTutorJaRegistrado,
                    Toast.LENGTH_SHORT
                )
            }

            db!!.TutorDAO().insert(
                Tutor = Tutor(
                    Descricao = edtDescricao!!.text.toString()
                ),
                Usuario(
                    Nome = edtPersonName!!.text.toString(),
                    Email = edtEmailAddress!!.text.toString(),
                    Senha = edtPassword!!.text.toString(),
                    Cpf = edtCpf!!.text.toString(),
                    DtNasc = LocalDate.parse(edtDate!!.text.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    GoogleAuth = if (account != null) account!!.id else null
                ),
                qualificacoes.toTypedArray()
            )
            Toast.makeText(
                this,
                R.string.cadastradoSucesso,
                Toast.LENGTH_SHORT
            ).show()
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

    }

    private fun btEstudanteOnClick(it: View?) {
        startActivity(
            CriarPerfil.newInstance(
                this,
                edtEmailAddress!!.text.toString(),
                edtPassword!!.text.toString()
            )
        )
        finish()
    }
}