package com.training.employees.presenter

import com.training.employees.model.EmployeeResponse
import com.training.employees.network.ServiceBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EmployeesPresenter @Inject constructor() : IEmployeesPresenter {

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    override fun makeApiCall(
        onResponse: (EmployeeResponse) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        compositeDisposable.add(
            ServiceBuilder.buildService().getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ r -> onResponse(r) }, { t -> onFailure(t) })
        )
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }
}