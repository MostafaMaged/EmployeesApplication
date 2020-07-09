package com.training.employees.presenter

import com.training.employees.model.EmployeeResponse

interface IEmployeesPresenter {
    fun makeApiCall(onResponse: (EmployeeResponse) -> Unit, onFailure: (Throwable) -> Unit)
    fun onDestroy()
}