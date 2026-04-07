package com.nova.music.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class UserAgentInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("User-Agent",               USER_AGENTS.random())
            .header("Accept",                   "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
            .header("Accept-Language",          "en-US,en;q=0.9")
            .header("Accept-Encoding",          "gzip, deflate, br")
            .header("Connection",               "keep-alive")
            .header("Upgrade-Insecure-Requests","1")
            .header("Sec-Fetch-Dest",           "document")
            .header("Sec-Fetch-Mode",           "navigate")
            .header("Sec-Fetch-Site",           "none")
            .build()
        return chain.proceed(request)
    }

    companion object {
        private val USER_AGENTS = listOf(
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36",
            "Mozilla/5.0 (Linux; Android 14; Pixel 8 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.6422.53 Mobile Safari/537.36",
            "com.google.android.apps.youtube.music/6.42.52 (Linux; U; Android 14; Pixel 8 Pro) gzip"
        )
    }
}

