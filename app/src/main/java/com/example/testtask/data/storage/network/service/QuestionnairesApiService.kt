package com.example.testtask.data.storage.network.service

import com.example.testtask.data.storage.model.QuestionnairesData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface QuestionnairesApiService {

    @GET("api/question")
    suspend fun fetchQuestionnaires(@Header("Authorization") token: String): Response<List<QuestionnairesData>>


}