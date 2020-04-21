package com.example.kotlinstudy.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.*
import com.example.kotlinstudy.adapters.TripRVadapter
import com.example.kotlinstudy.database.BookmarkCityEntity
import com.example.kotlinstudy.database.BookmarkViewModel
import com.example.kotlinstudy.network.City
import com.example.kotlinstudy.network.CityX
import com.example.kotlinstudy.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TripFragment : Fragment() {

    private lateinit var bookmarkViewModel: BookmarkViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookmarkViewModel = ViewModelProviders.of(this).get(BookmarkViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_trip, container, false)
        triplist = view.findViewById(R.id.trip_mylist)

        loadData()

        return view
    }

    private fun setAdapter(city: ArrayList<CityX>) {
        val mAdapter = TripRVadapter(context, city) {cityX ->
            Toast.makeText(context, "clicked"+cityX.no, Toast.LENGTH_LONG).show()

            if (findExistByCityId(cityX)) {
                deleteBookmark(cityX)
            }
            else {
                insertBookmark(cityX)
            }
        }
        triplist.adapter = mAdapter
        triplist.layoutManager = LinearLayoutManager(context)
        triplist.setHasFixedSize(true)
    }

    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://progserver.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(RetrofitService::class.java)
        retrofitService.requestCity().enqueue(object : Callback<City> {
            override fun onFailure(call: Call<City>, t: Throwable) {
                Log.e("retrofitService is fail", t.message)
            }

            override fun onResponse(call: Call<City>, response: Response<City>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        setAdapter(it.cities)
                    }
                }
            }

        })
    }

    private fun insertBookmark(city: CityX) {
        val bookmark = BookmarkCityEntity(
            city_id = city.no,
            name = city.city,
            url = city.url
        )
        bookmarkViewModel.insert(bookmark)
    }

    private fun findExistByCityId(city: CityX) : Boolean {
        var chk : Boolean = true
        bookmarkViewModel.getBookmarkById(city.no).observe(viewLifecycleOwner, Observer {
            if (it == null)
                chk = false
        })
        return chk
    }

    private fun deleteBookmark(city: CityX) {
        bookmarkViewModel.delete(city.no)
    }

    companion object {
        private lateinit var triplist : RecyclerView
    }
}