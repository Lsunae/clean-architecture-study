package com.example.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkInterceptor @Inject constructor(private val networkConfig: NetworkConfig) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-Naver-Client-Id", NetworkConfig.clientId)
            .addHeader("X-Naver-Client-Secret", NetworkConfig.clientSecret)
            .build()
        return chain.proceed(request)
    }
}