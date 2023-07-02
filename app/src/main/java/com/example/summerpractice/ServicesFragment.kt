package com.example.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentServicesBinding
import com.example.summerpractice.databinding.FragmentVideosBinding

class ServicesFragment : Fragment(R.layout.fragment_services) {

    private var fragmentBinding: FragmentServicesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentServicesBinding.bind(view)

        val clazzName = this::class.simpleName

        fragmentBinding?.run {
            servicesButton.setOnClickListener {
                findNavController().navigate(
                    R.id.action_servicesFragment_to_premiumStatusFragment,
                    PremiumStatusFragment.createBundle(clazzName!!))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}