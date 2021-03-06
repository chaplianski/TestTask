package com.example.lonia.presenter.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lonia.domain.usecase.*
import com.example.lonia.presenter.viewmodel.AnswerViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class AnswerViewModelFactory @Inject constructor(
//    private val getAnswerUseCase: GetAnswerUseCase,
//    private val updateQuestionsUseCase: UpdateQuestionsUseCase,
//    private val updateAnswerUseCase: UpdateAnswerUseCase,
    private val getPhotosUseCase: GetPhotosUseCase,
//    private val updatePhotosUseCase: UpdatePhotosUseCase,
    private val insertPhotoUseCase: InsertPhotoUseCase,
    private val deletePhotoUseCase: DeletePhotoUseCase,
//    private val updateListQuestionsUseCase: UpdateListQuestionsUseCase,
    private val updateQuestionUseCase: UpdateQuestionUseCase,
    private val getQuestionUseCase: GetQuestionUseCase,
    private val getNotesUseCase: GetNotesUseCase,
//    private val context: Context

) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AnswerViewModel(
//            getAnswerUseCase,
//            updateQuestionsUseCase,
//            updateAnswerUseCase,
            getPhotosUseCase,
//            updatePhotosUseCase,
            insertPhotoUseCase,
            deletePhotoUseCase,
//            updateListQuestionsUseCase,
            updateQuestionUseCase,
            getQuestionUseCase,
            getNotesUseCase,
//            context
        ) as T
    }

}