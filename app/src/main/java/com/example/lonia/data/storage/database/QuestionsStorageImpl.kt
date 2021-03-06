package com.example.lonia.data.storage.database

import android.util.Log
import com.example.lonia.data.storage.dao.BriefcaseDao
import com.example.lonia.data.storage.model.AnswersData
import com.example.lonia.data.storage.model.QuestionsData
import com.example.lonia.data.storage.storagies.QuestionsStorage
import javax.inject.Inject

class QuestionsStorageImpl @Inject constructor() : QuestionsStorage {

    @Inject
    lateinit var briefcaseDao: BriefcaseDao

    override fun getQuestionsList(briefcaseId: Long): List<QuestionsData> {
        return briefcaseDao.getAllQuestions(briefcaseId)
    }

//    override fun updateQuestions(questionsData: QuestionsData, answersData: AnswersData) {
//        briefcaseDao.updateQuestionsAndInsertAnswer(questionsData, answersData)
//    }

    override fun getNotAnsweredQuestionsList(briefcaseId: Long): List<QuestionsData> {
        return briefcaseDao.getNotAnsweredQuestions(briefcaseId)
    }

//    override fun updateQuestionsListAddAnswer(questionsIdList: List<String>, answer: AnswersData) {
//        briefcaseDao.updateQuestionsListAndInsertAnswer(questionsIdList, answer)
//    }

    override fun updateQuestion(questionsData: QuestionsData) {
        briefcaseDao.updateOneQuestion(questionsData)
    }

    override fun getQuestion(questionId: String): QuestionsData {
        return briefcaseDao.getQuestion(questionId)
    }
}