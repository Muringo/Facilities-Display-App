package com.example.facilitiesdisplay.model

import com.google.gson.annotations.SerializedName

data class FacilityResponse(

	@field:SerializedName("exclusions")
	val exclusions: List<ExclusionsItem?>? = null,

	@field:SerializedName("facilities")
	val facilities: List<FacilitiesItem?>? = null
)

data class FacilitiesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("options")
	val options: List<OptionsItem>? = null,

	@field:SerializedName("facility_id")
	val facilityId: String? = null
)

data class ExclusionsItem(
	@SerializedName("options_id")
	val optionsId: String? = null,

	@SerializedName("facility_id")
	val facilityId: String? = null
)

data class OptionsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
