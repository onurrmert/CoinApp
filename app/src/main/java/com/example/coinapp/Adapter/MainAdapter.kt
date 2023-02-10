package com.example.coinapp.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coinapp.Model.CoinModel
import com.example.coinapp.Model.MarketsItem
import com.example.coinapp.R
import com.example.coinapp.databinding.RecyclerRowBinding

class MainAdapter(val coinList : ArrayList<MarketsItem>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = RecyclerRowBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_row, parent, false)

        return MainViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.textSymbol.setText(coinList.get(position).symbol)
        holder.binding.textBaseAsset.setText(coinList.get(position).baseAsset)
        holder.binding.textPrice.setText(coinList.get(position).price.toString() + "$")
    }
}