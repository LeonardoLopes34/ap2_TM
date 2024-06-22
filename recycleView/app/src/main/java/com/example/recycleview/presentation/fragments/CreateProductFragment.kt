package com.example.recycleview.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recycleview.R
import com.example.recycleview.commons.utils.configureToolbar
import com.example.recycleview.data.models.Product
import com.example.recycleview.databinding.FragmentCreateProductBinding
import com.example.recycleview.presentation.viewmodels.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateProductFragment : Fragment() {
    private lateinit var binding: FragmentCreateProductBinding
    private lateinit var productViewModel: ProductViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        binding.btnSave.setOnClickListener {
            val product = Product(
                name = binding.inputName.text.toString(),
                price = binding.inputPrice.text.toString(),
                description = binding.inputDetalhes.text.toString(),
                urlImage = binding.inputUrlProduct.text.toString()
            )
            productViewModel.addProduct(product)

            findNavController().navigate(R.id.action_createProductFragment_to_homeFragment2)
        }
    }
}