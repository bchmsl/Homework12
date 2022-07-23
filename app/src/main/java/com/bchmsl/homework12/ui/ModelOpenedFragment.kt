package com.bchmsl.homework12.ui

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bchmsl.homework12.databinding.FragmentModelOpenedBinding
import com.bchmsl.homework12.extensions.toEuro
import com.bchmsl.homework12.model.Data

class ModelOpenedFragment : Fragment() {
    companion object {
        const val NONE = -1
    }
    private var _binding : FragmentModelOpenedBinding? = null
    private val binding get() = _binding!!
    private val args: ModelOpenedFragmentArgs by navArgs()
    private var modelId = NONE

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentModelOpenedBinding.inflate(inflater, container, false)
        modelId = args.modelId
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        setContent()
    }

    private fun setContent() {
        if (modelId != NONE){
            val currentModel = Data.carsList.find { model -> model.id == modelId }
            if (currentModel != null){
                binding.apply {
                    tvModel.text = currentModel.fullModelName
                    tvPrice.text = currentModel.price?.toEuro() ?: "Price coming soon"
                    ivImage.setImageResource(currentModel.image)
                }
            }else{
                d("TAG", modelId.toString())
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}