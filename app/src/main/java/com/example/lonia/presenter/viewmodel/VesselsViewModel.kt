package com.example.lonia.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lonia.domain.usecase.GetVesselsUseCase
import kotlinx.coroutines.cancel
import javax.inject.Inject

class VesselsViewModel @Inject constructor(private val getVasselsUseCase: GetVesselsUseCase) :
    ViewModel() {

    val _vassels = MutableLiveData<List<String>>()
    val vassels: LiveData<List<String>> get() = _vassels

    fun getListVassels() {
        val vasselsList = getVasselsUseCase.execute()
        _vassels.postValue(vasselsList)
    }

    override fun onCleared() {
        viewModelScope.cancel()
    }
}