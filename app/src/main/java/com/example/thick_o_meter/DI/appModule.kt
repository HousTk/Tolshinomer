package com.example.thick_o_meter.DI

import com.example.thick_o_meter.navigationController.NavigationController
import com.example.thick_o_meter.presentation.mainActivity.MainActivityViewModel
import com.example.thick_o_meter.presentation.mainFragment.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.single

val appModule = module {
    single<NavigationController> {
        NavigationController()
    }

    viewModel<MainActivityViewModel> {
        MainActivityViewModel(
            navigationController = get()
        )
    }

    viewModel<MainViewModel> {
        MainViewModel(
            navController = get()
        )
    }
}