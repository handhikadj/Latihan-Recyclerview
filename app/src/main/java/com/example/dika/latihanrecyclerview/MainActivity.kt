package com.example.dika.latihanrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dika.latihanrecyclerview.adapter.BlogRecyclerAdapter
import com.example.dika.latihanrecyclerview.models.DataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var blogRecyclerAdapter: BlogRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        addDataSet()

    }

    private fun addDataSet() {
        val data = DataSource.createDataSet()
        blogRecyclerAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingItemDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingItemDecoration)
            blogRecyclerAdapter = BlogRecyclerAdapter()
            adapter = blogRecyclerAdapter
        }
    }
}
