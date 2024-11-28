package com.example.thick_o_meter.presentation.mainFragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thick_o_meter.R
import com.example.thick_o_meter.databinding.FragmentMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val vm: MainViewModel by viewModel<MainViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUi()
    }

    private fun initUi(){
        with(binding){

            fragmentMainButton.setOnClickListener {
                startMeasuring()
            }

            fragmentMainResult.visibility = View.INVISIBLE
        }
    }

    private fun startMeasuring(){
        binding.fragmentMainResult.visibility = View.VISIBLE

        val animationJob = CoroutineScope(Dispatchers.Main).launch {
            val string = "Измерение"
            with(binding) {
                while (true) {
                    fragmentMainResult.text = string
                    delay(200)
                    fragmentMainResult.text = "$string."
                    delay(200)
                    fragmentMainResult.text = "$string.."
                    delay(200)
                    fragmentMainResult.text = "$string..."
                    delay(200)
                }
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            delay((300..900).random().toLong())
            vm.startMeasuring(onComplete = { result ->
                animationJob.cancel()
                binding.fragmentMainResult.text = result
            })
        }
    }
}