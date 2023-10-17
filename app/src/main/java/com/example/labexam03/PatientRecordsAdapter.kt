package com.example.labexam03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.labexam03.database.Appointment

class PatientRecordsAdapter(private val onDeleteClickListener: (Appointment) -> Unit) : RecyclerView.Adapter<PatientRecordsAdapter.PatientRecordViewHolder>() {
    private var appointments: List<Appointment> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientRecordViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_patient_record, parent, false)
        return PatientRecordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PatientRecordViewHolder, position: Int) {
        val appointment = appointments[position]
        holder.bind(appointment)
    }

    override fun getItemCount(): Int {
        return appointments.size
    }

    fun submitList(newAppointments: List<Appointment>) {
        appointments = newAppointments
        notifyDataSetChanged()
    }

    inner class PatientRecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val patientNameTextView: TextView = itemView.findViewById(R.id.textViewPatientName)
        private val appointmentDateTextView: TextView = itemView.findViewById(R.id.textViewAppointmentDate)
        private val ageTextView: TextView = itemView.findViewById(R.id.textViewAge)
        private val appointmentTextView: TextView = itemView.findViewById(R.id.textViewAppointment)
        private val timeTextView: TextView = itemView.findViewById(R.id.textViewTime)


        fun bind(appointment: Appointment) {
            patientNameTextView.text = "Patient Name: ${appointment.patientName}"
            appointmentDateTextView.text = "Appointment Date: ${appointment.appointmentDate}"
            ageTextView.text = "Age: ${appointment.patientAge}"
            appointmentTextView.text = "Appointment For: ${appointment.appointmentType}"
            timeTextView.text = "Time: ${appointment.timeSlot}"

            // Set up a click listener for the delete button
            val deleteButton = itemView.findViewById<Button>(R.id.buttonDelete)
            deleteButton.setOnClickListener {
                onDeleteClickListener(appointment)
            }
        }
    }
}


