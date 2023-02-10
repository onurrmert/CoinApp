package com.example.coinapp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coinapp.Adapter.MainAdapter
import com.example.coinapp.Model.MarketsItem
import com.example.coinapp.ViewModel.MainViewModel
import com.example.coinapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        getCoin()
    }

    private fun getCoin(){

        viewModel.getCoinList()

        viewModel.coinList.observe(viewLifecycleOwner, Observer {
            if (it.size > 0){
                initRecycler(it)
                binding.progressBar.visibility = View.GONE
            }else{
                binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun initRecycler(coinList : List<MarketsItem>){
        val list = ArrayList<MarketsItem>(coinList)
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = MainAdapter(list)
    }
}