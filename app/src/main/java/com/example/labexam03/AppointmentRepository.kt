package com.example.labexam03

import androidx.lifecycle.LiveData
import com.example.labexam03.database.Appointment
import com.example.labexam03.database.AppointmentDao

class AppointmentRepository(private val appointmentDao: AppointmentDao) {
    val allAppointments: LiveData<List<Appointment>> = appointmentDao.getAllAppointments()

    suspend fun insert(appointment: Appointment) {
        appointmentDao.insertAppointment(appointment)
    }
}