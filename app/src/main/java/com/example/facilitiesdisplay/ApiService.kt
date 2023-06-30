package com.example.facilitiesdisplay

import com.example.facilitiesdisplay.model.FacilityResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/db/")
    fun getFacilities(): Call<FacilityResponse>
}
