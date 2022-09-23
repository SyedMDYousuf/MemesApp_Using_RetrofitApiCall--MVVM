package com.syedmohammedyousuf.memesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.syedmohammedyousuf.memesapp.adapter.MemeAdapter
import com.syedmohammedyousuf.memesapp.models.Meme
import com.syedmohammedyousuf.memesapp.viewmodel.MemeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var memeViewModel: MemeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMemeApi()
    }

    fun initMemeApi() {

        memeViewModel = ViewModelProvider(this).get(MemeViewModel::class.java)

        //call api frm viewmodel
        memeViewModel.getApiData()

        //livedata observer
        memeViewModel.memeDataList.observe(this, Observer{
            initAdapter(it)
        })
    }
    private fun initAdapter(data: List<Meme>){
        rvmemes.layoutManager = LinearLayoutManager(this)
        val adapter = MemeAdapter(data)
        rvmemes.adapter = adapter

    }
}