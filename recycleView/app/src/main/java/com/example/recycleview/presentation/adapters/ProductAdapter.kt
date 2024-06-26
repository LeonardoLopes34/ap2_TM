package com.example.recycleview.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.R
import com.example.recycleview.data.models.Product
import com.example.recycleview.databinding.ProductItemBinding


class ProductAdapter(

    private val goToDetail: (item: Product) -> Unit,
    private val removeItem: (product: Product) -> Unit
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var listOfProducts = emptyList<Product>()
    private lateinit var context: Context

    fun setUpListOfProducts(products: List<Product>) {
        listOfProducts = products
        notifyDataSetChanged()

    }

    fun notifyChange(){
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context
        val binding = ProductItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfProducts[position])
    }

    override fun getItemCount(): Int {
        return listOfProducts.size
    }

    inner class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.product = product
            binding.root.setOnLongClickListener {
                showPopUpMenu(it, product)
                false
            }
            binding.root.setOnClickListener {
                goToDetail(product)
            }
        }
    }

    private fun showPopUpMenu(view: View, product: Product) {
        PopupMenu(context, view).apply {
            setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.deletar -> {
                        removeItem(product)
                        notifyDataSetChanged()
                        false
                    }

                    else -> false
                }
            }
            inflate(R.menu.menu_pop_up)
            show()
        }
    }
}

