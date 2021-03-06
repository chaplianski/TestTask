package com.example.lonia.data.repository

import android.util.Log
import com.example.lonia.data.storage.database.QuestionsStorageImpl
import com.example.lonia.data.storage.network.retrofit.QuestionsApiHelper
import com.example.lonia.domain.model.Questions
import com.example.lonia.domain.repository.QuestionsRepository
import javax.inject.Inject

class QuestionsRepositoryImpl @Inject constructor(
    private val questionsStorage: QuestionsStorageImpl,
    private val questionsApiHelper: QuestionsApiHelper
) : QuestionsRepository {

    override fun getQuestions(briefcaseId: Long): List<Questions> {
        return questionsStorage.getQuestionsList(briefcaseId).map { it.questionsMapDataToDomain() }
    }

    override suspend fun fetchQuestions(qid: Int): List<Questions> {
        return questionsApiHelper.getQuestions(qid).map { it.questionsMapDataToDomain() }
    }


    override fun getNotAnsweredQuestions(briefcaseId: Long): List<Questions> {
        return questionsStorage.getNotAnsweredQuestionsList(briefcaseId).map { it.questionsMapDataToDomain() }
    }

//    override fun updateListQuestions(questionsListId: List<String>, answers: Answers) {
//        questionsStorage.updateQuestionsListAddAnswer(questionsListId, answers.answersMapDomainToData())
//    }

    override fun updateQuestion(question: Questions) {
        questionsStorage.updateQuestion(question.questionsMapDomainToData())
    }

    override fun getQuestion(questionId: String): Questions {
        return questionsStorage.getQuestion(questionId).questionsMapDataToDomain()
    }
}