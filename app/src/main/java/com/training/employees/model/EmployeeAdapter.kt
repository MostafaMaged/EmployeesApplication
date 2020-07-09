package com.training.employees.model

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.training.employees.R

class EmployeeAdapter(
    private val employeesList: List<Employee>,
    val clickListener: (Employee) -> Unit
) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EmployeeHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: EmployeeHolder, position: Int) {
        val employee: Employee = employeesList[position]
        holder.itemView.setOnClickListener { clickListener(employee) }
        holder.bind(employee)
    }

    override fun getItemCount(): Int = employeesList.size

    class EmployeeHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.employee_item, parent, false)) {

        private var mEmployeeNameView: TextView? = null
        private var mEmployeeIdView: TextView? = null

        init {
            mEmployeeNameView = itemView.findViewById(R.id.employee_name)
            mEmployeeIdView = itemView.findViewById(R.id.employee_id)
        }

        fun bind(employee: Employee) {
            mEmployeeNameView?.text = employee.employeeName
            mEmployeeIdView?.text = employee.id.toString()
        }
    }
}

