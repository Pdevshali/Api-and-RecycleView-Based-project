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
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        holder.rating.text = currentItem.rating.toString()
        holder.prize.text ="Price ${currentItem.price.toString()} $ "

        // image view, how to show image in imageView if the image is in form of url(string):
        // 3rd party library is used ie. Picasso

        Picasso.get().load(currentItem.thumbnail).into(holder.image);
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       // declared teh variable from eachitem
        var title: TextView
        var image : ShapeableImageView
        var rating : TextView
        var prize :TextView

        // Initializing the declared variable
        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
            rating = itemView.findViewById(R.id.productRating)
            prize = itemView.findViewById(R.id.productPrize)
        }
    }
}