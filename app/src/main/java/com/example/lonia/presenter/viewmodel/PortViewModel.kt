package com.example.lonia.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lonia.domain.usecase.GetPortUseCase
import kotlinx.coroutines.cancel
import javax.inject.Inject

class PortViewModel @Inject constructor(
    private val getPortUseCase: GetPortUseCase
    ): ViewModel() {

        val _portList = MutableLiveData<List<String>>()
        val portList: LiveData<List<String>> get() = _portList

    fun getPortList (){
        val ports = getPortUseCase.execute()
        _portList.postValue(ports)
    }

    override fun onCleared() {
        viewModelScope.cancel()
    }
}