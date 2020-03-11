package com.cabomaldade.kotlinmasterclass.homefinance.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cabomaldade.kotlinmasterclass.homefinance.R
import com.cabomaldade.kotlinmasterclass.homefinance.model.Money

class CardAdapter (private var money : ArrayList<Money>,
                          private val context: Context
) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val money = money[position]
        holder.bindView(money)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.money_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return money.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(money: Money) {
        }

    }

}