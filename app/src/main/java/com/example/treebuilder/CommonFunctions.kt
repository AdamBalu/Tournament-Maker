package com.example.treebuilder

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.treebuilder.Constants.PLAYER_ONE
import com.example.treebuilder.Constants.PLAYER_TWO

fun getSetPointsBorder(p: Int, sets: Int, config: Configuration): Modifier {
    val cropStart = if (p == PLAYER_ONE) 20.dp else 125.dp
    val cropEnd = if (p == PLAYER_TWO) 20.dp else 125.dp
    return when (sets) {
        1 -> Modifier
            .fillMaxHeight()
            .width(config.screenWidthDp.dp / 2 - 15.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 10.dp,
                color = Color(0xFF4C7ECB),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )

        2 -> Modifier
            .fillMaxHeight()
            .width(config.screenWidthDp.dp / 2 - 15.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 10.dp,
                color = Color(0xFF3E75C8),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 20.dp,
                color = Color(0xFF3365B1),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )

        3 -> Modifier
            .fillMaxHeight()
            .width(config.screenWidthDp.dp / 2 - 15.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 10.dp,
                color = Color(0xFF3E75C8),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 20.dp,
                color = Color(0xFF3365B1),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 30.dp,
                color = Color(0xFF2B5697),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )

        4 -> Modifier
            .fillMaxHeight()
            .width(config.screenWidthDp.dp / 2 - 15.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 10.dp,
                color = Color(0xFF3E75C8),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 20.dp,
                color = Color(0xFF3365B1),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 30.dp,
                color = Color(0xFF2B5697),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 40.dp,
                color = Color(0xFF24477C),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )

        5 -> Modifier
            .fillMaxHeight()
            .width(config.screenWidthDp.dp / 2 - 15.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 10.dp,
                color = Color(0xFFDEC72B),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )

        6 -> Modifier
            .fillMaxHeight()
            .width(config.screenWidthDp.dp / 2 - 15.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 10.dp,
                color = Color(0xFFDEC72B),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 20.dp,
                color = Color(0xFF3E75C8),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )

        7 -> Modifier
            .fillMaxHeight()
            .width(config.screenWidthDp.dp / 2 - 15.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 10.dp,
                color = Color(0xFFDEC72B),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 20.dp,
                color = Color(0xFF3E75C8),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 30.dp,
                color = Color(0xFF3365B1),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )

        8 -> Modifier
            .fillMaxHeight()
            .width(config.screenWidthDp.dp / 2 - 15.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 10.dp,
                color = Color(0xFFDEC72B),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 20.dp,
                color = Color(0xFF3E75C8),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 30.dp,
                color = Color(0xFF3365B1),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 40.dp,
                color = Color(0xFF2B5697),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )

        9 -> Modifier
            .fillMaxHeight()
            .width(config.screenWidthDp.dp / 2 - 15.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 10.dp,
                color = Color(0xFFDEC72B),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 20.dp,
                color = Color(0xFF3E75C8),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 30.dp,
                color = Color(0xFF3365B1),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 40.dp,
                color = Color(0xFF2B5697),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 50.dp,
                color = Color(0xFF24477C),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )

        10 -> Modifier
            .fillMaxHeight()
            .width(config.screenWidthDp.dp / 2 - 15.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 10.dp,
                color = Color(0xFFDEC72B),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .border(
                width = 20.dp,
                color = Color(0xFFC8B21F),
                shape = RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )

        else -> Modifier
            .fillMaxHeight()
            .width(config.screenWidthDp.dp / 2 - 15.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = cropEnd,
                    topStart = cropStart,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
    }
}