package com.bogdash.spacex

import android.content.Context

class RocketService(private val _context: Context) {
    private val context: Context = _context

    fun getRockets(): ArrayList<Rocket> {
        val rockets = arrayListOf<Rocket>()

        val pictureId = arrayOf(
            R.drawable.falconsat01,
            R.drawable.falcon9,
            R.drawable.demosat02,
            R.drawable.crs
        )

        val launchId = R.string.launch_text
        val launches = context.getString(launchId)

        val rocketNameId = arrayOf(
            R.string.rocket_name_1,
            R.string.rocket_name_2,
            R.string.rocket_name_3,
            R.string.rocket_name_4
        )

        val rocketNames = rocketNameId.map { context.getString(it) }

        val complexId = arrayOf(
            R.string.complex_1,
            R.string.complex_2,
            R.string.complex_3,
            R.string.complex_4
        )

        val complex = complexId.map { context.getString(it) }

        val dateId = arrayOf(
            R.string.date_1,
            R.string.date_2,
            R.string.date_3,
            R.string.date_4
        )

        val dates = dateId.map { context.getString(it) }

        for (i in pictureId.indices) {
            val rocket = Rocket(pictureId[i], launches, rocketNames[i], complex[i], dates[i])
            rockets.add(rocket)
        }

        return rockets
    }
}