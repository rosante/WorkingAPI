package com.ruzzante.workingapi.api

import com.ruzzante.workingapi.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductAPI {
    @GET("getdata.php")
    fun getProductApi(): Call<List<Product>>
}