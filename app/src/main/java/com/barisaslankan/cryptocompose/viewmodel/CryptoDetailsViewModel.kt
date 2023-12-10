package com.barisaslankan.cryptocompose.viewmodel

import androidx.lifecycle.ViewModel
import com.barisaslankan.cryptocompose.model.Crypto
import com.barisaslankan.cryptocompose.repository.CryptoRepository
import com.barisaslankan.cryptocompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailsViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {

    suspend fun getCrypto(id : String) : Resource<Crypto>{

        return repository.getCrypto(id)

    }

}