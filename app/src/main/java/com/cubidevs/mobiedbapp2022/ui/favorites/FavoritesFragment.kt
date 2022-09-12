package com.cubidevs.mobiedbapp2022.ui.favorites


import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cubidevs.mobiedbapp2022.R
import com.cubidevs.mobiedbapp2022.databinding.FragmentFavoritesBinding
import com.cubidevs.mobiedbapp2022.local.LocalTesla


class FavoritesFragment : Fragment() {

    private lateinit var favoritesBinding: FragmentFavoritesBinding
    private lateinit var favoritesViewModel: FavoritesViewModel
    private lateinit var teslaFavoritesAdapter: TeslaFavoritesAdapter
    private var teslaList: ArrayList<LocalTesla> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        favoritesViewModel = ViewModelProvider(this)[FavoritesViewModel::class.java]
        favoritesBinding = FragmentFavoritesBinding.inflate(inflater, container, false)
        favoritesViewModel.loadTesla()
        teslaFavoritesAdapter= TeslaFavoritesAdapter(teslaList,
            onItemClicked = {onItemClicked(it)},
        onItemLongClicked = {onItemLongClicked(it)})
        favoritesBinding.teslaRecyclerView.apply {
            layoutManager=LinearLayoutManager(this@FavoritesFragment.context)
            adapter=teslaFavoritesAdapter
            setHasFixedSize(false)
        }

        favoritesViewModel.teslaLoaded.observe(viewLifecycleOwner,{teslaFavoritesAdapter.appendItems(it)})

        val root: View = favoritesBinding.root
        return root
    }

    private fun onItemLongClicked(localTesla: LocalTesla) {
        val alertDialog:AlertDialog?= activity?.let {
            val builder= AlertDialog.Builder(it)
            builder.apply {
                setMessage("¿Desea eliminar ${localTesla.title} de sus favoritos?")
                setPositiveButton(R.string.accept){dialog, id ->
                    favoritesViewModel.deleteTesla(localTesla)
                    favoritesViewModel.loadTesla()
                }
                setNegativeButton(R.string.cancel){dialog, id ->

                }
            }
            builder.create()
        }
        alertDialog?.show()
    }

    private fun onItemClicked(localTesla: LocalTesla) {

    }
}