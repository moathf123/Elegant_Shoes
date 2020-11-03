package com.example.elegantshoes.models

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.elegantshoes.R
import com.example.elegantshoes.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.fab.setOnClickListener {
            it.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        binding.textView2.text = viewModel.name.value
        return binding.root
    }


}