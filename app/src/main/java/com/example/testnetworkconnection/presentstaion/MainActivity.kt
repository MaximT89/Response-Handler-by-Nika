package com.example.testnetworkconnection.presentstaion

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.activity.viewModels
import com.example.testnetworkconnection.R
import com.example.testnetworkconnection.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initObservers()
    }

    private fun initObservers() {
        viewModel.data.observe(this){
            binding.textId.text = it.body()?.id.toString()
        }
    }

    private fun initView() {
        binding.btnGetData.setOnClickListener { viewModel.fetchData() }
    }
}