package com.example.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentClipsBinding

class ClipsFragment : Fragment(R.layout.fragment_clips) {

    private var fragmentBinding: FragmentClipsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentClipsBinding.bind(view)

        val clazzName = this::class.simpleName

        fragmentBinding?.run {
            clipsButton.setOnClickListener {
                findNavController().navigate(
                    R.id.action_clipsFragment_to_premiumStatusFragment,
                    PremiumStatusFragment.createBundle(clazzName!!))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }
}