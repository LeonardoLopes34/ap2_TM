package com.example.recycleview.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recycleview.commons.utils.Resultado
import com.example.recycleview.data.Repositories.ProductRepository
import com.example.recycleview.data.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {
    private val _products = MutableLiveData<Resultado<List<Product>>>()
    val products = _products

    fun fetchProducts() {
        _products.postValue(Resultado.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)

            try {
                val result = productRepository.fetchAllProducts()
                _products.postValue(Resultado.Sucess(data = result))
            } catch (e: Exception) {
                _products.postValue(Resultado.Error(e))
            }
        }
    }
    fun addProduct(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        _products.postValue(Resultado.Loading)
        try {
            productRepository.addProduct(product)
            _products.postValue(Resultado.Sucess(emptyList()))
        }catch (e: Exception) {
            _products.postValue(Resultado.Error(e))
        }
    }
    fun deleteProduct(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        productRepository.deleteProduct(product)
    }
}