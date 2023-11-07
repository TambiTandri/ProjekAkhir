package com.example.projekakhir

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.projekakhir.databinding.FragmentPengambilanIjazahBinding
import java.util.Calendar


class PengambilanIjazahFragment : Fragment() {

    lateinit var binding: FragmentPengambilanIjazahBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPengambilanIjazahBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logoutpi.setOnClickListener {
            findNavController().navigate(R.id.action_pengambilanIjazahFragment_to_loginFragment)
        }
        binding.menupi.setOnClickListener {
            findNavController().navigate(R.id.action_pengambilanIjazahFragment_to_menuDashboardFragment)
        }
        binding.btnClose.setOnClickListener{
            binding.consLay.visibility = View.GONE
        }
        binding.inputTanggallahir.setOnClickListener {

            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    binding.inputTanggallahir.setText(dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
        binding.inputtanggallulus.setOnClickListener {

            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    binding.inputtanggallulus.setText(dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
        binding.inputjeniskelamin.setOnClickListener {
            pickGender()
        }

        binding.inputprodi.setOnClickListener {
            pickProdi()
        }

    }

    private fun pickProdi() {
        val items = arrayOf("Teknik Informatika", "Perpustakaan dan Sains Infomasi (PdSI)")
        val autoComplete = binding.inputprodi
        val adapter = ArrayAdapter(requireActivity(),R.layout.list_drop_down,items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(requireActivity(),"Program Studi : $itemSelected", Toast.LENGTH_SHORT).show()
        }
    }

    private fun pickGender() {
        val items = arrayOf("Laki-Laki","Perempuan")
        val autoComplete = binding.inputjeniskelamin
        val adapter = ArrayAdapter(requireActivity(),R.layout.list_drop_down,items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(requireActivity(),"Jenis Kelamin: $itemSelected", Toast.LENGTH_SHORT).show()
        }
    }
}