package com.example.kudonavdrawerdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.HorseItemClickListener
import com.example.kudonavdrawerdemo.model.Horse
import kotlin.collections.ArrayList

class HorseAdapter(
    private val listHorse: ArrayList<Horse>,
    private val listener: HorseItemClickListener
) : RecyclerView.Adapter<HorseAdapter.LogoHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LogoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_logo, parent, false)
        return LogoHolder(view)
    }

   inner class LogoHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var imgLogo: ImageView = itemView.findViewById(R.id.imgColor)
        var tvName: TextView = itemView.findViewById(R.id.tv_name)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.horseItemClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return listHorse.size
    }

    override fun onBindViewHolder(holder: LogoHolder, position: Int) {
        val itemLogo = listHorse[position]
        holder.imgLogo.setImageResource(itemLogo.imgLogo)
        holder.tvName.text = itemLogo.name
    }
}