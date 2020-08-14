package com.example.newwavesell.ui.design

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.AboveItemClickListener
import com.example.kudonavdrawerdemo.model.Cat
import com.example.kudonavdrawerdemo.model.Horse
import kotlin.collections.ArrayList

class CatAdapter(
    private val listCat: ArrayList<Cat>,
    private val listener: AboveItemClickListener
) : RecyclerView.Adapter<CatAdapter.CatHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatAdapter.CatHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_logo, parent, false)
        return CatHolder(view)
    }

   inner class CatHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var imgLogo = itemView.findViewById<ImageView>(R.id.imgColor)
        var tv_name = itemView.findViewById<TextView>(R.id.tv_name)

        init {
            itemView?.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onAboveItemClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return listCat.size
    }

    override fun onBindViewHolder(holder: CatAdapter.CatHolder, position: Int) {
        var itemLogo = listCat[position]
        holder.imgLogo.setImageResource(itemLogo.image)
        holder.tv_name.text = itemLogo.name
    }
}