package com.example.kotlinstudy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.R
import com.example.kotlinstudy.database.BookmarkCityEntity
import kotlinx.android.synthetic.main.list_trip_bookmark.view.*

class BookmarkRVadapter(val context: Context?, val favorites: List<BookmarkCityEntity>) : RecyclerView.Adapter<BookmarkRVadapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_trip_bookmark, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return favorites.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(favorites[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(bookmark : BookmarkCityEntity) {
            itemView.list_bookmark_location.text = bookmark.name
            itemView.list_bookmark_url.text = bookmark.url
        }
    }
}