package com.cabomaldade.kotlinmasterclass.homefinance/*package com.cabomaldade.kotlinmasterclass.homefinance

import android.os.Bundle
import android.util.Log
import androidx.navigation.ui.AppBarConfiguration
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.cabomaldade.kotlinmasterclass.homefinance.model.Money
import com.cabomaldade.kotlinmasterclass.homefinance.utils.CountabilityAdapter
import kotlinx.android.synthetic.main.content_main.*
import android.view.WindowManager
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View


const val TAG = "MainActivity"

class MainActivity_old : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var moneyList: ArrayList<Money>
    private lateinit var adapter: CountabilityAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_card)
        //val toolbar: Toolbar = findViewById(R.id.toolbar)
        //setSupportActionBar(toolbar)



        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )

        moneyList = moneyIn()

        adapter = CountabilityAdapter(moneyList, this)

        val recyclerView = money_recicleView
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager


        //val btnPlusSign = btn_add_transaction
        btn_add_transaction.setOnClickListener{

            // Initialize a new instance of
            val builder = AlertDialog.Builder(this@MainActivity)

            // Display a message on alert dialog
            builder.setMessage("Escolha o tipo da transação")

            builder.setPositiveButton("DESPESA"){dialog, which ->
                // Do something when user press the positive button
                addDebt(adapter)
                adapter.notifyDataSetChanged()
            }

            // Display a negative button on alert dialog
            builder.setNegativeButton("ENTRADA"){dialog,which ->
                addIncome(adapter)
                adapter.notifyDataSetChanged()
            }

            // Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()

            // Display the alert dialog on app interface
            dialog.show()

        }

        btn_debts_home.setOnClickListener {
            moneyList.filter{it.debt}
            adapter.notifyDataSetChanged()
        }

        btn_incomes_home.setOnClickListener {
            moneyList.filter{!it.debt}
            adapter.notifyDataSetChanged()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    // This is just to take some example data and apply at RecycleView - Will be replaced with BD
    private fun moneyIn(): ArrayList<Money> {

        val money1 = Money(SimpleDateFormat("dd/MM/yyyy").format(Date()).toString(),"Salário","2000,00", true)
        val money2 = Money(SimpleDateFormat("dd/MM/yyyy").format(Date()).toString(),"Pis","1000,00", true)
        val money3 = Money(SimpleDateFormat("dd/MM/yyyy").format(Date()).toString(),"Bitcoins", "1300,00", false)
        val money4 = Money(SimpleDateFormat("dd/MM/yyyy").format(Date()).toString(),"Bitcoins", "1300,00", false)


        var moneyListTemp = ArrayList<Money>()

        moneyListTemp.add(money1)
        moneyListTemp.add(money2)
        moneyListTemp.add(money3)
        moneyListTemp.add(money4)

        return moneyListTemp

    }

    fun addDebt(adapter: CountabilityAdapter) {

        if (new_money_description.text.isNullOrEmpty() || new_money_value.text.isNullOrEmpty()) {
            Toast.makeText(
                this@MainActivity,
                "Preencha os campos Valor e Descrição",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            moneyList.add(
                Money(
                    SimpleDateFormat("dd/MM/yyyy").format(Date()).toString(),
                    new_money_description.text.toString(),
                    new_money_value.text.toString(),
                    true
                )
            )
            adapter.notifyItemInserted(adapter.itemCount-1)
            adapter.notifyDataSetChanged()
        }

    }


    fun addIncome(adapter: CountabilityAdapter) {

        if (new_money_description.text.isNullOrEmpty() || new_money_value.text.isNullOrEmpty()) {
            Toast.makeText(
                this@MainActivity,
                "Preencha os campos Valor e Descrição",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            moneyList.add(
                Money(
                    SimpleDateFormat("dd/MM/yyyy").format(Date()).toString(),
                    new_money_description.text.toString(),
                    new_money_value.text.toString(),
                    false
                )
            )
            adapter.notifyItemInserted(adapter.itemCount-1)
        }

         */

