package com.barisaslankan.cryptocompose.service

import com.barisaslankan.cryptocompose.model.Crypto
import com.barisaslankan.cryptocompose.model.CryptoList
import retrofit2.http.GET


interface CryptoAPI {

    @GET("cryptolist.json")
    suspend fun getCryptoList() : CryptoList

    @GET("crypto.json")
    suspend fun getCrypto() : Crypto

}