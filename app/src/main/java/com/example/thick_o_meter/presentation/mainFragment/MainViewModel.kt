package com.example.thick_o_meter.presentation.mainFragment

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.thick_o_meter.navigationController.NavigationController

class MainViewModel(
    private val navController:NavigationController
) : ViewModel() {

    fun startMeasuring(onComplete:(result:String) -> Unit){
        val result = (100..1000).random()
        val string = "мк"
        if((0..10).random() == 1){
            onComplete("Корыто не бьется")
            return
        }
        if((0..10).random() == 1){
            onComplete("Ей пизда")
            return
        }
        if((0..10).random() == 1){
            onComplete("Шпакля 3 метра")
            return
        }
        onComplete("$result$string")
    }
}