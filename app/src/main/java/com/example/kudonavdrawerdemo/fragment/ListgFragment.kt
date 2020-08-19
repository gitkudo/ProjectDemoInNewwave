package com.example.kudonavdrawerdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.OnItemClickListener
import com.example.kudonavdrawerdemo.adapter.ListProAdapter
import com.example.newwavesell.model.Pro


class ListgFragment : Fragment(),OnItemClickListener {
    private val proList = generateList()
    private val adapter = ListProAdapter(proList, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_listg, container, false)
        val recyclerView = root?.findViewById<RecyclerView>(R.id.recyclerView)
        if (recyclerView != null) {
            recyclerView.adapter = adapter
        }
        if (recyclerView != null) {
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
        recyclerView?.setHasFixedSize(true)
        return root
    }
    private fun generateList(): ArrayList<Pro> {
        val list = ArrayList<Pro>()
        for (i in 0..8) {
            val itemPro = Pro("T-shirt $i", 100, "L", R.color.colorPrimary, 1000, "5/4/1999")
            list += itemPro
        }
        return list
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(context,"clicked",Toast.LENGTH_SHORT).show()
    }
    companion object {
        fun newInstance(): Fragment {
            return ListgFragment()
        }
    }
}