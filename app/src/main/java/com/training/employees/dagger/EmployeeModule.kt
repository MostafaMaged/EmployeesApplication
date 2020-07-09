package com.training.employees.dagger

import com.training.employees.network.ServiceBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class EmployeeModule {

    @Provides
    @Singleton
    fun getCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        return ServiceBuilder.buildRetrofit()
    }
}