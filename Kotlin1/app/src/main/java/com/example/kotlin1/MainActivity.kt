package com.example.kotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //myTextView.setText("Hello World")
        val valueA = findViewById<EditText>(R.id.valorA)
        val valueB = findViewById<EditText>(R.id.valorB)
        val valueC = findViewById<EditText>(R.id.ValorC)
        val botonCalcular = findViewById<Button>(R.id.btnCalcular)



    botonCalcular.setOnClickListener {
        val a = valueA.text.toString().toFloat()
        val b = valueB.text.toString().toFloat()
        val c = valueC.text.toString().toFloat()
        val aux = ((b*b)-(4*a*c))

        if (aux < 0){
            val res1 = ((-1) * b) / (2 * a)
            val res2 = sqrt(aux.absoluteValue) / (2 * a)
            Toast.makeText(this, "x1 = "+res1+" + "+ res2.toString() + "i, "+
                    "x2 = "+res1+" - "+ res2.toString()+"i", Toast.LENGTH_LONG).show()
        }else{
            val res1 = (((-1) * b) + sqrt(aux)) /(2 * a)
            val res2 = (((-1) * b) - sqrt(aux)) /(2 * a)
            Toast.makeText(this, "x1 = "+ res1.toString() + ", "+
                    "x2 = "+res2.toString(), Toast.LENGTH_LONG).show()
        }




    }



    }
}