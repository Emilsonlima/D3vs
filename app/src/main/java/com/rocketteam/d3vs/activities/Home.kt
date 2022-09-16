package com.rocketteam.d3vs.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rocketteam.d3vs.R
import com.rocketteam.d3vs.activities.fragments.HistoricFragment
import com.rocketteam.d3vs.activities.fragments.HomeFragment
import com.rocketteam.d3vs.activities.fragments.PesquisaFragment
import com.rocketteam.d3vs.activities.model.CardTutor
import com.rocketteam.d3vs.db.D3vsDataBase
import com.rocketteam.d3vs.db.entities.Qualificacoes
import com.rocketteam.d3vs.db.entities.Tutor
import com.rocketteam.d3vs.db.entities.Usuario
import com.rocketteam.d3vs.db.entities.UsuarioAluno
import java.time.LocalDate

public class Home : AppCompatActivity() {

    private val historicfragment = HistoricFragment()
    private var bottomNavigation: BottomNavigationView? = null
    private var actualFragment: Int = 0
    private var fragmentContainer: ViewGroup? = null

    private var lblUsuario: TextView? = null
    private var lblInteresses: TextView? = null
    private var lblEmail: TextView? = null
    private var lblIdade: TextView? = null

    private var perfil: UsuarioAluno? = null;
    private var account: GoogleSignInAccount? = null

    private var db: D3vsDataBase? = null;

    companion object {
        fun newInstance(Context: Context, Email: String): Intent {
            val perfil = Intent(Context, Home::class.java)
            val bundle = Bundle()
            bundle.putString("Email", Email)
            perfil.putExtras(bundle)
            return perfil
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        val email = intent.extras!!.getString("Email", "")

        try {
            db = D3vsDataBase.getInstance(this);

            db!!.let{
                it.TutorDAO().insert(
                    Tutor(Descricao = "Eu sou rico"),
                    Usuario(
                        Nome = "Bruce Wayne",
                        DtNasc = LocalDate.parse("1915-04-17"),
                        Cpf = "74594578",
                        Senha = "Tananananam",
                        Email = "morcego@wayneenterprises.com"
                    ),
                    arrayOf(
                        Qualificacoes(
                            Linguagem = "Tudo"
                        )
                    )
                )
            }

            perfil = db!!.AlunoDAO().findByEmail(email)
        } catch (ex: Exception) {
            Toast.makeText(
                this,
                "Ocorreu um erro ao recuperar os dados da conta.",
                Toast.LENGTH_LONG
            ).show()
            Log.e("SignIn", ex.stackTraceToString())
            finish()
            return
        }

//        supportActionBar!!.hide()
        replaceFragment(homeFragment())
        bottomNavigation = findViewById(R.id.bottom_navigation);
        fragmentContainer = findViewById(R.id.fragment_container);

        //Era pra reconhecer, não to entendento o pq de não estar ok.
        bottomNavigation!!.setOnItemSelectedListener {
//            Log.i("Navigation", it.itemId.toString());
//            Log.i("Navigation", R.drawable.ic_home.toString());
            when (it.toString()) {
                "Perfil" -> {
                    replaceFragment(homeFragment())
                    actualFragment = 0
                }
                "Busca" -> {
                    val tutores = ArrayList<CardTutor>()
                    db!!.TutorDAO().listAll().forEach { tutor ->
                        tutores.add(
                            CardTutor(
                                R.drawable.ic_person,
                                tutor.Usuario.Nome,
                                tutor.Tutor.Descricao!!,
                                tutor.Qualificacoes[0].Linguagem,
                                ""
                            )
                        )
                    }
                    replaceFragment(PesquisaFragment.newInstance(tutores.toTypedArray()))
                    actualFragment = 1
                }
                "Histórico" -> {
                    replaceFragment(historicfragment)
                    actualFragment = 2
                }
            }
            true
        }
    }

    private fun homeFragment(): Fragment {
        return HomeFragment.newInstance(
            perfil!!.Usuario.Nome,
            calcIdade(perfil!!.Usuario.DtNasc!!).toString() + " anos",
            perfil!!.Usuario.Email,
            perfil!!.Interesses.let { it ->
                val i = ArrayList<String>()
                it.forEach { it ->
                    i.add(it.Interesse)
                }
                i.toTypedArray()
            }
        )
    }

    private fun calcIdade(date: LocalDate): Int {
        return (LocalDate.now().let {
            it.plusYears(-date.year.toLong())
                .plusMonths(-date.monthValue.toLong())
                .plusDays(-date.dayOfYear.toLong())
        }).year
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}