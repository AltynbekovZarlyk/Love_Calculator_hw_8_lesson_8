package com.example.love_calculator_hw_5_2.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.love_calculator_hw_5_2.App
import com.example.love_calculator_hw_5_2.R
import com.example.love_calculator_hw_5_2.databinding.FragmentCalculatorBinding
import com.example.love_calculator_hw_5_2.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveModel(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                ).observe(viewLifecycleOwner, Observer {
                    App.appDatabase.loveDao().insertLove(it)

                    Log.e("ololo", "initListener: $it")
                    findNavController().navigate(R.id.resultFragment, bundleOf("result" to it))
                })
            }
        }
    }
}