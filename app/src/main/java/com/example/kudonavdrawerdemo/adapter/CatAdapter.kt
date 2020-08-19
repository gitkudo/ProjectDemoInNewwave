package com.example.kudonavdrawerdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.CatItemClickListener
import com.example.kudonavdrawerdemo.model.Cat
import kotlin.collections.ArrayList

class CatAdapter(
    private val listCat: ArrayList<Cat>,
    private val listener: CatItemClickListener
) : RecyclerView.Adapter<CatAdapter.CatHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_logo, parent, false)
        return CatHolder(view)
    }

   inner class CatHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var imgLogo:ImageView = itemView.findViewById(R.id.imgColor)
        var tvName:TextView = itemView.findViewById(R.id.tv_name)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.catItemClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return listCat.size
    }

    override fun onBindViewHolder(holder: CatHolder, position: Int) {
        val itemLogo = listCat[position]
        holder.imgLogo.setImageResource(itemLogo.image)
        holder.tvName.text = itemLogo.name
    }
}