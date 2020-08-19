package com.example.kudonavdrawerdemo.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.kudonavdrawerdemo.AccountAct
import com.example.kudonavdrawerdemo.R

class HomeFragment : Fragment() {
    companion object {
        fun newInstance(): Fragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val intentImage = view?.findViewById<ImageView>(R.id.img_hero)
        intentImage?.setOnClickListener {
            startActivity(Intent(context, AccountAct::class.java))
        }
        return view
    }
}