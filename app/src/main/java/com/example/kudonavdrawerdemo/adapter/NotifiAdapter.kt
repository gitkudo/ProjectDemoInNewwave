package com.example.kudonavdrawerdemo.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.OnItemClickListener
import com.example.kudonavdrawerdemo.model.Nontifi

class NotifiAdapter(
    private val nonList: ArrayList<Nontifi>,
    private val listen: OnItemClickListener

) : RecyclerView.Adapter<NotifiAdapter.NotifiHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifiAdapter.NotifiHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_nontifi, parent, false)
        return NotifiHolder(itemView)
    }

    override fun getItemCount(): Int {
        return nonList.size
    }

    override fun onBindViewHolder(holder: NotifiAdapter.NotifiHolder, position: Int) {
        val currentItem = nonList[position]
        holder.tvTitle!!.text = currentItem.title
        holder.tvContent!!.text = currentItem.content
    }

    inner class NotifiHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!),
        View.OnClickListener {
        val tvTitle = itemView?.findViewById<TextView>(R.id.tv_title)
        val tvContent = itemView?.findViewById<TextView>(R.id.tv_content)

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