package com.example.kotlin2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var boton = findViewById<Button>(R.id.button)
        var txtElvis = findViewById<TextView>(R.id.txtElvis)
        var txtNull = findViewById<TextView>(R.id.txtNull)
        var txtSingletone = findViewById<TextView>(R.id.txtSingletone)
        var ejemplo: String? = null
        println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
        txtNull.setText("Prueba de null: "+ejemplo?.length)
        println(ejemplo?.length)
        setName(ejemplo)
        //operadorExclamacion(ejemplo)

        boton.setOnClickListener( {view -> toast("Toast lambda y extension")} )

        txtSingletone.setText(kotlinSingleton.dispMsg())

    }

    private fun setName (name: String?) {
        val username = name ?: "Valor por defecto"
        txtElvis.setText("El texto por defecto es: " + username)
    }

    private fun operadorExclamacion (name: String?) {
        val validador = name!!.length
        println(validador)
    }

    fun AppCompatActivity.toast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    object kotlinSingleton {
        var ejemplo = "Emiliano"
        fun dispMsg(): String{
            return ejemplo
        }
    }

}