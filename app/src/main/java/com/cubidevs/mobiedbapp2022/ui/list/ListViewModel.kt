package com.cubidevs.mobiedbapp2022.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cubidevs.mobiedbapp2022.server.Teslarepository.TeslaRepository
import com.cubidevs.mobiedbapp2022.server.model.Article
import com.cubidevs.mobiedbapp2022.server.model.TeslaList
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    private val teslaRepository = TeslaRepository()
    private val _teslaLoaded: MutableLiveData<ArrayList<Article>> = MutableLiveData()
    val teslaLoaded: LiveData<ArrayList<Article>> = _teslaLoaded

    fun getTesla() {
        viewModelScope.launch {
            val teslaList: TeslaList= teslaRepository.getTesla()
            _teslaLoaded.postValue(teslaList.articles as ArrayList<Article>)
        }
    }

}