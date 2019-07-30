package com.amangarg.animatedscratchview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val context: Context, private val dataSet: MutableList<String>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.cardView.setOnClickListener { Toast.makeText(context, "Yay", Toast.LENGTH_SHORT).show() }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun remove(position: Int) {
        dataSet.removeAt(position)
        notifyItemRemoved(position)
    }

    fun add(text: String, position: Int) {
        dataSet.add(position, text)
        notifyItemInserted(position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView: CardView = itemView.findViewById(R.id.card);

    }
}