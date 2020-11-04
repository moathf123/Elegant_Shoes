package com.example.elegantshoes.models

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.elegantshoes.R
import com.example.elegantshoes.databinding.FragmentShoeListBinding
import timber.log.Timber.i


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeViewModel by activityViewModels()
    lateinit var layout: LinearLayout
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
        //viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.lifecycleOwner = this

        binding.fab.setOnClickListener {
            findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        viewModel.newItemBeenAdded.observe(viewLifecycleOwner, Observer {
            if (it) {
                i("called more")
                viewModel.newItemCompleted()
                createItemList()
            }
        })
        viewModel.itemCanceled.observe(viewLifecycleOwner, {
            if (it) {
                createItemList()
            }
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun createItemList() {
        for (item in viewModel.list) {
            layout = LinearLayout(this.context)
            layout.orientation = LinearLayout.VERTICAL
            val textViewName = TextView(this.context)
            val textViewCompany = TextView(this.context)
            val textViewDescription = TextView(this.context)
            val textViewSize = TextView(this.context)
            val imageView = ImageView(this.context)
            textViewName.text = item.name
            textViewName.textSize = 40F
            textViewCompany.text = item.company
            textViewCompany.textSize = 40F
            textViewDescription.text = item.description
            textViewDescription.textSize = 40F
            textViewSize.text = item.size.toString()
            textViewSize.textSize = 40F
            imageView.setImageResource(item.imageRes)
            layout.addView(imageView)
            layout.addView(textViewName)
            layout.addView(textViewCompany)
            layout.addView(textViewDescription)
            layout.addView(textViewSize)
            binding.myRoot.addView(layout)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)

    }
}