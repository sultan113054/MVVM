package com.assignment.imdbmovie.presentation.di.core

import com.assignment.imdbmovie.presentation.di.TopMoviesSubComponent
import com.assignment.imdbmovie.presentation.di.database.DatabaseModule
import com.assignment.imdbmovie.presentation.di.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, NetworkModule::class, DatabaseModule::class,
        UsecaseModule::class, RepositoryModule::class, RemoteDataModule::class,
        LocalDataModule::class, CacheDataModule::class]
)
interface AppComponent {
    fun topMovieSubComponent(): TopMoviesSubComponent.factory
}