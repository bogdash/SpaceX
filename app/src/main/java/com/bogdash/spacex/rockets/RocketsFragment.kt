package com.bogdash.spacex.rockets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bogdash.spacex.R

class RocketsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rockets, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = RocketsFragment()
    }
}