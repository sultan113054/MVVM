package com.assignment.imdbmovie.presentation.di.core

import android.content.Context
import com.assignment.imdbmovie.presentation.di.TopMoviesSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module (subcomponents = [TopMoviesSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}