package com.example.kranthikumar.mvvmdemo.ui.shoppingcart

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kranthikumar.mvvmdemo.R
import com.example.kranthikumar.mvvmdemo.data.ShoppingItem
import com.example.kranthikumar.mvvmdemo.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*


class ShoppingCartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUI()
    }

    private fun initializeUI() {
        val factory = InjectorUtils.provideShoppingCartViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(ShoppingCartViewModel::class.java)

        viewModel.getShoppingItems().observe(this, Observer { shoppingItems ->
            val adapter = ShoppingListAdapter(this, shoppingItems)
            tv_shopping_list.adapter = adapter
            btn_add_item.setOnClickListener {
                val shoppingItem = ShoppingItem(et_shopping_item.text.toString(), et_quantity.text.toString())
                viewModel.addShoppingItems(shoppingItem)
                et_shopping_item.setText("")
                et_quantity.setText("")
                val imm = it.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(it.windowToken, 0)
            }
        })
    }

    class ShoppingListAdapter(private val context: Activity, private val shoppingItems: List<ShoppingItem>): ArrayAdapter<ShoppingItem>(context, R.layout.shopping_row_item, shoppingItems) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflator = context.layoutInflater
            val view = inflator.inflate(R.layout.shopping_row_item, null, true)
            val title = view.findViewById<TextView>(R.id.item_title)
            val quantity = view.findViewById<TextView>(R.id.item_quantity)
            title.text = shoppingItems[position].shoppingItem
            quantity.text = shoppingItems[position].itemQuantity
            return view
        }
    }
}
