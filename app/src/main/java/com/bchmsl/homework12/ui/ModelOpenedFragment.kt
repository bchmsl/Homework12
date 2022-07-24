package com.bchmsl.homework12.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log.d
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bchmsl.homework12.databinding.FragmentModelOpenedBinding
import com.bchmsl.homework12.extensions.toEuro
import com.bchmsl.homework12.model.Data
import com.google.android.material.snackbar.Snackbar

class ModelOpenedFragment : Fragment() {
    companion object {
        const val NONE = -1
    }

    private var _binding: FragmentModelOpenedBinding? = null
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
        listeners()
    }

    private fun listeners() {
        binding.btnOrder.setOnClickListener {
            Snackbar.make(
                requireContext(),
                binding.btnOrder,
                "Order for your ${binding.tvModel.text} is confirmed!",
                Snackbar.LENGTH_LONG
            )
                .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                .setTextColor(Color.GREEN)
                .show()


            findNavController().popBackStack()
        }
    }

    private fun setContent() {
        if (modelId != NONE) {
            val currentModel = Data.carsList.find { model -> model.id == modelId }
            if (currentModel != null) {
                binding.apply {
                    tvModel.text = currentModel.fullModelName
                    tvPrice.text = currentModel.price?.toEuro() ?: "Price coming soon"
                    ivImage.setImageResource(currentModel.image)
                }
            } else {
                d("TAG", modelId.toString())
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}