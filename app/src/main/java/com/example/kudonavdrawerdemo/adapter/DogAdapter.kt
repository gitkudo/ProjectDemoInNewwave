package com.example.newwavesell.ui.design

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.DogItemClickListener
import com.example.kudonavdrawerdemo.model.Dog
import kotlin.collections.ArrayList

class DogAdapter(
    private val listDog: ArrayList<Dog>,
    private val listener: DogItemClickListener
) : RecyclerView.Adapter<DogAdapter.LogoHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DogAdapter.LogoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_logo, parent, false)
        return LogoHolder(view)
    }

   inner class LogoHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var imgLogo:ImageView = itemView.findViewById(R.id.imgColor)
        var tvName = itemView.findViewById<TextView>(R.id.tv_name)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.dogItemClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return listDog.size
    }

    override fun onBindViewHolder(holder: DogAdapter.LogoHolder, position: Int) {
        val itemLogo = listDog[position]
        holder.imgLogo.setImageResource(itemLogo.image)
        holder.tvName.text = itemLogo.name
    }
}