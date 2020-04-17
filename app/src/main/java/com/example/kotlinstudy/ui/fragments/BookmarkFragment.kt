package com.example.kotlinstudy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.R
import com.example.kotlinstudy.adapters.BookmarkRVadapter
import com.example.kotlinstudy.database.BookmarkCityEntity
import com.example.kotlinstudy.database.BookmarkViewModel

class BookmarkFragment : Fragment() {

    private lateinit var bookmarkViewModel: BookmarkViewModel
    private val bookmarkList: ArrayList<BookmarkCityEntity> by lazy { arrayListOf<BookmarkCityEntity>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookmarkViewModel = ViewModelProviders.of(this).get(BookmarkViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bookmark_cities, container, false)
        bookmark_list = view.findViewById<RecyclerView>(R.id.bookmark_trip_mylist)

        val mAdapter = BookmarkRVadapter(context, bookmarkList)
        bookmark_list.layoutManager = LinearLayoutManager(context)
        bookmark_list.adapter = mAdapter

        bookmarkViewModel.getAll().observe(viewLifecycleOwner, Observer {
            bookmarkList.clear()
            bookmarkList.addAll(it!!)
            mAdapter.notifyDataSetChanged()
        })

        return view
    }

    companion object {
        private lateinit var bookmark_list : RecyclerView
    }
}
