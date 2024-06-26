package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtpeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtaltura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btncalcular = findViewById<Button>(R.id.btn_calcular)

        btncalcular.setOnClickListener {
            val pesoString: String = edtpeso.text.toString()
            val alturaString : String = edtaltura.text.toString()

            if (pesoString == "" || alturaString == "") {
                // Mostrar messagem para usuario
                Snackbar
                    .make(
                        edtpeso,
                        "Preencha todos os campos vazios",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            }else {
                val peso = pesoString.toFloat()
                val altura = alturaString.toFloat()

                val alturaQ2 = altura * altura
                val resultado = peso/alturaQ2

                val intent = Intent(this, ResultActivity ::class.java)
                intent.putExtra(KEY_RESULT_IMC,resultado)
                startActivity(intent)
                println("Max acao do botao" + resultado)
            }

        }
    }
}