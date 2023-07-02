package com.example.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentVideosBinding

class VideosFragment : Fragment(R.layout.fragment_videos) {

    private var fragmentBinding: FragmentVideosBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentVideosBinding.bind(view)

        val clazzName = this::class.simpleName

        fragmentBinding?.run {
            videosButton.setOnClickListener {
                findNavController().navigate(
                    R.id.action_videosFragment_to_premiumStatusFragment,
                    PremiumStatusFragment.createBundle(clazzName!!))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}