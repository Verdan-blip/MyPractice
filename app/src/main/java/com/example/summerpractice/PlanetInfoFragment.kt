package com.example.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.summerpractice.databinding.FragmentPlanetInfoBinding

class PlanetInfoFragment : Fragment(R.layout.fragment_planet_info) {

    private var fragmentBinding: FragmentPlanetInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentPlanetInfoBinding.bind(view)

        val planetName = arguments?.getString(ARG_NAME) ?: "Unknown planet"
        val planetId = arguments?.getInt(ARG_ID) ?: -1
        val planetDescription = arguments?.getString(ARG_DESCRIPTION) ?: "Not found"
        val planetURL = arguments?.getString(ARG_URL)

        fragmentBinding?.run {
            textId.text = String.format("ID: $planetId")
            textName.text = String.format("Name: $planetName")
            textDescription.text = String.format("Description: $planetDescription")
            Glide.with(imageViewPlanet.context)
                .load(planetURL)
                .error(R.drawable.image_not_found)
                .into(imageViewPlanet)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentBinding = null
    }

    companion object {

        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_ID = "ARG_ID"
        private const val ARG_URL = "ARG_URL"
        private const val ARG_DESCRIPTION = "ARG_DESCRIPTION"

        fun createBundle(planet: Planet): Bundle {
            val bundle = Bundle()
            bundle.putInt(ARG_ID, planet.id)
            bundle.putString(ARG_NAME, planet.name)
            bundle.putString(ARG_URL, planet.url)
            bundle.putString(ARG_DESCRIPTION, planet.description)
            return bundle
        }

    }

}