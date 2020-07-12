package com.training.employees.presenter

import com.training.employees.model.EmployeeRepository
import com.training.employees.model.EmployeeResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EmployeesPresenter @Inject constructor() : IEmployeesPresenter {

    @Inject
    lateinit var employeeRepository: EmployeeRepository

    override fun getEmployees(
        onResponse: (EmployeeResponse) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        return employeeRepository.getEmployees(onResponse, onFailure)
    }

    override fun onDestroy() {
        employeeRepository.getDisposablesReference().clear()
    }
}