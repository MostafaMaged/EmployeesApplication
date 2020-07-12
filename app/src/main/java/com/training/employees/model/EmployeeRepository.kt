package com.training.employees.model

import com.training.employees.network.EmployeesEndpoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class EmployeeRepository @Inject constructor() {

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    fun getEmployees(
        onResponse: (EmployeeResponse) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        compositeDisposable.add(
            retrofit.create(EmployeesEndpoint::class.java).getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ r -> onResponse(r) }, { t -> onFailure(t) })
        )
    }

    fun getDisposablesReference(): CompositeDisposable {
        return compositeDisposable
    }
}