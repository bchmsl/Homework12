package com.bchmsl.homework12.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bchmsl.homework12.R
import com.bchmsl.homework12.adapter.ModelsAdapter
import com.bchmsl.homework12.databinding.FragmentModelsBinding
import com.bchmsl.homework12.model.Data
import com.bchmsl.homework12.model.Model

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
        setupSpinner()
    }

    private fun setupSpinner() {
        val categoriesList = mutableListOf<String>("All")
        Model.Companion.Category.values().forEach {
            categoriesList.add(it.categoryName)
        }
        val spinnerAdapter =
            ArrayAdapter(requireContext(), R.layout.layout_spinner_item, categoriesList)
        binding.spCategories.adapter = spinnerAdapter
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
                binding.spCategories.setSelection(0)
                filter(newText)
                return true
            }
        })
        adapter.itemClickListener = {
            findNavController().navigate(
                ModelsFragmentDirections.actionModelsFragmentToModelOpenedFragment(
                    modelId = it.id
                )
            )
        }
        binding.spCategories.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = binding.spCategories.selectedItem
                if (selectedItem == "All") {
                    adapter.submitList(Data.carsList)
                } else {
                    val newList = selectModels(selectedItem as String)
                    adapter.submitList(newList)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }

    private fun selectModels(categoryName: String): List<Model> =
        Data.carsList.filter { it.category.categoryName == categoryName }


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