package com.example.listacompra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listacompra.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var b:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityResultBinding.inflate(layoutInflater)
        setContentView(b.root)


        b.tvLista.text = "LISTA\n\n"
        var total = 0.0
        val myExtras = intent.extras //<- Extras devuelve clave + su valor (k,v)
        if (myExtras != null){
            val claves = myExtras.keySet() //<- keySet() Te devuelve todas las claves (k)
            for (key in claves){
                b.tvLista.text = b.tvLista.text.toString().plus("$key:\t\t\t${myExtras.get(key)}\n")
                total += myExtras.get(key).toString().toDouble()
            }
            b.tvLista.text = b.tvLista.text.toString().plus("\n\nTotal: $total")
        }
        b.btnVolver.setOnClickListener {
            onBackPressed()

        }

    }
    fun msj (str:String){
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}