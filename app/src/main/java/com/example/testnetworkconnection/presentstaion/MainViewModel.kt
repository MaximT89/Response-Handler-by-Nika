package com.example.testnetworkconnection.presentstaion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testnetworkconnection.core.Result
import com.example.testnetworkconnection.domain.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: UseCase<Result>
) : ViewModel() {

    private var _data : MutableStateFlow<Result> = MutableStateFlow(Result.Empty)
    val data : StateFlow<Result> = _data

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            _data.value = useCase.get()
        }
    }

}
