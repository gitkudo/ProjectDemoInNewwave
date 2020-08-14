package com.example.newwavesell.ui.design

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.AboveItemClickListener
import com.example.kudonavdrawerdemo.model.Horse
import kotlin.collections.ArrayList

class HorseAdapter(
    private val listHorse: ArrayList<Horse>,
    private val listener: AboveItemClickListener
) : RecyclerView.Adapter<HorseAdapter.LogoHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HorseAdapter.LogoHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_logo, parent, false)
        return LogoHolder(view)
    }

   inner class LogoHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
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
        return listHorse.size
    }

    override fun onBindViewHolder(holder: HorseAdapter.LogoHolder, position: Int) {
        var itemLogo = listHorse[position]
        holder.imgLogo.setImageResource(itemLogo.imgLogo)
        holder.tv_name.text = itemLogo.name
    }
}