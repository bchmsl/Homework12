package com.bchmsl.homework12.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bchmsl.homework12.adapter.ModelsAdapter
import com.bchmsl.homework12.databinding.FragmentModelsBinding
import com.bchmsl.homework12.model.Data

class ModelsFragment : Fragment() {
    private var _binding: FragmentModelsBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { ModelsAdapter() }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentModelsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        listeners()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.rvModels.adapter = adapter
        adapter.submitList(Data.carsList)
    }

    private fun listeners() {
        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filter(query)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText)
                return true
            }
        })
        adapter.itemClickListener = {
            findNavController().navigate(ModelsFragmentDirections.actionModelsFragmentToModelOpenedFragment(modelId = it.id))
        }
    }

    private fun filter(query: String?) {
        if (query != null) {
            Data.selectedModelsList = Data.carsList.filter { model ->
                model.fullModelName.contains(query, true)
            }
            adapter.submitList(Data.selectedModelsList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}