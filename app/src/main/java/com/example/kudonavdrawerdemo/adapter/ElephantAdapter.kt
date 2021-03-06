package com.example.kudonavdrawerdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.ElephantItemClickListener
import com.example.kudonavdrawerdemo.model.Elephant

class ElephantAdapter(
    private val listElephant: ArrayList<Elephant>,
    private val listener:ElephantItemClickListener
) : RecyclerView.Adapter<ElephantAdapter.AboveHolder>() {
    inner class AboveHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        var imgAbove:ImageView = itemView.findViewById(R.id.imgIconAbove)
        var tvName:TextView = itemView.findViewById(R.id.tv_name)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onEleItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboveHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_above, parent, false)
        return AboveHolder(view)
    }

    override fun getItemCount(): Int {
        return listElephant.size
    }

    override fun onBindViewHolder(holder: AboveHolder, position: Int) {
        val itemAbove = listElephant[position]
        holder.imgAbove.setImageResource(itemAbove.color)
        holder.tvName.text = itemAbove.name
    }
}