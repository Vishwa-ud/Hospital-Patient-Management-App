package com.example.labexam03

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labexam03.database.AppDatabase
import com.example.labexam03.database.Appointment
import com.example.labexam03.database.AppointmentDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PatientRecordsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PatientRecordsFragment : Fragment() {

    private lateinit var patientRecordsViewModel: PatientRecordsViewModel
    private lateinit var patientRecordsAdapter: PatientRecordsAdapter
    private lateinit var appointmentDao: AppointmentDao

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_patient_records, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        // Initialize your Room database and AppointmentDao here
        val yourRoomDatabase = AppDatabase.getDatabase(requireContext()) // Replace with your actual database class
        appointmentDao = yourRoomDatabase.appointmentDao()

        val patientRecordsAdapter = PatientRecordsAdapter { appointment ->
            deleteAppointment(appointment)
        }


        recyclerView.adapter = patientRecordsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        patientRecordsViewModel = ViewModelProvider(this).get(PatientRecordsViewModel::class.java)

        patientRecordsViewModel.allAppointments.observe(viewLifecycleOwner, { appointments ->
            appointments.forEach { appointment ->
                Log.d("RecordFragment", "Retrieved Appointment: $appointment")
            }
            patientRecordsAdapter.submitList(appointments)
        })

        return view
    }
    private fun deleteAppointment(appointment: Appointment) {
        GlobalScope.launch {
            appointmentDao.deleteAppointment(appointment)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PatientRecordsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PatientRecordsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}