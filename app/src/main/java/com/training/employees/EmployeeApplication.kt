package com.training.employees

import android.app.Application
import com.training.employees.dagger.DaggerEmployeesComponent
import com.training.employees.dagger.EmployeesComponent

class EmployeeApplication : Application() {

    private var mEmployeeComponent: EmployeesComponent? = null

    override fun onCreate() {
        super.onCreate()
        mEmployeeComponent = DaggerEmployeesComponent.create()
    }

    fun getEmployeeComponent(): EmployeesComponent? {
        return mEmployeeComponent
    }
}