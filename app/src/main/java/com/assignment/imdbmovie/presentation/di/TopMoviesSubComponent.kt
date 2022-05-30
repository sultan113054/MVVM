package com.assignment.imdbmovie.presentation.di

import com.assignment.imdbmovie.presentation.HomeFragment
import dagger.Subcomponent

@TopMoviesScope
@Subcomponent(modules = [TopMoviesModule::class])
interface TopMoviesSubComponent {

    fun inject(fragment: HomeFragment)

    @Subcomponent.Factory
    interface factory {
        fun create(): TopMoviesSubComponent
    }
}