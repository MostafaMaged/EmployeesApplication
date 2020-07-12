package com.training.employees.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.employees.EmployeeApplication
import com.training.employees.R
import com.training.employees.model.Employee
import com.training.employees.model.EmployeeAdapter
import com.training.employees.model.EmployeeResponse
import com.training.employees.presenter.EmployeesPresenter
import com.training.employees.view.IEmployeesView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

private const val TAG = "EmployeesActivity"
private const val BUNDLE_EMPLOYEE = "BUNDLE_EMPLOYEES"
const val EMPLOYEE_EXTRA = "EXTRA_EMPLOYEE"


class EmployeesActivity : AppCompatActivity(), IEmployeesView {

    private lateinit var employeesList: List<Employee>

    @Inject
    lateinit var employeePresenter: EmployeesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uiInit()

        val employeesComponent = (application as EmployeeApplication).getEmployeeComponent()
        employeesComponent!!.inject(this)

        if (savedInstanceState == null) {
            employeePresenter.getEmployees(this::onResponse, this::onFailure)
        } else {
            this.employeesList = savedInstanceState.getParcelableArrayList(BUNDLE_EMPLOYEE)!!
            displayEmployeeList()
        }
    }

    private fun uiInit() {
        retry_button.visibility = View.GONE
        no_connection_image.visibility = View.GONE
        retry_button.setOnClickListener {
            employeePresenter.getEmployees(this::onResponse, this::onFailure)
        }
    }

    override fun onResponse(r: EmployeeResponse?) {
        if (r!!.status == "success") {
            retry_button.visibility = View.GONE
            no_connection_image.visibility = View.GONE
            this.employeesList = r.employees
            displayEmployeeList()
        }
    }

    override fun onFailure(action: Throwable?) {
        retry_button.visibility = View.VISIBLE
        no_connection_image.setImageResource(R.drawable.ic_connection_error)
        no_connection_image.visibility = View.VISIBLE
    }

    private fun displayEmployeeList() {
        recycler_view_employees.apply {
            layoutManager = LinearLayoutManager(this@EmployeesActivity)
            adapter = EmployeeAdapter(employeesList) {
                val intent = Intent(
                    this@EmployeesActivity,
                    EmployeeDetailsActivity::class.java
                )
                intent.putExtra(EMPLOYEE_EXTRA, it)
                startActivity(intent)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(BUNDLE_EMPLOYEE, ArrayList(this.employeesList))
    }

    override fun onDestroy() {
        super.onDestroy()
        employeePresenter.onDestroy()
    }

}


