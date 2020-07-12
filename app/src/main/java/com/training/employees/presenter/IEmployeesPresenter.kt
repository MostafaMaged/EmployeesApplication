package com.training.employees.presenter

import com.training.employees.model.EmployeeResponse

interface IEmployeesPresenter {
    fun onDestroy()
    fun getEmployees(onResponse: (EmployeeResponse) -> Unit, onFailure: (Throwable) -> Unit)
}