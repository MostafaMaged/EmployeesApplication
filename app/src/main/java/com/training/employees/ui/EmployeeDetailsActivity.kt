package com.training.employees.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.training.employees.R
import com.training.employees.model.Employee
import kotlinx.android.synthetic.main.activity_employee_details.*
import kotlinx.android.synthetic.main.employee_item.employee_name

private const val TAG = "EmployeeDetailsActivity"

class EmployeeDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)

        val employee = intent.getParcelableExtra<Employee>(EMPLOYEE_EXTRA)
        if (employee != null) {
            employee_name.text = employee.employeeName
            employee_salary.text = employee.employeeSalary.toString()
            employee_age.text = employee.employeeAge.toString()
        }

    }
}
