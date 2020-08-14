package com.example.kudonavdrawerdemo.adapter

import android.graphics.LightingColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.OnItemClickListener
import com.example.kudonavdrawerdemo.model.Nontifi
import com.example.newwavesell.model.Pro


class ListProAdapter(
    private val proList: ArrayList<Pro>,
    private val listen: OnItemClickListener

) : RecyclerView.Adapter<ListProAdapter.ProHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListProAdapter.ProHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProHolder(itemView)
    }

    override fun getItemCount(): Int {
        return proList.size
    }

    override fun onBindViewHolder(holder: ListProAdapter.ProHolder, position: Int) {
        val currentItem = proList[position]
        holder.tvName!!.text = currentItem.name
        holder.tvUpTime!!.text = currentItem.upTime
        holder.tvAmount!!.text = currentItem.amount.toString()
        holder.tvProSize!!.text = currentItem.proSize
//        holder.tvColor?.setImageResource(R.color.colorAccent)
        holder.tvColor?.getBackground()?.setColorFilter(LightingColorFilter(-0x1, -R.color.colorAccent))
        holder.tvPrice!!.text = currentItem.price.toString()
    }

    inner class ProHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!),
        View.OnClickListener {
        val tvName = itemView?.findViewById<TextView>(R.id.tv_name)
        val tvUpTime = itemView?.findViewById<TextView>(R.id.tv_upTime)
        val tvAmount = itemView?.findViewById<TextView>(R.id.tv_amount)
        val tvProSize = itemView?.findViewById<TextView>(R.id.tv_proSize)
        val tvColor = itemView?.findViewById<ImageView>(R.id.tv_color)
        val tvPrice = itemView?.findViewById<TextView>(R.id.tv_price)

        init {
            itemView?.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listen.onItemClick(position)
            }

        }
    }

}