package com.example.coincrypto

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response

class CoinViewModel : ViewModel() {
    val listCoinResult: MutableList<Coin> = arrayListOf()
    private val coinLiveData: MutableLiveData<List<Coin>> = MutableLiveData()
    val listCoin: LiveData<List<Coin>>
        get() = coinLiveData

    fun init(){
        callListFilme()
    }

    private fun callListFilme() {
        val call = CoinService.coinRetrofitApi().getAllList("CFB9107C-F454-4F93-B412-C7F15E3D284D")
        call.enqueue(object : retrofit2.Callback<List<Coin>> {
            override fun onResponse(call: Call<List<Coin>>, response: Response<List<Coin>>) {
                if (response.isSuccessful)
                    response.body()?.forEach {
                        listCoinResult.add(it)
                    }
                coinLiveData.postValue(listCoinResult)
            }

            override fun onFailure(call: Call<List<Coin>>, t: Throwable) {
                coinLiveData.postValue(null)
            }
        })

    }

}



