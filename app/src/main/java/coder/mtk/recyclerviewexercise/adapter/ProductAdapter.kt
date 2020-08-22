package coder.mtk.recyclerviewexercise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk.recyclerviewexercise.MainActivity
import coder.mtk.recyclerviewexercise.R
import coder.mtk.recyclerviewexercise.model.Product
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_products.view.*

class ProductAdapter(var productList: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun binding(product: Product) {
            itemView.productPhoto.setImageResource(product.imageSrc)
            itemView.productName.text = product.name
            itemView.productPrice.text = product.price.toString()
            var main = MainActivity()
            itemView.btnPlus.setOnClickListener {
                var count = itemView.productKg.text.toString().toInt()
                count++
                var result = product.price * count
                itemView.productKg.text = count.toString()
                itemView.productPrice.text = result.toString()
            }

            itemView.btnMinus.setOnClickListener {
                var count = itemView.productKg.text.toString().toInt()
                if (count > 0) {
                    count--
                    var num =  itemView.productPrice.text.toString().toInt()
                    var result =  num - product.price
                    itemView.productPrice.text = result.toString()
                }
                itemView.productKg.text = count.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding(productList[position])
    }
}