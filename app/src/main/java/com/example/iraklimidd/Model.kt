package com.example.iraklimidd

import com.google.gson.annotations.SerializedName

data class Teams(
    val id: String?,
    val name: String?,
    val imageUrl: String?,
    val description: String?,
    val FoundYear: Int?,
    val website: String?
)

data class ReqresObj<T>(
    var page: Int?,
    @SerializedName("per_page")
    var perPage: Int?,
    var total: Long?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    var data: T?
)