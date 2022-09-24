package com.syedmohammedyousuf.memesapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syedmohammedyousuf.memesapp.models.Meme
import com.syedmohammedyousuf.memesapp.models.MemesResponse
import com.syedmohammedyousuf.memesapp.network.RetrofitInstance
import com.syedmohammedyousuf.memesapp.network.RetrofitService
import retrofit2.Call
import retrofit2.Response

class MemeViewModel : ViewModel() {

    var memeDataList = MutableLiveData<MemesResponse>()


    fun getApiData() {

        val retrofitService =
            RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofitService.getData().enqueue(object : retrofit2.Callback<MemesResponse> {

            override fun onResponse(
                call: Call<MemesResponse>,
                response: Response<MemesResponse>
            ) {

                memeDataList.value = response.body()
            }

            override fun onFailure(call: Call<MemesResponse>, t: Throwable) {
            }
        })
    }
}
