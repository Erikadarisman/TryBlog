package com.example.trynoteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var blogAdapter: TestRecylerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecylerView()
        addDataset()


    }

    private fun addDataset() {
        val data = DataSource.createDataSet()
        blogAdapter.submitList(data)
    }

    private fun initRecylerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecoration = TopSpacingitemDecoration(30)
            addItemDecoration(topSpacingDecoration)
            blogAdapter = TestRecylerAdapter()
            adapter = blogAdapter
        }
    }


}
