package com.example.summerpractice

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.summerpractice.databinding.PlanetItemBinding

class PlanetItem(
    private val planetBinding: PlanetItemBinding,
    private val requestManager: RequestManager,
    private val onItemClick: (Planet) -> Unit
) : ViewHolder(planetBinding.root) {

    fun onBind(planet: Planet) {
        planetBinding.run {
            itemName.text = planet.name
            requestManager
                .load(planet.url)
                .error(R.drawable.image_not_found)
                .into(imageView)
            root.setOnClickListener {
                onItemClick(planet)
            }
        }
    }

}