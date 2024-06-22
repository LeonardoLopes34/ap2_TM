package com.example.recycleview.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recycleview.presentation.viewmodels.ProductViewModel
import com.example.recycleview.R
import com.example.recycleview.commons.utils.Resultado
import com.example.recycleview.data.models.Product
import com.example.recycleview.databinding.FragmentHomeBinding
import com.example.recycleview.presentation.adapters.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var adapter: ProductAdapter
    private lateinit var productViewModel: ProductViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        createApapter(binding)
        observers()
        productViewModel.fetchProducts()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun observers() {
        productViewModel.products.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resultado.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resultado.Sucess -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.setUpListOfProducts(result.data)
                }

                is Resultado.Error -> binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun createApapter(binding: FragmentHomeBinding) {
        val recycler = binding.recyclerView
        adapter =
            ProductAdapter(

                goToDetail = { product: Product ->
                    recycler.adapter = adapter
                }
            )
            {
//                productViewModel.deleteProduct(product)
                adapter.notifyChange()
            }
    }


    private fun goToDetail(product: Product) {
        val bundle = bundleOf("data" to product)
        findNavController().navigate(
            R.id.action_homeFragment_to_productDetailsActivity,
            bundle
        )
    }
}