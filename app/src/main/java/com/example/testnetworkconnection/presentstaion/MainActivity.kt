package com.example.testnetworkconnection.presentstaion

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.testnetworkconnection.R
import com.example.testnetworkconnection.core.Result
import com.example.testnetworkconnection.data.model.ResponseCat
import com.example.testnetworkconnection.data.model.ResponseDog
import com.example.testnetworkconnection.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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
        lifecycleScope.launchWhenStarted {
            viewModel.data.collect{
                when(it){
                    is Result.Error -> binding.textId.text = it.message
                    is Result.Success<*> -> {
                        val response = it.data as Response<ResponseDog>
                        val body = response.body()
                        val headers = response.headers()
                        binding.textId.text = body?.fileSizeBytes.toString()
                    }
                    is Result.Empty -> binding.textId.text = "Загрузите данные"
                }
            }
        }
    }

    private fun initView() {
        binding.btnGetData.setOnClickListener { viewModel.fetchData() }
    }
}