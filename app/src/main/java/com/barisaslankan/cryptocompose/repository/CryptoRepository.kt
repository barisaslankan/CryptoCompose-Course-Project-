package com.barisaslankan.cryptocompose.repository

import com.barisaslankan.cryptocompose.model.Crypto
import com.barisaslankan.cryptocompose.model.CryptoList
import com.barisaslankan.cryptocompose.service.CryptoAPI
import com.barisaslankan.cryptocompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(
    private val cryptoAPI: CryptoAPI
){

    suspend fun getCryptoList() : Resource<CryptoList> {
        val response = try {
            cryptoAPI.getCryptoList()
        } catch(e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id : String) : Resource<Crypto>{
        val response = try{
            cryptoAPI.getCrypto()
        }catch (e:Exception){
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

}