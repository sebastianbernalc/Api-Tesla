package com.cubidevs.mobiedbapp2022.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cubidevs.mobiedbapp2022.server.model.Article
import com.cubidevs.mobiedbapp2022.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private var teslaList: ArrayList<Article> = ArrayList()
    private lateinit var teslaAdapter: TeslaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = listBinding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teslaAdapter = TeslaAdapter(teslaList, onItemClicked = { onTeslaItemClicked(it) })

        listBinding.teslaRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = teslaAdapter
            setHasFixedSize(false)
        }

        listViewModel.teslaLoaded.observe(viewLifecycleOwner) { result ->
            onTeslaLoadedSubscribe(result)
        }
        listViewModel.getTesla()

    }

    private fun onTeslaItemClicked(tesla: Article) {
        findNavController().navigate(
            ListFragmentDirections.actionNavigationListToDetailFragment(
                tesla
            )
        )

    }

    private fun onTeslaLoadedSubscribe(teslaList: ArrayList<Article>?) {
        teslaList?.let { teslaList ->
            teslaAdapter.appendItems(teslaList)
        }

    }
}