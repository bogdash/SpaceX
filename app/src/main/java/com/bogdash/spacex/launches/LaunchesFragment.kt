package com.bogdash.spacex.launches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bogdash.spacex.R

class LaunchesFragment : Fragment() {
    private lateinit var adapter: LaunchesRecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var launches: ArrayList<Launch>
    private lateinit var launchService: LaunchService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_launches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initRecyclerView(view)
    }

    private fun initData() {
        launchService = LaunchService(requireContext())
        launches = launchService.getLaunches()
    }

    private fun initRecyclerView(view: View) {
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.launches_recycler_view)
        recyclerView.layoutManager = layoutManager
        adapter = LaunchesRecyclerViewAdapter(launches)
        recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = LaunchesFragment()
    }
}