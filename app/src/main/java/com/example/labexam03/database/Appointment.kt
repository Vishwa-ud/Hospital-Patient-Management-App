package com.example.labexam03.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Appointment(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val patientName: String,
    val patientPhone: String,
    val patientAge: Int,
    val dateOfBirth: String,
    val appointmentDate: String,
    val gender: String,
    val timeSlot: String,
    val appointmentType: String
)
