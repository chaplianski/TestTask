package com.example.lonia.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lonia.domain.usecase.GetInspectionTypeUseCase
import javax.inject.Inject

class InspectionTypeViewModel @Inject constructor(private val getInspectionTypeUseCase: GetInspectionTypeUseCase): ViewModel() {

    val _inspectionTypeList = MutableLiveData<List<String>>()
    val inspectionTypeList: LiveData<List<String>> get() = _inspectionTypeList

    fun getInspectionTypeList(){
        val list = getInspectionTypeUseCase.execute()
        _inspectionTypeList.postValue(list)
    }
}