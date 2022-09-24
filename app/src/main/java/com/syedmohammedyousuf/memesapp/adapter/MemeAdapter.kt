package com.syedmohammedyousuf.memesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import com.syedmohammedyousuf.memesapp.R
import com.syedmohammedyousuf.memesapp.models.Meme
import kotlinx.android.synthetic.main.list_item.view.*

class MemeAdapter(private var mList: List<Meme>): RecyclerView.Adapter<MemeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemeAdapter.ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]

        holder.name.text = ItemsViewModel.name
        Glide.with(holder.itemView.context)
            .load(mList[position].url)
            .into(holder.itemView.ivImg)



    }

    override fun getItemCount(): Int {
        return mList.size

    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.txtImgTitle
        val url = itemView.ivImg
    }





}