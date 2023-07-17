package com.example.taskplanner.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.taskplanner.home.composables.DayWeekItem
import com.example.taskplanner.home.composables.TaskItem
import com.example.taskplanner.home.composables.TodaySection
import com.example.taskplanner.home.model.DayModel
import com.example.taskplanner.home.model.TaskModel

/**
 * Created by A.Elkhami on 14/07/2023.
 */

val daysList: List<DayModel> = listOf(
    DayModel("Mon", 4, false),
    DayModel("Tue", 5, true),
    DayModel("Wed", 6, false),
    DayModel("Thu", 7, false),
    DayModel("Fri", 8, false),
    DayModel("Sat", 9, false),
    DayModel("Sun", 10, false)
)

val taskItems: List<TaskModel> = listOf(
    TaskModel("Wakeup", "Wake up early from the bed", "7:00 AM", false),
    TaskModel("Morning Excersise", "Exersising", "8:00 AM", false),
    TaskModel("Meeting", "Zoom call, Discuss team task for the day", "9:00 AM", true),
    TaskModel(
        "Breakfast",
        "Morning breakfast with bread, banana egg bowel and tea",
        "10:00 AM",
        false
    )
)

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        floatingActionButton = {
            AddTaskButton()
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column {
            TodaySection(
                modifier = Modifier
                    .padding(
                        top = 32.dp,
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
                "May 5, 2023"
            )
            LazyRow(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                items(daysList) { dayItem ->
                    DayWeekItem(modifier = Modifier.size(50.dp, 70.dp), dayItem) {

                    }
                }
            }
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
            ) {
                itemsIndexed(taskItems) { index, task ->
                    TaskItem(modifier = Modifier, task, index == taskItems.size - 1) {

                    }
                }
            }
        }
    }
}

@Composable
fun AddTaskButton() {
    FloatingActionButton(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = blue,
        onClick = {

        }
    ) {
        Icon(
            Icons.Default.Add, "Add",
            tint = Color.White,
            modifier = Modifier.padding(16.dp)
        )
    }
}
