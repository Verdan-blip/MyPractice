package com.example.summerpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.summerpractice.databinding.PlanetItemBinding

class PlanetAdapter(
    private var list: List<Planet>,
    private val requestManager: RequestManager,
    private val onItemClick: (Planet) -> Unit
) : RecyclerView.Adapter<PlanetItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanetItem = PlanetItem(
        planetBinding = PlanetItemBinding.inflate(
            LayoutInflater.from(parent.context),
        parent,
        false
        ),
        requestManager = requestManager,
        onItemClick = onItemClick
    )

    override fun onBindViewHolder(holder: PlanetItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() : Int = list.size

}