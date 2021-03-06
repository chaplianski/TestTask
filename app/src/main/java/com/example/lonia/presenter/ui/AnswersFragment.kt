package com.example.lonia.presenter.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lonia.R
import com.example.lonia.presenter.adapter.QuestionsAdapter
import com.example.lonia.presenter.factories.AnswersViewModelFactory
import com.example.lonia.presenter.viewmodel.AnswersViewModel
import com.example.lonia.di.DaggerAppComponent
import javax.inject.Inject


class AnswersFragment : Fragment() {

    @Inject
    lateinit var answersViewModelFactory: AnswersViewModelFactory
    val answersViewModel: AnswersViewModel by viewModels { answersViewModelFactory }

    override fun onAttach(context: Context) {
        DaggerAppComponent.builder()
            .context(context)
            .build()
            .answersFragmentInject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val activitySupport = activity as AppCompatActivity
        activitySupport.title = "Answers"
        activitySupport.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        activitySupport.supportActionBar?.setDisplayShowHomeEnabled(false)

        return inflater.inflate(R.layout.fragment_answers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val briefcaseId = sharedPref?.getLong(Constants.CURRENT_BRIEFCASE, 0)

        if (briefcaseId != null) {
            answersViewModel.getAnswers(briefcaseId)
        }

        answersViewModel.answersList.observe(this.viewLifecycleOwner) {

            val answersAdapter = QuestionsAdapter(it)
            val questionsRV = view.findViewById<RecyclerView>(R.id.rv_answers)
            questionsRV.layoutManager = LinearLayoutManager(context)
            questionsRV.adapter = answersAdapter

            answersAdapter.shortOnClickListener =
                object : QuestionsAdapter.ShortOnClickListener {
                    override fun ShortClick(
                        question: String,
                        comment: String,
                        questionId: String,
                        isAnswered: Boolean

                    ) {
                        sharedPref?.edit()?.putString(Constants.CURRENT_QUESTION_ID, questionId)
                            ?.apply()
                        sharedPref?.edit()?.putString(Constants.CURRENT_QUESTION, question)?.apply()
                        sharedPref?.edit()?.putString(Constants.CURRENT_COMMENT, comment)?.apply()
                        sharedPref?.edit()?.putBoolean(Constants.CURRENT_ISANSWERED, isAnswered)
                            ?.apply()
                        Log.d("My Log", "from answers fragment: isAnswered: $isAnswered")
                        navController.navigate(R.id.action_answersFragment_to_answerFragment)
                    }
                }
        }
    }
}