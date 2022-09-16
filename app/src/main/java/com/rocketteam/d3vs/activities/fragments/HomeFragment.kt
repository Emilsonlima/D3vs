package com.rocketteam.d3vs.activities.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.allViews
import androidx.core.view.children
import com.rocketteam.d3vs.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val NOME = "param1"
private const val IDADE = "param2"
private const val EMAIL = "param3"
private const val INTERESSES = "param4"
//private const val ARG_PARAM4 = "param4"

/**
 * A simple [Fragment] subclass.
 * Use the [.homeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var nome: String? = null
    private var idade: String? = null
    private var email: String? = null
    private var interesses: Array<String>? = null;
//    private var perfilImg: Bitmap? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nome = it.getString(NOME)
            idade = it.getString(IDADE)
            email = it.getString(EMAIL)
            interesses = it.getStringArray(INTERESSES)
//            val imgData = it.getByteArray(ARG_PARAM4)
//            perfilImg = BitmapFactory.decodeByteArray(imgData, 0, imgData!!.size);
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.let {
            //lblUsuario
            val lblUsuario: TextView = it.findViewById(R.id.nmUsuario)
            nome.let { it ->
                if (it == null) return
                lblUsuario.text = it
            }

            //lblEmail
            val lblEmail: TextView = it.findViewById(R.id.emailIusario)
            email.let { it ->
                if (it == null) return
                lblEmail.text = it
            }

            //lblIdade
            val lblIdade: TextView = it.findViewById(R.id.IdadeUs)
            idade.let { it ->
                if (it == null) return
                lblIdade.text = it
            }

            //lblInteresses
            val lblInteresses: TextView = it.findViewById(R.id.Interesse1)
            interesses.let { it ->
                if (it == null) return
                lblInteresses.text = ""
                for (s in it) lblInteresses.let { it ->
                    if (s == "") return
                    it.text = "${it.text} $s;"
                }
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param Nome Parameter 1.
         * @param Idade Parameter 2.
         * @param Email Parameter 3
         * @param Interesses Parameter 4.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(Nome: String, Idade: String, Email: String, Interesses: Array<String>) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(NOME, Nome)
                    putString(IDADE, Idade)
                    putString(EMAIL, Email)
                    putStringArray(INTERESSES, Interesses)
//                    val stream = ByteArrayOutputStream()
//                    param4.compress(Bitmap.CompressFormat.PNG, 90, stream)
//                    val image = stream.toByteArray()
//                    putByteArray(ARG_PARAM4, image)
                }
            }
    }
}