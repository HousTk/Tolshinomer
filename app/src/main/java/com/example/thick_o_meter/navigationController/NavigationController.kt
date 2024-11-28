package com.example.thick_o_meter.navigationController

import androidx.navigation.NavController
import com.example.thick_o_meter.R

class NavigationController() {
    private lateinit var navHost: NavController

    fun setUpNavHost(host: NavController) {
        navHost = host
        val navGraph = navHost.navInflater.inflate(R.navigation.navigation)
        navHost.graph = navGraph
    }

}