package com.example.testnetworkconnection.data.model

import com.google.gson.annotations.SerializedName

data class ResponseDog(

	@field:SerializedName("fileSizeBytes")
	val fileSizeBytes: Int? = null,

	@field:SerializedName("url")
	val url: String? = null
)
