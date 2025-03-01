package com.cabovianco.thenbhd.ui.screen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cabovianco.thenbhd.data.repository.AlbumRepository
import com.cabovianco.thenbhd.data.repository.model.Album
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val albumRepository: AlbumRepository
) : ViewModel() {

    private val _albums = MutableStateFlow<List<Album>>(emptyList())
    val albums get() = _albums.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _albums.value = albumRepository.getAllAlbums()
        }
    }

}
