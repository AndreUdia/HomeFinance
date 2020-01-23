package com.cabomaldade.kotlinmasterclass.homefinance.utils

import android.content.Context
import android.graphics.Color.*
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cabomaldade.kotlinmasterclass.homefinance.R
import com.cabomaldade.kotlinmasterclass.homefinance.model.Money
import kotlinx.android.synthetic.main.money_item.view.*

const val TAG = "ADAPTER"

class CountabilityAdapter(private var money : ArrayList<Money>,
                          private val context: Context
) : RecyclerView.Adapter<CountabilityAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val money = money[position]
        holder.bindView(money)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.money_item, parent, false)
        return ViewHolder(view)
    }

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(money: Money) {
            val date = itemView.money_date_entrance
            val description = itemView.money_description
            val value = itemView.money_value
            date.text = money.date
            description.text = money.description
            value.text = """R$ ${money.value}"""

            if (money.debt){
                value.setTextColor(parseColor("#ff0000"))
            }

            itemView.setOnClickListener{
                Log.d(TAG, "ADAPTER: NORMAL CLICK WAS CLICKED")
            }

            itemView.setOnLongClickListener{
                Log.d(TAG, "ADAPTER: LONG CLICK WAS CLICKED")
                return@setOnLongClickListener true
            }
        }

    }

    override fun getItemCount(): Int {
        return money.size
    }

    fun removeItem(position: Int) {
        money.removeAt(position)
        this.notifyItemRemoved(position)
    }


}

