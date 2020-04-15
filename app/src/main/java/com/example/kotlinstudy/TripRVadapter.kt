package com.example.kotlinstudy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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
        val city = itemView?.findViewById<TextView>(R.id.list_trip_city)
        val no = itemView?.findViewById<TextView>(R.id.list_trip_no)
        val url = itemView?.findViewById<TextView>(R.id.list_trip_url)

        fun bind(itemCity : CityX?, context: Context) {
            no?.text = itemCity?.no.toString()
            city?.text = itemCity?.city
            url?.text = itemCity?.url
        }
    }
}