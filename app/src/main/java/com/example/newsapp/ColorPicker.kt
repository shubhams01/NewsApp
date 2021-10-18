package com.example.newsapp

object ColorPicker {
    val colors = arrayOf("#ff7f50", "#ff7f50", "#87cefa", "#da70d6", "#da70d6", "#da70d6", "#32cd32")
    var colorIndex = 1
    fun getColor(): String {
        return colors[colorIndex++ % colors.size]
    }
}