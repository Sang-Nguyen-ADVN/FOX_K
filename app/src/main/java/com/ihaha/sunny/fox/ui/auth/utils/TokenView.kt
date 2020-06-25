package com.ihaha.sunny.fox.ui.auth.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TokenView(
    var account_pk: Int? = -1,
    var token: String? = null
) : Parcelable
