package com.training.employees.dagger

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class EmployeeModule {

    @Provides
    @Singleton
    fun getCompositeDisposable() : CompositeDisposable {
        return CompositeDisposable()
    }
}