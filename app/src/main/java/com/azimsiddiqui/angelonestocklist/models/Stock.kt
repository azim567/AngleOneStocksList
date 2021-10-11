package com.azimsiddiqui.angelonestocklist.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stock(

    @SerializedName("Security Code") val securityCode: Int,
    @SerializedName("Issuer Name") val issuerName: String,
    @SerializedName("Security Id") val securityId: String,
    @SerializedName("Security Name") val securityName: String,
    @SerializedName("Status") val status: String,
    @SerializedName("Group") val group: String,
    @SerializedName("Face Value") val faceValue: Double,
    @SerializedName("ISIN No") val iSINNo: String,
    @SerializedName("Industry") val industry: String,
    @SerializedName("Instrument") val instrument: String

) : Parcelable
