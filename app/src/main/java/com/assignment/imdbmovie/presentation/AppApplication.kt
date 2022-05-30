package com.assignment.imdbmovie.presentation

import android.app.Application
import com.assignment.imdbmovie.BuildConfig
import com.assignment.imdbmovie.presentation.di.TopMoviesSubComponent
import com.assignment.imdbmovie.presentation.di.core.AppComponent
import com.assignment.imdbmovie.presentation.di.core.AppModule
import com.assignment.imdbmovie.presentation.di.core.DaggerAppComponent
import com.assignment.imdbmovie.presentation.di.core.RemoteDataModule
import com.assignment.imdbmovie.presentation.di.injector
import com.assignment.imdbmovie.presentation.di.network.NetworkModule

class AppApplication : Application(), injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent =
            DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .networkModule(NetworkModule(BuildConfig.BASE_URL))
                .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
                .build()


    }

    override fun createTopMovieSubComponent(): TopMoviesSubComponent {
        return appComponent.topMovieSubComponent().create()
    }
}