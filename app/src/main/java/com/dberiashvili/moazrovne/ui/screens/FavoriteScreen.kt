package com.dberiashvili.moazrovne.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dberiashvili.moazrovne.ui.QuestionViewModel
import com.dberiashvili.moazrovne.ui.components.ExpandableCard
import com.dberiashvili.moazrovne.ui.model.QuestionModel

@Composable
fun FavoriteScreen(
        viewModel: QuestionViewModel = hiltViewModel()
) {
        viewModel.getFavoriteQuestions()
        val questions = viewModel.questions.collectAsState().value
        CheckSavedQuestions(questions, viewModel)

}

@Composable
fun CheckSavedQuestions(questions: List<QuestionModel>, viewModel: QuestionViewModel) {
        if (questions.isEmpty()) {
                Text(text = "ჯერ არ დაგიმატებიათ")
        } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(questions) {
                                ExpandableCard(
                                        questionId = it.questionId,
                                        titleFontSize = TextUnit.Unspecified,
                                        titleFontWeight = FontWeight(15),
                                        answer = it.answer,
                                        author = it.author ?: "",
                                        descriptionFontSize = TextUnit.Unspecified,
                                        descriptionFontWeight = FontWeight(5),
                                        descriptionMaxLines = 4,
                                        shape = RoundedCornerShape(5),
                                        padding = 5.dp,
                                        image = it.questionImg ?: "",
                                        questionText = it.questionText,
                                        question = it,
                                        saveQuestion = {
                                                viewModel.saveQuestion(it)
                                        }
                                )
                        }
                }
        }
}
