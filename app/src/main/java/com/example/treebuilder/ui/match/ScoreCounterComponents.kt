package com.example.treebuilder.ui.match

import android.content.pm.ActivityInfo
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.treebuilder.Constants.PLAYER_ONE
import com.example.treebuilder.Constants.PLAYER_TWO
import com.example.treebuilder.LockScreenOrientation
import com.example.treebuilder.R
import com.example.treebuilder.getSetPointsBorder
import com.example.treebuilder.ui.theme.CherryBombOne

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Table(
    scoreCounterViewModel: ScoreCounterViewModel
) {
    val config = LocalConfiguration.current
    val servingPlayer = scoreCounterViewModel.servingPlayer.value

    LockScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

    Box {
        Icon(
            painterResource(id = R.drawable.baseline_undo_24_blue),
            tint = Color(0xFF6691D3),
            contentDescription = null,
            modifier = Modifier.combinedClickable(
                onClick = { scoreCounterViewModel.onBackPress() },
                onLongClick = { scoreCounterViewModel.clearScores(true) }
            )
                .size(65.dp)
                .align(Alignment.TopCenter)
                .padding(top = 0.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor =
                    if (scoreCounterViewModel.setEnded.value && scoreCounterViewModel.p1Score.value > scoreCounterViewModel.p2Score.value) {
                        Color(0xFF177919)
                    } else if (scoreCounterViewModel.setEnded.value && scoreCounterViewModel.p1Score.value < scoreCounterViewModel.p2Score.value) {
                        Color(0xFFA80D31)
                    } else {
                        when (servingPlayer) {
                            0 -> Color(0xFF6691D3)
                            1 -> Color(0xFF1759BD)
                            else -> Color(0xFF6691D3)
                        }
                    }
                ),
                contentPadding = PaddingValues(0.dp),
                onClick = {
                    scoreCounterViewModel.updateScores(PLAYER_ONE)
                },

                modifier = getSetPointsBorder(PLAYER_ONE, scoreCounterViewModel.p1SetScore.value, config),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text(
                    color = Color(0xA4B8D2FF),
                    textAlign = TextAlign.Start,
                    text = scoreCounterViewModel.p1Score.value.toString(),
                    fontSize = 200.sp,
                    fontFamily = CherryBombOne,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
            Button(
                colors = ButtonDefaults.buttonColors(containerColor =
                    if (scoreCounterViewModel.setEnded.value && scoreCounterViewModel.p1Score.value < scoreCounterViewModel.p2Score.value) {
                        Color(0xFF177919)
                    } else if (scoreCounterViewModel.setEnded.value && scoreCounterViewModel.p1Score.value > scoreCounterViewModel.p2Score.value) {
                        Color(0xFFA80D31)
                    } else {
                        when (servingPlayer) {
                            0 -> Color(0xFF6691D3)
                            2 -> Color(0xFF1759BD)
                            else -> Color(0xFF6691D3)
                        }
                    }
                ),
                contentPadding = PaddingValues(0.dp),
                onClick = {
                    scoreCounterViewModel.updateScores(PLAYER_TWO)
                },
                modifier = getSetPointsBorder(PLAYER_TWO,scoreCounterViewModel.p2SetScore.value, config),
                shape = RoundedCornerShape(25.dp),
                elevation = ButtonDefaults
                    .elevatedButtonElevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 0.dp
                    )
            ) {
                Text(
                    color = Color(0xA4B8D2FF),
                    textAlign = TextAlign.Start,
                    text = scoreCounterViewModel.p2Score.value.toString(),
                    fontSize = 200.sp,
                    fontFamily = CherryBombOne,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
        }
    }
}

