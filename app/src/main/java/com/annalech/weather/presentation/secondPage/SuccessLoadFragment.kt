package com.annalech.weather.presentation.secondPage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.annalech.weather.R
import com.annalech.weather.databinding.SuccessLoadFragmentBinding

class SuccessLoadFragment  : Fragment(R.layout.success_load_fragment){
    private var binding: SuccessLoadFragmentBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = SuccessLoadFragmentBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}