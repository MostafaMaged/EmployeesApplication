package com.training.employees.view

import com.training.employees.model.EmployeeResponse

interface IEmployeesView {

    fun onResponse(r: EmployeeResponse?)
    fun onFailure(action: Throwable?)
}