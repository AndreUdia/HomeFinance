package com.cabomaldade.kotlinmasterclass.homefinance

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cabomaldade.kotlinmasterclass.homefinance.model.Transacao
import kotlinx.android.synthetic.main.activity_main_card.*
import java.util.*

const val TAG = "MainActivity"

class MainActivity: AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_card)

        valorDaTransacao.setText(0.0.toString()) // inicia o valor a apresentar na tela

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

        btnAdicionar.setOnClickListener{ insereTransacao(criaTransacao())}
    }

    // Atualiza valor da transação na tela  ! Tratado precisão 2 casas decimais
    private fun valorAtual(valorSomar: Double){
        var valor = valorDaTransacao.text.toString().toDouble()

        valor += valorSomar

        val somaTotal = String.format(Locale.US,"%.2f", valor)

        valorDaTransacao.setText(somaTotal)
    }

    private fun insereTransacao(transacao: Transacao){
        Log.d(TAG, "Dados da transação = ${transacao.descricao}, " +
                "${transacao.valor}, ${transacao.icone}, ${transacao.tipoTransacao}")
    }

    private fun criaTransacao(): Transacao{
        //Log.d(TAG, "cria Transacao foi chamada")
        val tipo = if (transacaoDeEntrada.isChecked) 1 else 2
        return Transacao(
            valorDaTransacao.text.toString().toDouble(),
            "Implementar Spinner",
            0,
            tipo
        )
    }
}