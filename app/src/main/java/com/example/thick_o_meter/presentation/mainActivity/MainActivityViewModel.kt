package com.example.thick_o_meter.presentation.mainActivity

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.thick_o_meter.navigationController.NavigationController

class MainActivityViewModel(
    private val navigationController: NavigationController
) : ViewModel() {

    fun initNavCont(navHost: NavController) {
        navigationController.setUpNavHost(navHost)
    }


}