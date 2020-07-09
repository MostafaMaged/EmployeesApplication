package com.training.employees.network

import com.training.employees.model.EmployeeResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface EmployeesEndpoint {

    @GET("/api/v1/employees")
    fun getEmployees(): Observable<EmployeeResponse>
}