package com.example.taskplanner.home.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by A.Elkhami on 14/07/2023.
 */
@Composable
fun TodaySection(modifier: Modifier, todayDate: String) {
    Column(modifier = modifier) {
        Text(todayDate, color = Color.Gray)
        Text(
            "Today",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}