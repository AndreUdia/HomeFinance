package com.cabomaldade.kotlinmasterclass.homefinance.model

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.cabomaldade.kotlinmasterclass.homefinance.R
import kotlinx.android.synthetic.main.activity_main_card.*

data class Transacao(
    val valor: Double = 0.0,
    val descricao: String = "Sem Descricao",
    val icone: Int = 0,
    val tipoTransacao: Int = 0)

enum class Imagens{
    CASA, VEICULO, LAZER
}