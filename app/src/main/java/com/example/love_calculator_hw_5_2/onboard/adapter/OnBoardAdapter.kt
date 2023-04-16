package com.example.love_calculator_hw_5_2.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.love_calculator_hw_5_2.onboard.OnBoard
import com.example.love_calculator_hw_5_2.R
import com.example.love_calculator_hw_5_2.databinding.ItemOnBoardBinding

class OnBoardAdapter(private val onStartClick: ()->Unit) :
    Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val data = arrayListOf(
        OnBoard(
            "Have a good time!",
            "You should take the time to help those \n who who need you",
            R.raw.first
        ), OnBoard(
            "Cherishing love",
            "It is now no longer possible for\nyou to cherish love",
            R.raw.pair
        ), OnBoard(
            "Have a breakup?",
            "We have made the correction for you\n don't worry\n Maybe someone is waiting for you!",
            R.raw.hands
        ), OnBoard(
            "It's Funs and Many more",
            " ",
            R.raw.rhythm
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.apply {
                onBoard.image?.let { image.setAnimation(it) }
                title.text = onBoard.tittle
                desc.text = onBoard.desc

                binding.btnGetStart.isVisible = adapterPosition == data.lastIndex
                binding.btnGetStart.setOnClickListener {
                    onStartClick()
                }

            }

        }

    }
}