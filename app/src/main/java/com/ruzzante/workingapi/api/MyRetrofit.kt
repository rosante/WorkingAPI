package com.ruzzante.workingapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {

    private val retrofit: Retrofit
    // Instanciando ProductAPI para utilizar o método get Product
    fun productApi(): ProductAPI{
        return retrofit.create(ProductAPI::class.java)
    }

    companion object{
        private const val BASE_URL = "https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/mycart/"

        var myRetrofit: MyRetrofit? = null

        @get:Synchronized
        val intance: MyRetrofit?
        get(){
            if (myRetrofit == null){
                myRetrofit = MyRetrofit()
            }
            return myRetrofit
        }
    }

    init{
        //Para o retorno da API com os dados convertidos para Classe
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}