package com.bogdash.spacex.rockets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bogdash.spacex.R

class RocketsFragment : Fragment() {
    private lateinit var adapter: RocketsRecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var rockets: ArrayList<Rocket>
    private lateinit var rocketService: RocketService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rockets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initRecyclerView(view)
    }

    private fun initData() {
        rocketService = RocketService(requireContext())
        rockets = rocketService.getRockets()
    }

    private fun initRecyclerView(view: View) {
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rockets_recycler_view)
        recyclerView.layoutManager = layoutManager
        adapter = RocketsRecyclerViewAdapter(rockets)
        recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = RocketsFragment()
    }
}