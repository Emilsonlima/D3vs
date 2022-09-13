package com.rocketteam.d3vs.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.rocketteam.d3vs.R

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
    private var edtpassword: EditText? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criarperfil_tutor)

        //btEstudante
        btEstudante = findViewById(R.id.btEstudante);
        btEstudante!!.setOnClickListener{ btEstudanteOnClick(it); }

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

        //edtEmailAddress
        edtEmailAddress = findViewById(R.id.editTextTextEmailAddress);

        //edtpassword
        edtpassword = findViewById(R.id.editTextTextPassword);
    }

    private fun btSalvarOnClick(it: View?) {

    }

    private fun btTutorOnClick(it: View?) {

    }

    private fun btEstudanteOnClick(it: View?) {
        var estudanteActivity: Intent = Intent(this, CriarPerfil::class.java);
        startActivity(estudanteActivity);
    }
}