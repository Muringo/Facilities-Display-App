package com.example.facilitiesdisplay

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.facilitiesdisplay.model.FacilitiesItem
import com.example.facilitiesdisplay.model.OptionsItem
import com.example.faclitiesdisplay.R

class FacilitiesAdapter(private val listener: FacilitiesListener) : RecyclerView.Adapter<FacilitiesAdapter.FacilityViewHolder>() {

    private var facilities: List<FacilitiesItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacilityViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_facility, parent, false)
        return FacilityViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FacilityViewHolder, position: Int) {
        val facility = facilities[position]
        holder.facilityName.text = facility.name

        val optionsAdapter = OptionsAdapter(facility.options ?: emptyList(), listener)
        holder.optionsRecyclerView.adapter = optionsAdapter

        holder.itemView.setOnClickListener {
            optionsAdapter.getSelectedOption()
                ?.let { it1 -> listener.onFacilitySelected(facility, it1) }
        }
    }

    override fun getItemCount(): Int {
        return facilities.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFacilities(facilities: List<FacilitiesItem>) {
        this.facilities = facilities
        notifyDataSetChanged()
    }

    interface FacilitiesListener {
        fun onFacilitySelected(facility: FacilitiesItem, option: OptionsItem)
    }

    class FacilityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val facilityName: TextView = itemView.findViewById(R.id.facilityName)
        val optionsRecyclerView: RecyclerView = itemView.findViewById(R.id.optionsRecyclerView)
    }
}
