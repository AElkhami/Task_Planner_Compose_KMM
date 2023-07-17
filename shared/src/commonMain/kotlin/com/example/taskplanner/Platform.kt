package com.example.taskplanner

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform