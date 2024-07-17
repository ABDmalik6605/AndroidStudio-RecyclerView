package com.example.myapplication2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.R
import com.example.myapplication2.model.ItemModel

class ItemRecyclerViewAdapter (private val mList: List<ItemModel>): RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
// inflates the card_view_design view
// that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent,false)
        return ViewHolder(view)
    }
    // binds the list items to a view
    override fun onBindViewHolder (holder: ViewHolder, position: Int) {
        val itemModel = mList[position]
// sets the image to the imageview from our itemHolder class
        holder.textView3.text=itemModel.num
        holder.imageView.setImageResource(itemModel.image)
// sets the text to the textview from our itemHolder class
        holder.textView1.text = itemModel.text1
        holder.textView2.text = itemModel.text2
        // Inside onBindViewHolder or wherever you detect end of data
        if (position == itemCount - 1) {
            onEndReachedListener?.invoke()
        }
    }
    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }
    // In your RecyclerView adapter class
    var onEndReachedListener: (() -> Unit)? = null

    // Holds the views for adding it to image and text
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = this.itemView.findViewById(R.id.itemIcon)
        val textView1: TextView = this.itemView.findViewById(R.id.itemTitle1)
        val textView2: TextView = this.itemView.findViewById(R.id.itemTitle2)
        val textView3: TextView = this.itemView.findViewById(R.id.numbering)
    }
}