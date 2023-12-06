package com.example.kitchencanvas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val name: String,
    val shortDescription: String,
    val description: String,
    val ingredients: String,
    val tools: String,
    val steps: String,
    val photo: Int
) : Parcelable
