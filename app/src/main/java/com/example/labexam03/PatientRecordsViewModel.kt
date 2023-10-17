package com.example.labexam03

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.labexam03.database.Appointment
import com.example.labexam03.database.AppointmentDao
import com.example.labexam03.database.AppDatabase

class PatientRecordsViewModel(application: Application) : AndroidViewModel(application) {
    private val appointmentDao: AppointmentDao
    val allAppointments: LiveData<List<Appointment>>

    init {
        val database = AppDatabase.getDatabase(application)
        appointmentDao = database.appointmentDao()
        allAppointments = appointmentDao.getAllAppointments()
    }
}

