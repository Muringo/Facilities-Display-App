package com.example.facilitiesdisplay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.facilitiesdisplay.model.OptionsItem
import com.example.faclitiesdisplay.R

class OptionsAdapter(
    private val options: List<OptionsItem>,
    private val listener: FacilitiesAdapter.FacilitiesListener
) : RecyclerView.Adapter<OptionsAdapter.OptionViewHolder>() {

    private val selectedOptions: MutableList<OptionsItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_option, parent, false)
        return OptionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        val option = options[position]
        holder.optionCheckBox.text = option.name

        holder.optionCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedOptions.add(option)
            } else {
                selectedOptions.remove(option)
            }
        }
    }

    override fun getItemCount(): Int {
        return options.size
    }

    fun getSelectedOption(): OptionsItem? {
        return if (selectedOptions.isNotEmpty()) selectedOptions[0] else null
    }

    class OptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val optionCheckBox: CheckBox = itemView.findViewById(R.id.optionCheckBox)
    }
}
