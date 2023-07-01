package com.example.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.summerpractice.databinding.FragmentPremiumStatusBinding
import com.google.android.material.snackbar.Snackbar

class PremiumStatusFragment : Fragment(R.layout.fragment_premium_status) {

    private var fragmentBinding: FragmentPremiumStatusBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentPremiumStatusBinding.bind(view)

        val arg = arguments?.getString(ARG_KEY) ?: getString(R.string.not_found_parent_fragment_name_message)

        Snackbar.make(fragmentBinding!!.root, arg, Snackbar.LENGTH_LONG).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentBinding = null
    }

    companion object {
        private const val ARG_KEY = "ARG_KEY"
        fun createBundle(value: String): Bundle {
            val bundle = Bundle()
            bundle.putString(ARG_KEY, value)
            return bundle
        }
    }

}