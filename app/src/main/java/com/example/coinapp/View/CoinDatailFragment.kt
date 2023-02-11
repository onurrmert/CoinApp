package com.example.coinapp.View

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coinapp.R
import com.example.coinapp.databinding.FragmentCoinDatailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinDatailFragment : BottomSheetDialogFragment() {

    private lateinit var binding : FragmentCoinDatailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCoinDatailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init(){

        binding.textBaseAsset.text = "Symbol: " + getCoin().BaseAsset

        binding.textPriceUsd.text = "Usd:  " + getCoin().PriceUsd

        binding.textPricEur.text = "Euro: " + getCoin().PriceEur

        binding.textChange.text =  "Change 24H: " + getCoin().Change

        binding.textUpdate.text =  "Update: " + getCoin().UpdateAt.substring(11, 19)

        binding.textSymbol.text = getCoin().Symbol
    }

    private fun getCoin() : CoinDatailFragmentArgs{
        val bundle = arguments
        val args = CoinDatailFragmentArgs.fromBundle(bundle!!)
        return args
    }
}