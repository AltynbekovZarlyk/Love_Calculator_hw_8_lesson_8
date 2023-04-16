package com.example.love_calculator_hw_5_2.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.love_calculator_hw_5_2.R
import com.example.love_calculator_hw_5_2.data.Pref
import com.example.love_calculator_hw_5_2.onboard.adapter.OnBoardAdapter
import com.example.love_calculator_hw_5_2.databinding.FragmentOnBordBinding
import dagger.hilt.android.AndroidEntryPoint
import me.relex.circleindicator.CircleIndicator3
import javax.inject.Inject

@AndroidEntryPoint
class OnBordFragment : Fragment() {

    private lateinit var binding: FragmentOnBordBinding
    private lateinit var adapter: OnBoardAdapter
    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBordBinding.inflate(inflater,container,false)
        pref = Pref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardAdapter(this::onStartClick)
        binding.viewPager2.adapter = adapter
        setIndicator()
        if (pref.isUserSeen()){
            findNavController().navigate(R.id.calculateFragment)
        }
    }

    private fun setIndicator() {
        val indicator: CircleIndicator3 = binding.indicator
        val viewPager = binding.viewPager2
        indicator.setViewPager(viewPager)
    }

    private fun onStartClick() {
        pref.saveUserSeen()
        findNavController().navigate(R.id.onBordFragment)
    }
}