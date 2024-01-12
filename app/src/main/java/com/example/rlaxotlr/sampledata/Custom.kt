package com.example.rlaxotlr.sampledata

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Custom(val custom_ex :ArrayList<Exercise_kind>, val custom_name: String): Parcelable