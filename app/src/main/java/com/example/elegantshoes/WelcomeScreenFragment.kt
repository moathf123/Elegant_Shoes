package com.example.elegantshoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.elegantshoes.databinding.FragmentWelcomeScreenBinding


class WelcomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome_screen,
            container,
            false
        )
        binding.buttonWelcome.setOnClickListener {
            it.findNavController()
                .navigate(WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionFragment())
        }
        return binding.root
    }
}