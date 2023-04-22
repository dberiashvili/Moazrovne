package com.dberiashvili.moazrovne.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dberiashvili.moazrovne.ui.QuestionViewModel
import com.dberiashvili.moazrovne.ui.components.ExpandableCard


@Composable
fun QuestionsScreen(
    viewModel: QuestionViewModel  = hiltViewModel()
) {
    val questions = viewModel.questions.collectAsState().value
    LazyColumn(modifier = Modifier
        .background(MaterialTheme.colorScheme.primary)
        .fillMaxSize()) {
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
                comment = it.comment,
                viewModel = viewModel
            )
        }
    }


}