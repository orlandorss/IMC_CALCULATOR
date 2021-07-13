package com.orlando.imc_calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }
    private fun     setListeners(){
        altura?.doAfterTextChanged {

        }
        peso?.doOnTextChanged { _, _, _, _  ->
        }

        calcular.setOnClickListener{
        calcularIMC(peso.text.toString(), altura.text.toString())
    }
    }

    @SuppressLint("SetTextI18n")
    private fun calcularIMC (peso:String, altura:String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if(peso !=null && altura !=null){
            val imc = peso/(altura*altura)
            InputFilter.AllCaps()

            resultadoimc.text = "SEU IMC É %.2f".format(imc)
            if(imc < 18.5){
                resultadoimc.text = "SEU IMC É %.2f \n ABAIXO DO PESO".format(imc)

            }
            if (imc in 18.5..24.9){
                resultadoimc.text = "SEU IMC É %.2f \n PESO NORMAL".format(imc)
            }
            if(imc in 25.0..29.9){
                resultadoimc.text = "SEU IMC É %.2f \n SOBREPESO".format(imc)

            }
            if (imc in 30.0..34.9){
                resultadoimc.text = "SEU IMC É %.2f \n OBESIDADE GRAU I".format(imc)


            }
            if (imc in 35.0..39.9){
                resultadoimc.text = "SEU IMC É %.2f \n OBESIDADE GRAU II".format(imc)

            }
            if (imc>40.0){
                resultadoimc.text = "SEU IMC É %.2f \n OBESIDADE GRAU III".format(imc)

            }
        }
    }
}