package com.example.elegantshoes.models

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.elegantshoes.R
import com.example.elegantshoes.databinding.FragmentShoeDetailBinding


class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )
        //viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.lifecycleOwner = this

        binding.buttonShoeDetailSave.setOnClickListener {
            viewModel.onSaveClicked()
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.buttonShoeDetailCancel.setOnClickListener {
            viewModel.onCancelClicked()
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }
        binding.shoeViewModel = viewModel
        return binding.root
    }
}