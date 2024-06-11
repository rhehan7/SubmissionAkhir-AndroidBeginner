package com.dicoding.desawisata

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Village(
    val photo: Int,
    val name: String,
    val description: String,
    val location: String,
    val uniqueDetails: String
) : Parcelable
