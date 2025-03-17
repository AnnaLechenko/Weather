package com.annalech.weather.presentation.secondPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.annalech.weather.R
import com.annalech.weather.databinding.ErrorLoadFragmentBinding

class ErrorLoadFragment  : Fragment(R.layout.error_load_fragment) {
    private var _binding: ErrorLoadFragmentBinding? = null
    private val binding:ErrorLoadFragmentBinding
        get() = _binding ?: throw RuntimeException("ErrorLoadFragmentBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ErrorLoadFragmentBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}