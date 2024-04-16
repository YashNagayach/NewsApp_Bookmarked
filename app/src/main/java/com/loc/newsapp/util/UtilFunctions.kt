package com.loc.newsapp.util

import java.text.SimpleDateFormat
import java.util.Locale

fun formatDateString(inputDateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault())

    val dateTime = inputFormat.parse(inputDateString)
    return outputFormat.format(dateTime)
}