package com.example.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var fragmentBinding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentMainBinding.bind(view)

        val clazzName = this::class.simpleName

        fragmentBinding?.run {
            mainButton.setOnClickListener {
                findNavController().navigate(
                    R.id.action_mainFragment_to_premiumStatusFragment,
                    PremiumStatusFragment.createBundle(clazzName!!))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}