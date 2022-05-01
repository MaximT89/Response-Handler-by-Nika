package com.example.testnetworkconnection.presentstaion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testnetworkconnection.data.model.ResponseCat
import com.example.testnetworkconnection.domain.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: UseCase<Response<ResponseCat>>
) : ViewModel() {

    private var _data : MutableLiveData<Response<ResponseCat>> = MutableLiveData<Response<ResponseCat>>()
    val data : LiveData<Response<ResponseCat>> get() = _data

    fun fetchData() {
        viewModelScope.launch {
            _data.value = useCase.get()
        }
    }

}
