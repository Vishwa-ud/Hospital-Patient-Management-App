package com.example.labexam03

import RegistrationFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val registrationFragment = RegistrationFragment()
    private val appointmentFragment = AppointmentFragment()
    private val patientRecordsFragment = PatientRecordsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homebtn: Button = findViewById(R.id.homebtn)
        val appointmentbtn: Button = findViewById(R.id.appointmentbtn)
        val recordsbtn: Button = findViewById(R.id.recordsbtn)
        loadRegistration()
        homebtn.setOnClickListener {
            loadRegistration()

        }

        appointmentbtn.setOnClickListener {
            loadAppointments()
        }

        recordsbtn.setOnClickListener {
            loadRecords()
        }
    }
    //only can be use with in the class
    private fun loadRegistration(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,
                registrationFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,
                registrationFragment).commit()
        }
    }
    private fun loadAppointments(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,
                appointmentFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,
                appointmentFragment).commit()
        }

    }
    private fun loadRecords(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,
                patientRecordsFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,
                patientRecordsFragment).commit()
        }

    }
}