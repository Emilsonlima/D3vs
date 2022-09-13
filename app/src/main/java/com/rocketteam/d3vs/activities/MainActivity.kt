package com.rocketteam.d3vs.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.rocketteam.d3vs.R

class MainActivity : AppCompatActivity() {

    private var btRegistrar: Button? = null;
    private var btEntrar: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //BtEntrar
        btEntrar = findViewById(R.id.btEntrar);
        btEntrar!!.setOnClickListener { btEntrarOnClick(it) };

        //BtRegistrar
        btRegistrar = findViewById(R.id.btregistrar);
        btRegistrar!!.setOnClickListener { btRegistrarOnClick(it) };
    }

    private fun btRegistrarOnClick(it: View?) {
        var activityRegistrar: Intent = Intent(this, CriarPerfil::class.java);
        startActivity(activityRegistrar);
    }

    private fun btEntrarOnClick(it: View?) {
        var activityLogin: Intent = Intent(this, Login::class.java);
        startActivity(activityLogin);
    }
}