package com.training.employees.dagger

import com.training.employees.ui.EmployeesActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [EmployeeModule::class])
interface EmployeesComponent {
    fun inject(activity: EmployeesActivity)
}