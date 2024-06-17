package com.example.recycleview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.recycleview.data.Product
import com.example.recycleview.databinding.ActivityProductDetailsActicityBinding

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsActicityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product_details_acticity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        binding = ActivityProductDetailsActicityBinding.inflate(layoutInflater)

        val productBundle = intent.getSerializableExtra("data") as? Product
//        val image = binding.productImage
//        val name = binding.productName
//        val description = binding.productDescription

        val toolbar = binding.toolbar

        val image = findViewById<ImageView>(R.id.productImage)
        val name = findViewById<TextView>(R.id.productName)
        val description = findViewById<TextView>(R.id.productDescription)

        name.text = productBundle?.name
        description.text = productBundle?.description


        Glide.with(this).load(productBundle?.urlImage).into(image)

        configureToolbar("Product Detail", false)
    }
}