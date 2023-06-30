package com.example.facilitiesdisplay

import com.example.facilitiesdisplay.model.FacilityResponse
import com.example.facilitiesdisplay.model.FacilitiesItem
import com.example.facilitiesdisplay.model.OptionsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FacilitiesPresenter(private val view: FacilitiesContract.View) : FacilitiesContract.Presenter {

    private val apiService: ApiService = RetrofitClient.createService()

    override fun fetchFacilities() {
        apiService.getFacilities().enqueue(object : Callback<FacilityResponse> {
            override fun onResponse(call: Call<FacilityResponse>, response: Response<FacilityResponse>) {
                if (response.isSuccessful) {
                    val facilityResponse = response.body()
                    val facilities = facilityResponse?.facilities ?: emptyList()
                    val filteredFacilities = facilities.filterIsInstance<FacilitiesItem>()
                    view.showFacilities(filteredFacilities)
                } else {
                    view.showErrorMessage("Failed to fetch facilities")
                }
            }

            override fun onFailure(call: Call<FacilityResponse>, t: Throwable) {
//                view.showErrorMessage("Failed to fetch facilities: ${t.message}")
            }
        })
    }

    override fun handleFacilitySelection(facility: FacilitiesItem, option: OptionsItem) {}
}
