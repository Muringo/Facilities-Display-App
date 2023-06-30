package com.example.facilitiesdisplay

import com.example.facilitiesdisplay.model.FacilitiesItem
import com.example.facilitiesdisplay.model.OptionsItem

interface FacilitiesContract {

    interface View {
        fun showFacilities(facilities: List<FacilitiesItem>)
        fun showErrorMessage(message: String)
    }

    interface Presenter {
        fun fetchFacilities()
        fun handleFacilitySelection(facility: FacilitiesItem, option: OptionsItem)
    }
}
