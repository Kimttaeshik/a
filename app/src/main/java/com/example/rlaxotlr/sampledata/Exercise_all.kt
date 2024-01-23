package com.example.rlaxotlr.sampledata

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exercise_all(var exercise_name: String, var Sets: ArrayList<Int>, var Weight: ArrayList<Int>): Parcelable