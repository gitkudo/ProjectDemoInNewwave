package com.example.kudonavdrawerdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.adapter.FAQAdapter
import com.example.kudonavdrawerdemo.model.Faq

class FaqFragment : Fragment() {
    private var versionList = ArrayList<Faq>()
    private val versionAdapter = FAQAdapter(versionList)

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_faq, container, false)
        val rvBelow = view?.findViewById<RecyclerView>(R.id.rcvFaq)
        if (rvBelow != null) {
            rvBelow.adapter = versionAdapter
        }
        if (rvBelow != null) {
            rvBelow.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        versionList.add(Faq("質問です","回答です。回答です。回答です。 回答です。回答です。回答です。",false))
        versionList.add(Faq("質問です","回答です。回答です。回答です。 回答です。回答です。回答です。",false))
        versionList.add(Faq("質問です","回答です。回答です。回答です。 回答です。回答です。回答です。",false))
        rvBelow?.setHasFixedSize(true)
        return view
    }
    companion object{
        fun newInstance():Fragment{
            return FaqFragment()
        }
    }

}