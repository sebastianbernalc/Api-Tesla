package com.cubidevs.mobiedbapp2022.ui.detail


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cubidevs.mobiedbapp2022.local.LocalTesla
import com.cubidevs.mobiedbapp2022.local.repository.LocalTeslaRespository
import com.cubidevs.mobiedbapp2022.server.model.Article
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    val localTeslaRepository = LocalTeslaRespository()
    private val _teslaExist: MutableLiveData<Boolean> = MutableLiveData()
    val teslaExist: LiveData<Boolean> = _teslaExist

    fun addTeslaToFavorites(tesla: Article) {
        val localTesla = tesla.url?.let {
            LocalTesla(
                id = it,
                title = tesla.title,
                author = tesla.author,
                urlToImage = tesla.urlToImage,
                publishedAt = tesla.publishedAt,
                url = tesla.url,
                content = tesla.content,
                description = tesla.description
            )
        }
        viewModelScope.launch {
            localTesla?.let { localTeslaRepository.saveTesla(it) }
        }
    }

    fun searchTesla(url: String?) {
        var teslaExistAux = false
        viewModelScope.launch {
            val localTesla = localTeslaRepository.searchTesla(url)
            if (localTesla != null) {
                teslaExistAux = true
            }
            _teslaExist.postValue(teslaExistAux)
        }
    }
}
