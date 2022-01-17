package com.example.a1_recyclerview_custom_basic_adapter_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a1_recyclerview_custom_basic_adapter_kotlin.adapter.CustomAdapter
import com.example.a1_recyclerview_custom_basic_adapter_kotlin.model.Member


class MainActivity : AppCompatActivity() {
    lateinit var context: Context
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,1)

    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView.adapter = adapter

    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()

        for (i in 0..25){
            members.add(Member("Sarvar $i","Khalmatov $i"))
        }
        return  members
    }

}