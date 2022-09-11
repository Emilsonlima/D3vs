package com.example.d3vs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val  recyclerView_tutores = findViewById<RecyclerView>(R.id.recyclerView_tutores)
        recyclerView_tutores.layoutManager = LinearLayoutManager(this)
        recyclerView_tutores.setHasFixedSize(true)
    }
}