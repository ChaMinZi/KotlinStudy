package com.example.kotlinstudy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlinstudy.R
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        // move to fragment bookmark
        val favorite = view.findViewById<Button>(R.id.btn_favorite)
        favorite.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_fg_account_to_fg_bookmark)
        }



        return view
    }
}