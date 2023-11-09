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
import com.example.projekakhir.databinding.FragmentBiodataPendaftaranBinding
import java.util.Calendar

class BiodataPendaftaranFragment : Fragment() {

    private lateinit var binding: FragmentBiodataPendaftaranBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBiodataPendaftaranBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logoutps.setOnClickListener {
            findNavController().navigate(R.id.action_biodataPendaftaranFragment_to_loginFragment)
        }
        binding.menups.setOnClickListener {
            findNavController().navigate(R.id.action_biodataPendaftaranFragment_to_menuDashboardFragment)
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
        binding.inputtgllulus.setOnClickListener {

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
        binding.inputtglwisuda.setOnClickListener {

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

        binding.autocJenisKelamin.setOnClickListener {
            pickGender()
        }
        binding.inputprodi.setOnClickListener {
            pickProdi()
        }
        binding.inputpembimbingagama.setOnClickListener {
            pickPembimbingAgama()
        }
    }

    private fun pickPembimbingIlmu(){
        val items = listOf("Elan Suherlan, M.Si", "Chandra Prasetyo Utomo,S.Kom.,M,Sc", "Andreas Febrian,S.Kom,M.Kom,PhD", "Heri Yugaswara.,MT","Herika Hayurani,S.Kom.,M.Kom", "Irwandi M.Zen, Lc., M.A")
        val autoComplete = binding.inputpembimbingilmu
        val adapter = ArrayAdapter(requireActivity(),R.layout.list_drop_down,items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(requireActivity(),"Pembimbing Ilmu: $itemSelected",Toast.LENGTH_SHORT).show()
        }
    }

    private fun pickPembimbingAgama(){
        val items = listOf("Elan Suherlan, M.Si", "Chandra Prasetyo Utomo,S.Kom.,M,Sc", "Andreas Febrian,S.Kom,M.Kom,PhD", "Heri Yugaswara.,MT","Herika Hayurani,S.Kom.,M.Kom", "Irwandi M.Zen, Lc., M.A")
        val autoComplete = binding.inputpembimbingagama
        val adapter = ArrayAdapter(requireActivity(),R.layout.list_drop_down,items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(requireActivity(),"Pembimbing Agama: $itemSelected",Toast.LENGTH_SHORT).show()
        }
    }

    private fun pickProdi() {
        val items = arrayOf("Teknik Informatika", "Perpustakaan dan Sains Informasi (PdSI)")
        val autoComplete = binding.inputprodi
        val adapter = ArrayAdapter(requireActivity(),R.layout.list_drop_down,items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(requireActivity(),"Pilih Prodi: $itemSelected",Toast.LENGTH_SHORT).show()
        }
    }

    private fun pickGender() {
        val items = arrayOf("Laki - Laki", "Perempuan")
        val autoComplete = binding.autocJenisKelamin
        val adapter = ArrayAdapter(requireActivity(),R.layout.list_drop_down,items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(requireActivity(),"Jenis Kelamin: $itemSelected",Toast.LENGTH_SHORT).show()
        }
    }

}