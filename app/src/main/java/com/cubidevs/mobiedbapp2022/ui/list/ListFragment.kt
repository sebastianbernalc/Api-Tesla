package com.cubidevs.mobiedbapp2022.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cubidevs.mobiedbapp2022.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = listBinding.root

        return root
    }
}