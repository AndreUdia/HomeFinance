package com.cabomaldade.kotlinmasterclass.homefinance.model

data class Transacao(
    val valor: Double = 0.0,
    val descricao: String = "Sem Descricao",
    val icone: Int = 0,
    val tipoTransacao: Int = 0)