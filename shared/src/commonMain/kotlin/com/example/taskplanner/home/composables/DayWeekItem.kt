package com.example.taskplanner.home.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.taskplanner.home.blue
import com.example.taskplanner.home.model.DayModel

/**
 * Created by A.Elkhami on 14/07/2023.
 */
@Composable
fun DayWeekItem(
    modifier: Modifier,
    dayModel: DayModel,
    onItemSelected: (DayModel) -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                onItemSelected(dayModel)
            }
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = dayModel.dayName,
            color = if (dayModel.isSelected) blue else Color.Gray
        )
        Text(
            text = dayModel.dayNumber.toString(),
            color = if (dayModel.isSelected) blue else Color.Black
        )

        if (dayModel.isSelected) {
            Canvas(modifier = Modifier.size(15.dp).padding(top = 8.dp), onDraw = {
                drawCircle(blue)
            })
        }
    }
}