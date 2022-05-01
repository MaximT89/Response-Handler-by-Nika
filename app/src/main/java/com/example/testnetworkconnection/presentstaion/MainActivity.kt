package com.example.testnetworkconnection.presentstaion

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.activity.viewModels
import com.example.testnetworkconnection.R
import com.example.testnetworkconnection.core.Result
import com.example.testnetworkconnection.data.model.ResponseCat
import com.example.testnetworkconnection.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
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
            when(it){
                is Result.Error -> binding.textId.text = it.message
                is Result.Success<*> -> {
                    val s = it.data as Response<ResponseCat>
                    val b = s.body()
                    binding.textId.text = b?.id.toString()
                }
            }
        }
    }

    private fun initView() {
        binding.btnGetData.setOnClickListener { viewModel.fetchData() }
    }
}