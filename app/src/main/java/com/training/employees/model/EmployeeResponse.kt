package com.training.employees.model

import com.google.gson.annotations.SerializedName

data class EmployeeResponse(

    @SerializedName("status")
    val status: String,

    //TODO what if response is error message ?
    @SerializedName("data")
    val employees: List<Employee>
)