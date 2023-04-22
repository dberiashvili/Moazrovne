package com.dberiashvili.moazrovne.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.dberiashvili.moazrovne.R
import com.dberiashvili.moazrovne.ui.QuestionViewModel
import com.dberiashvili.moazrovne.ui.model.QuestionModel
import com.dberiashvili.moazrovne.ui.theme.Shapes


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(
    viewModel: QuestionViewModel,
    question: QuestionModel,
    questionId: String,
    author: String,
    titleFontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    answer: String,
    comment: String?,
    descriptionFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    descriptionMaxLines: Int = 4,
    shape: Shape = Shapes.medium,
    padding: Dp = 12.dp,
    questionText: String,
    image: String,
) {
    viewModel.isFavorite(questionId)
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    var isFavorite by remember {
        mutableStateOf(question.isFavorite)
    }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = shape,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = questionId,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = author,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )


                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium),
                    onClick = {
                        if (question.isFavorite) {
                            viewModel.deleteQuestion(question)
                        } else {
                            viewModel.saveQuestion(question)
                        }

                    }) {
                    Icon(
                        painter =  if (isFavorite) painterResource(id = R.drawable.baseline_favorite_24) else painterResource(id = R.drawable.baseline_favorite_border_24),
                        contentDescription = "save",
                    )
                }

                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
            if (image != "") {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(10.dp),
                    painter = rememberAsyncImagePainter(model = image),
                    contentDescription = "image"
                )
            }


            Text(
                text = questionText, modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )


            if (expandedState) {
                Divider(modifier = Modifier.fillMaxWidth())
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "${stringResource(id = R.string.answer)} $answer",
                    fontSize = descriptionFontSize,
                    fontWeight = descriptionFontWeight,
                    maxLines = descriptionMaxLines,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "${stringResource(id = R.string.comment)} $comment",
                    fontSize = descriptionFontSize,
                    fontWeight = descriptionFontWeight,
                    maxLines = descriptionMaxLines,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}