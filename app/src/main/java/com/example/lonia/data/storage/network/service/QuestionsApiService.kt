package com.example.lonia.data.storage.network.service

import com.example.lonia.data.storage.model.QuestionsData
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface QuestionsApiService {
    @Headers("Content-Type: application/json")
    @POST("api/question")
    suspend fun fetchQuestions(
        @Header("Authorization") token: String,
        @Body qid: RequestBody
    ): Response<List<QuestionsData>>
}