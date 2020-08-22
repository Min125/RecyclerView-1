package coder.mtk.recyclerviewexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk.recyclerviewexercise.adapter.ProductAdapter
import coder.mtk.recyclerviewexercise.model.Product
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var productList = ArrayList<Product>()
        productList.add(Product(R.drawable.sugar,"Fine Grain Sugar",20))
        productList.add(Product(R.drawable.peanut,"Peanuts",20))
        productList.add(Product(R.drawable.rice,"Dawat Rice",80))

        var productAdapter = ProductAdapter(productList)

        productRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = productAdapter
        }

    }

    fun setAmount (a : Int){
        total.text = a.toString()
    }
}