package com.bogdash.spacex.rockets

import android.content.Context
import com.bogdash.spacex.R

class RocketService(private val _context: Context) {
    private val context: Context = _context

    fun getRockets(): ArrayList<Rocket> {
        val rockets = arrayListOf<Rocket>()

        val pictureId = arrayOf(
            R.drawable.falconsat01,
            R.drawable.falcon09,
            R.drawable.demosat02
        )

        val rocketId = R.string.rocket
        val rocketTitles = context.getString(rocketId)

        val rocketNameId = arrayOf(
            R.string.rocket_name_5,
            R.string.rocket_name_6,
            R.string.rocket_name_7
        )

        val rocketNames = rocketNameId.map { context.getString(it) }

        val statusId = arrayOf(
            R.string.inactive,
            R.string.active,
            R.string.inactive
        )

        val status = statusId.map { context.getString(it) }

        val isActive = arrayOf(false, true, false)

        for (i in pictureId.indices) {
            val rocket = Rocket(pictureId[i], rocketTitles, rocketNames[i], status[i], isActive[i])
            rockets.add(rocket)
        }
        return rockets
    }
}