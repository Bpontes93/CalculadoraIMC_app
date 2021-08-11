package com.example.calcimc

import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import android.widget.Toast
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
        
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){
        dadoAltura?.doAfterTextChanged { text ->
        }
        dadoPeso?.doOnTextChanged { text, _, _, _ ->
        }
        buttonCalc?.setOnClickListener {
            calcularIMC(dadoPeso.text.toString(), dadoAltura.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            textResultado.text = "%.2f".format(imc)
            textInfo.text = "Seu IMC é:"
        }
    }

    }



