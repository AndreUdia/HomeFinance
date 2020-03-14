package com.cabomaldade.kotlinmasterclass.homefinance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_card.*

//const val TAG = "MainActivity"

class MainActivity: AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_card)

        valorDaTransacao.setText(0.0.toString())

        // Atribuindo OnclickListener para todos botões
        somaUm.setOnClickListener{ valorAtual(1.0) }
        somaCinco.setOnClickListener{ valorAtual(5.0) }
        somaDez.setOnClickListener{ valorAtual(10.0) }
        somaCinquenta.setOnClickListener{ valorAtual(50.0) }
        somaCem.setOnClickListener{ valorAtual(100.0) }
        somaUmCent.setOnClickListener{ valorAtual(0.01) }
        somaCincoCent.setOnClickListener{ valorAtual(0.05) }
        somaDezCent.setOnClickListener{ valorAtual(0.10) }
        somaVinteCincoCent.setOnClickListener{ valorAtual(0.25) }
        somaCinquentaCent.setOnClickListener{ valorAtual(0.50) }
    }

    // Atualiza valor da transação na tela  ! falta tratar casas decimais
    private fun valorAtual(valorSomar: Double){
        var valor = valorDaTransacao.text.toString().toDouble()
        valor += valorSomar
        valorDaTransacao.setText(valor.toString())
    }

}