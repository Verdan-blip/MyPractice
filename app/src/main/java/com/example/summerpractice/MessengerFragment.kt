package com.example.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentMainBinding
import com.example.summerpractice.databinding.FragmentMessengerBinding

class MessengerFragment : Fragment(R.layout.fragment_messenger) {

    private var fragmentBinding: FragmentMessengerBinding? = null;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentMessengerBinding.bind(view)

        val clazzName = this::class.simpleName

        fragmentBinding?.run {
            messengerButton.setOnClickListener {
                findNavController().navigate(
                    R.id.action_messengerFragment_to_premiumStatusFragment,
                    PremiumStatusFragment.createBundle(clazzName!!))
            }
        }
    }
}