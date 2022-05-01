package com.example.testnetworkconnection.presentstaion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testnetworkconnection.core.Result
import com.example.testnetworkconnection.domain.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: UseCase<Result>
) : ViewModel() {

    private var _data : MutableLiveData<Result> = MutableLiveData()
    val data : LiveData<Result> get() = _data

    fun fetchData() {
        viewModelScope.launch {
            _data.value = useCase.get()
        }
    }

}
