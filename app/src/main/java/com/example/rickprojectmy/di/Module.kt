package com.eykel.rickywithdi

import android.app.Application
import android.content.SharedPreferences
import com.example.rickprojectmy.data.ClickListener
import com.example.rickprojectmy.data.repository.RickyRepository
import com.example.rickprojectmy.data.repository.RickyService
import com.example.rickprojectmy.ui.adapter.ListAdapterRick
import com.example.rickprojectmy.ui.viewmodel.DetailsViewModel
import com.example.rickprojectmy.ui.viewmodel.RickyViewModel
import com.example.rickprojectmy.util.SecurityPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val netModule = module {

    fun provideRetrofit(client: OkHttpClient, gson : Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    fun provideHttpClient(cache: Cache): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .cache(cache)

        return okHttpClientBuilder.build()
    }

    fun provideCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    fun provideGson(): Gson = GsonBuilder().create()

    single { provideCache(androidApplication()) }
    single { provideHttpClient(get()) }
    single { provideGson() }
    single { provideRetrofit(get(), get()) }
}

val apiModule = module {

    fun provideCharacterApi(retrofit: Retrofit): RickyService {
        return retrofit.create(RickyService::class.java)
    }

    single { provideCharacterApi(get()) }
}

val viewModelModule = module {
    viewModel { RickyViewModel(get())}
    viewModel{ DetailsViewModel(get())}

}

val repositoryModule = module {
    fun provideUserRepository(api: RickyService): RickyRepository {
        return RickyRepository(api)
    }

    single { provideUserRepository(get()) }
    single { ListAdapterRick(androidContext()) }
    single { SecurityPreferences(androidContext()) }


}

