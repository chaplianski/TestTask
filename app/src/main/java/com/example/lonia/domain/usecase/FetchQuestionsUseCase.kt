package com.example.lonia.domain.usecase

import android.util.Log
import com.example.lonia.R
import com.example.lonia.domain.exceptions.InternetConnectionException
import com.example.lonia.domain.exceptions.NetworkException
import com.example.lonia.domain.model.Questions
import com.example.lonia.domain.repository.QuestionsRepository
import java.io.IOException
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject

class FetchQuestionsUseCase @Inject constructor(private val questionsRepository: QuestionsRepository) {

    suspend fun execute(qid: Int): Result<List<Questions>> {
        Log.d("MyLog", "fetch question use case, qid: $qid")
        return Result.runCatching {
            try {
                questionsRepository.fetchQuestions(qid)
            }catch (e: IOException){
                throw  InternetConnectionException(R.string.internet_error)
            }catch (e: UnknownHostException){
                throw  NetworkException(R.string.server_error)
            }catch (e: ConnectException){
                throw  InternetConnectionException(R.string.client_error)
            }
        }
    }
}