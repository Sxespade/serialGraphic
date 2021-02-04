package com.example.myapplication.retrofit

import com.example.myapplication.di.module.Serial
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Example {
    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("results")
    @Expose
    var results: List<Serial>? = null

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null

    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null

}