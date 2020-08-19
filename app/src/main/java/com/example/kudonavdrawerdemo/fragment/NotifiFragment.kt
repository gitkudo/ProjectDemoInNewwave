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
import com.example.kudonavdrawerdemo.adapter.NotifiAdapter
import com.example.kudonavdrawerdemo.model.Nontifi
import com.example.newwavesell.model.Pro


class NotifiFragment : Fragment(),OnItemClickListener {
    private val nonList = generateList()
    private val adapter = NotifiAdapter(nonList, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_notifi, container, false)
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
    private fun generateList(): ArrayList<Nontifi> {
        val list = ArrayList<Nontifi>()
        for (i in 0..4) {
            val itemPro = Nontifi("お知らせ","お知らせです。お知らせです。お知らせです。")
            list += itemPro
        }
        return list
    }

    companion object {
        fun newInstance(): Fragment {
            return NotifiFragment()
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(context,"clicked",Toast.LENGTH_SHORT).show()
    }
}