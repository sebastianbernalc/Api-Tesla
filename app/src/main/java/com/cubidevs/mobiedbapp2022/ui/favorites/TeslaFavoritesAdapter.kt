package com.cubidevs.mobiedbapp2022.ui.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cubidevs.mobiedbapp2022.R
import com.cubidevs.mobiedbapp2022.databinding.CardViewItemTeslaBinding
import com.cubidevs.mobiedbapp2022.local.LocalTesla
import com.squareup.picasso.Picasso

class TeslaFavoritesAdapter(
    private val teslaList: ArrayList<LocalTesla>,
    private val onItemClicked: (LocalTesla) -> Unit,
    private val onItemLongClicked:(LocalTesla) ->Unit,
) : RecyclerView.Adapter<TeslaFavoritesAdapter.TeslaFavoritesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeslaFavoritesViewHolder {
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_tesla,parent, false )
        return TeslaFavoritesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TeslaFavoritesViewHolder, position: Int) {
        val tesla=teslaList[position]
        holder.bindTesla(tesla)
        holder.itemView.setOnClickListener{onItemClicked(teslaList[position])}
        holder.itemView.setOnLongClickListener{onItemLongClicked(teslaList[position])
            true}
    }

    override fun getItemCount(): Int=teslaList.size
    fun appendItems(newList:ArrayList<LocalTesla>){
        teslaList.clear()
        teslaList.addAll(newList)
        notifyDataSetChanged()
    }

    class TeslaFavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CardViewItemTeslaBinding.bind(itemView)
        fun bindTesla(tesla: LocalTesla){
            with(binding){
                teslaTitleTextView.text=tesla.title
                releaseDateTextView.text=tesla.author
                voteAverageTextView.text=tesla.publishedAt
                Picasso.get().load(tesla.urlToImage).resize(300,300).into(posterImageView)
            }
        }

    }

}