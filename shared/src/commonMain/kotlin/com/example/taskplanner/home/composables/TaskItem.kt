package com.example.taskplanner.home.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import com.example.taskplanner.home.blue
import com.example.taskplanner.home.grey
import com.example.taskplanner.home.model.TaskModel

/**
 * Created by A.Elkhami on 14/07/2023.
 */
@Composable
fun TaskItem(
    modifier: Modifier,
    task: TaskModel,
    isLastItem: Boolean,
    onTaskClick: (TaskModel) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.height(IntrinsicSize.Min)
    ) {
        TaskProgress(modifier = Modifier.weight(1f),task,  isLastItem)
        TaskContent(modifier = Modifier.weight(4f), task, onTaskClick)
    }
}

@Composable
fun TaskContent(
    modifier: Modifier,
    task: TaskModel,
    onTaskClick: (TaskModel) -> Unit
) {
    Column(
        modifier = modifier
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color = if (task.isInProgress) blue else grey)
            .clickable {
                onTaskClick(task)
            }
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                task.name,
                color = if (task.isInProgress) Color.White else Color.Black,
                fontWeight = Bold
            )
            Text(task.time, color = if (task.isInProgress) Color.White else Color.Gray)
        }
        Text(task.desc, color = if (task.isInProgress) Color.White else Color.Gray)
    }
}

@Composable
fun TaskProgress(
    modifier: Modifier,
    task: TaskModel,
    isLastItem: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(4.dp)
    ) {
        Canvas(modifier = Modifier.size(20.dp), onDraw = {
            drawCircle(
                color = blue,
                style = Stroke(4f),
                radius = 20f
            )
            if(task.isInProgress){
                drawCircle(
                    color = blue,
                    radius = 15f
                )
            }
        })
        Spacer(modifier = Modifier.height(8.dp))
        if (!isLastItem) {
            Divider(
                color = blue,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp)
            )
        }
    }
}