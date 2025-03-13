package com.annalech.weather.presentation.secondPage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.annalech.weather.R
import com.annalech.weather.databinding.ErrorLoadFragmentBinding

class ErrorLoadFragment  : Fragment(R.layout.error_load_fragment) {
    private var binding: ErrorLoadFragmentBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = ErrorLoadFragmentBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}