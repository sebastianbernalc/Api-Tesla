package com.cubidevs.mobiedbapp2022.ui.detail

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.fragment.navArgs
import com.cubidevs.mobiedbapp2022.R
import com.cubidevs.mobiedbapp2022.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    private var teslaExistAux=false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]


        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tesla=args.tesla

        detailViewModel.searchTesla(tesla.url)
        detailViewModel.teslaExist.observe(viewLifecycleOwner) { teslaExist ->
            if (teslaExist){
                detailBinding.favoritesImageView.setImageDrawable(resources.getDrawable(R.drawable.ic_favorites_exist))
                teslaExistAux=true
            }
            else{
                detailBinding.favoritesImageView.setImageDrawable(resources.getDrawable(R.drawable.ic_favorites))
                teslaExistAux=false
            }
        }

        with(detailBinding){
            teslaTitleTextView.text=tesla.title
            releaseDateTextView.text=tesla.author
            summaryTextView.text=tesla.content
            voteAverageTextView.text=tesla.publishedAt
            Picasso.get().load(tesla.urlToImage).into(posterImageView)
            summaryTextView2.text=tesla.description
            summaryTextView3.text=tesla.url
            favoritesImageView.setOnClickListener{
                if(teslaExistAux)
                    Toast.makeText(context, "${tesla.title} Ya esta en favoritos",Toast.LENGTH_LONG).show()
                else{
                    detailBinding.favoritesImageView.setImageDrawable(resources.getDrawable(R.drawable.ic_favorites_exist))
                    teslaExistAux=true
                    detailViewModel.addTeslaToFavorites(tesla)
                }
            }
        }
    }
}