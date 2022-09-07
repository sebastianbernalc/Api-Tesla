package com.cubidevs.mobiedbapp2022.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cubidevs.mobiedbapp2022.R
import com.cubidevs.mobiedbapp2022.databinding.CardViewItemTeslaBinding
import com.cubidevs.mobiedbapp2022.server.model.Article
import com.squareup.picasso.Picasso

class TeslaAdapter(
    private val teslaList: ArrayList<Article>,
    private val onItemClicked: (Article) -> Unit
) : RecyclerView.Adapter<TeslaAdapter.TeslaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeslaViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_tesla,parent, false )
        return TeslaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TeslaViewHolder, position: Int) {
        val tesla=teslaList[position]
        holder.bindTesla(tesla)
        holder.itemView.setOnClickListener{onItemClicked(teslaList[position])}
    }

    override fun getItemCount(): Int=teslaList.size
    fun appendItems(newList:ArrayList<Article>){
        teslaList.clear()
        teslaList.addAll(newList)
        notifyDataSetChanged()
    }

    class TeslaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CardViewItemTeslaBinding.bind(itemView)
        fun bindTesla(tesla:Article){
            with(binding){
                teslaTitleTextView.text=tesla.title
                releaseDateTextView.text=tesla.author
                voteAverageTextView.text=tesla.publishedAt
                Picasso.get().load(tesla.urlToImage).resize(300,300).into(posterImageView)
            }
        }

    }

}