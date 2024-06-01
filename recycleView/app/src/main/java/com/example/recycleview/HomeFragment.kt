package com.example.recycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var productAdapter: ProductAdapter
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]


        val recycler = binding.recyclerView
        val productAdapter =
            ProductAdapter(mainViewModel.getProduct(), goToDetail = { product: Product ->
                val bundle = bundleOf("data" to product)
                findNavController().navigate(
                    R.id.action_homeFragment_to_productDetailsActivity,
                    bundle
                )
            }
            ){
                mainViewModel.removeProduct(it)
            }
        recycler.adapter = productAdapter
    }
}