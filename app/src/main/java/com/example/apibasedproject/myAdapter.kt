package com.example.apibasedproject

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class myAdapter(val context: Activity, val productArrayList : List<Product>):
RecyclerView.Adapter<myAdapter.MyViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // use to create view for each item
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // populate the data
        val currentIem = productArrayList[position]
        holder.title.text = currentIem.title

        // image view, how to show image in imageView if the image is in form of url(string):
        // 3rd party library is used ie. Picasso

        Picasso.get().load(currentIem.thumbnail).into(holder.image);
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var title: TextView
        var image : ShapeableImageView

        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
        }
    }
}