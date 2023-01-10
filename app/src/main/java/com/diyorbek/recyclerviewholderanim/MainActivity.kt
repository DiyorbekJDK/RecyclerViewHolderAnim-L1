package com.diyorbek.recyclerviewholderanim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.diyorbek.recyclerviewholderanim.adapter.RvAdapter
import com.diyorbek.recyclerviewholderanim.databinding.ActivityMainBinding
import com.diyorbek.recyclerviewholderanim.model.Model

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val rvAdapter by lazy { RvAdapter() }
    private val modelList: MutableList<Model> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = rvAdapter
        }
        uploadData()
    }

    private fun uploadData() {
        repeat(100){
            modelList.add(Model("Sample $it"))
        }
        rvAdapter.modelList = modelList
    }
}