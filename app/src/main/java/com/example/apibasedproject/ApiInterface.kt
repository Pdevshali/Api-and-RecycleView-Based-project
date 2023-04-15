package com.example.apibasedproject

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")  // we put put  the end point of base url "https://dummyjson.com/products"
    fun getProductData() : Call<myData>
}