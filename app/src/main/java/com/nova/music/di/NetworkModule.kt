package com.nova.music.di

import com.nova.music.data.remote.MusicApiService
import com.nova.music.data.remote.interceptor.UserAgentInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(userAgentInterceptor: UserAgentInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(userAgentInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideMusicApiService(okHttpClient: OkHttpClient): MusicApiService {
        return Retrofit.Builder()
            .baseUrl("https://music.youtube.com/youtubei/v1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MusicApiService::class.java)
    }
}
