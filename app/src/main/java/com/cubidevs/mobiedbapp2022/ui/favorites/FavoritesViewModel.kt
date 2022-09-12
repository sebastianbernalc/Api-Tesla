package com.cubidevs.mobiedbapp2022.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cubidevs.mobiedbapp2022.local.LocalTesla
import com.cubidevs.mobiedbapp2022.local.repository.LocalTeslaRespository
import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {
    var localTeslaRespository=LocalTeslaRespository()

    private val _teslaLoaded: MutableLiveData<ArrayList<LocalTesla>> = MutableLiveData()
    val teslaLoaded: LiveData<ArrayList<LocalTesla>> = _teslaLoaded
    fun loadTesla() {
        viewModelScope.launch {
           val listFavoritesTesla= localTeslaRespository.getTesla()
            _teslaLoaded.postValue(listFavoritesTesla as ArrayList<LocalTesla>)
        }
    }

    fun deleteTesla(localTesla: LocalTesla) {
        viewModelScope.launch {
            localTeslaRespository.deleteTesla(localTesla)
        }

    }


}