package com.example.kotlinstudy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.network.CityX
import com.example.kotlinstudy.R
import kotlinx.android.synthetic.main.list_mytrip.view.*

class TripRVadapter(val context: Context?, val city: ArrayList<CityX>) : RecyclerView.Adapter<TripRVadapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_mytrip, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return city.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (context != null) {
            holder.bind(city[position], context)
        }
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        fun bind(itemCity : CityX?, context: Context) {
            itemView.list_trip_no.text = itemCity?.no.toString()
            itemView.list_trip_city.text = itemCity?.city
            itemView.list_trip_url.text = itemCity?.url

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "setClickListener : "+ itemCity!!.no+" "+itemCity.city, Toast.LENGTH_LONG).show()
            }
        }
    }
}