package com.example.okta.applicationkade

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*


class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView){

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            itemView.name.text = items.name
            Glide.with(containerView).load(items.image).into(itemView.image)
            containerView.setOnClickListener { listener(items) }
        }
    }
}