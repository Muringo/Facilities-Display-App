package com.example.facilitiesdisplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facilitiesdisplay.model.FacilitiesItem
import com.example.facilitiesdisplay.model.OptionsItem
import com.example.faclitiesdisplay.R

class MainActivity : AppCompatActivity(), FacilitiesAdapter.FacilitiesListener, FacilitiesContract.View {

    private lateinit var facilitiesRecyclerView: RecyclerView
    private lateinit var facilitiesAdapter: FacilitiesAdapter
    private lateinit var presenter: FacilitiesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        facilitiesRecyclerView = findViewById(R.id.facilitiesRecyclerView)
        facilitiesAdapter = FacilitiesAdapter(this)
        facilitiesRecyclerView.layoutManager = LinearLayoutManager(this)
        facilitiesRecyclerView.adapter = facilitiesAdapter

        presenter = FacilitiesPresenter(this)
        presenter.fetchFacilities()
    }

    override fun onFacilitySelected(facility: FacilitiesItem, option: OptionsItem) {
        presenter.handleFacilitySelection(facility, option)
    }

    override fun showFacilities(facilities: List<FacilitiesItem>) {
        facilitiesAdapter.setFacilities(facilities)
    }

    override fun showErrorMessage(message: String) {
        println("Error: $message")
    }
}