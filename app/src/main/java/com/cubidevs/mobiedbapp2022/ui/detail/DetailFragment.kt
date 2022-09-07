package com.cubidevs.mobiedbapp2022.ui.detail

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.fragment.navArgs
import com.cubidevs.mobiedbapp2022.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]


        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tesla=args.tesla

        with(detailBinding){
            teslaTitleTextView.text=tesla.title
            releaseDateTextView.text=tesla.author
            summaryTextView.text=tesla.content
            voteAverageTextView.text=tesla.publishedAt
            Picasso.get().load(tesla.urlToImage).into(posterImageView)
            summaryTextView2.text=tesla.description
            summaryTextView3.text=tesla.url

        }

    }
}