package com.example.projekakhir

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.projekakhir.databinding.FragmentBiodataPendaftaranBinding
import java.lang.Exception
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
        binding.uploadButton1.setOnClickListener {
            showFileIjazah()}
        binding.uploadButton2.setOnClickListener {
            showFileAktekelahiran()
        }
        binding.uploadButton3.setOnClickListener {
            showFilefckk()
        }
        binding.uploadButton4.setOnClickListener {
            showFileFcKtp()
        }
        binding.uploadButton5.setOnClickListener {
            showFileFcKtm()
        }
        binding.uploadButton6.setOnClickListener {
            showFilePasFoto()
        }
        binding.uploadButton7.setOnClickListener {
            showFileSkl()
        }
        binding.uploadButton8.setOnClickListener {
            showFileSt()
        }

        binding.deleteButton1.setOnClickListener {
            binding.uploadButton1.visibility = View.VISIBLE
            binding.deleteButton1.visibility = View.GONE
            binding.ivCloseFcIjazah.visibility = View.VISIBLE
            binding.ivCheckFcIjazah.visibility = View.GONE
        }
        binding.deleteButton2.setOnClickListener {
            binding.uploadButton2.visibility = View.VISIBLE
            binding.deleteButton2.visibility = View.GONE
            binding.ivCloseFcAkte.visibility = View.VISIBLE
            binding.ivCheckFcAkte.visibility = View.GONE
        }
        binding.deleteButton3.setOnClickListener {
            binding.uploadButton3.visibility = View.VISIBLE
            binding.deleteButton3.visibility = View.GONE
            binding.ivCloseFcKK.visibility = View.VISIBLE
            binding.ivCheckFcKK.visibility = View.GONE
        }
        binding.deleteButton4.setOnClickListener {
            binding.uploadButton4.visibility = View.VISIBLE
            binding.deleteButton4.visibility = View.GONE
            binding.ivCloseFcKTP.visibility = View.VISIBLE
            binding.ivCheckFcKTP.visibility = View.GONE
        }
        binding.deleteButton5.setOnClickListener {
            binding.uploadButton5.visibility = View.VISIBLE
            binding.deleteButton5.visibility = View.GONE
            binding.ivCloseFcKTM.visibility = View.VISIBLE
            binding.ivCheckFcKTM.visibility = View.GONE
        }
        binding.deleteButton6.setOnClickListener {
            binding.uploadButton6.visibility = View.VISIBLE
            binding.deleteButton6.visibility = View.GONE
            binding.ivCloseFcPasFoto.visibility = View.VISIBLE
            binding.ivCheckFcPasFoto.visibility = View.GONE
        }
        binding.deleteButton7.setOnClickListener {
            binding.uploadButton7.visibility = View.VISIBLE
            binding.deleteButton7.visibility = View.GONE
            binding.ivCloseFcSKL.visibility = View.VISIBLE
            binding.ivCheckFcSKL.visibility = View.GONE
        }
        binding.deleteButton8.setOnClickListener {
            binding.uploadButton8.visibility = View.VISIBLE
            binding.deleteButton8.visibility = View.GONE
            binding.ivCloseFcTOEIC.visibility = View.VISIBLE
            binding.ivCheckFcTOEIC.visibility = View.GONE
        }
    }

    private fun showFileSt() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try {
            launcherIntentSt.launch(intent)
//            startActivityForResult(Intent.createChooser(intent,"Select a File"),
//                100)
        }catch (exception:Exception){
            Toast.makeText(requireActivity(),"Please install a file manager.",Toast.LENGTH_SHORT).show()
        }
    }

    private val launcherIntentSt = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK){
            binding.uploadButton8.visibility = View.GONE
            binding.deleteButton8.visibility = View.VISIBLE
            binding.ivCloseFcTOEIC.visibility = View.GONE
            binding.ivCheckFcTOEIC.visibility = View.VISIBLE
        }
    }

    private fun showFileSkl() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try {
            launcherIntentSkl.launch(intent)
//            startActivityForResult(Intent.createChooser(intent,"Select a File"),
//                100)
        }catch (exception:Exception){
            Toast.makeText(requireActivity(),"Please install a file manager.",Toast.LENGTH_SHORT).show()
        }
    }

    private val launcherIntentSkl = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK){
            binding.uploadButton7.visibility = View.GONE
            binding.deleteButton7.visibility = View.VISIBLE
            binding.ivCloseFcSKL.visibility = View.GONE
            binding.ivCheckFcSKL.visibility = View.VISIBLE
        }
    }

    private fun showFilePasFoto() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try {
            launcherIntentPasFoto.launch(intent)
//            startActivityForResult(Intent.createChooser(intent,"Select a File"),
//                100)
        }catch (exception:Exception){
            Toast.makeText(requireActivity(),"Please install a file manager.",Toast.LENGTH_SHORT).show()
        }
    }

    private val launcherIntentPasFoto = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK){
            binding.uploadButton6.visibility = View.GONE
            binding.deleteButton6.visibility = View.VISIBLE
            binding.ivCloseFcPasFoto.visibility = View.GONE
            binding.ivCheckFcPasFoto.visibility = View.VISIBLE
        }
    }

    private fun showFileFcKtm() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try {
            launcherIntentFcKtm.launch(intent)
//            startActivityForResult(Intent.createChooser(intent,"Select a File"),
//                100)
        }catch (exception:Exception){
            Toast.makeText(requireActivity(),"Please install a file manager.",Toast.LENGTH_SHORT).show()
        }
    }

    private val launcherIntentFcKtm = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK){
            binding.uploadButton5.visibility = View.GONE
            binding.deleteButton5.visibility = View.VISIBLE
            binding.ivCloseFcKTM.visibility = View.GONE
            binding.ivCheckFcKTM.visibility = View.VISIBLE
        }
    }

    private fun showFileFcKtp() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try {
            launcherIntentFcKtp.launch(intent)
//            startActivityForResult(Intent.createChooser(intent,"Select a File"),
//                100)
        }catch (exception:Exception){
            Toast.makeText(requireActivity(),"Please install a file manager.",Toast.LENGTH_SHORT).show()
        }
    }

    private val launcherIntentFcKtp = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK){
            binding.uploadButton4.visibility = View.GONE
            binding.deleteButton4.visibility = View.VISIBLE
            binding.ivCloseFcKTP.visibility = View.GONE
            binding.ivCheckFcKTP.visibility = View.VISIBLE

        }
    }

    private fun showFilefckk() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try {
            launcherIntentfckk.launch(intent)
//            startActivityForResult(Intent.createChooser(intent,"Select a File"),
//                100)
        }catch (exception:Exception){
            Toast.makeText(requireActivity(),"Please install a file manager.",Toast.LENGTH_SHORT).show()
        }
    }

    private val launcherIntentfckk = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK){
            binding.uploadButton3.visibility = View.GONE
            binding.deleteButton3.visibility = View.VISIBLE
            binding.ivCloseFcKK.visibility = View.GONE
            binding.ivCheckFcKK.visibility = View.VISIBLE
        }
    }

    private fun showFileAktekelahiran() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try {
            launcherIntentAkte.launch(intent)
//            startActivityForResult(Intent.createChooser(intent,"Select a File"),
//                100)
        }catch (exception:Exception){
            Toast.makeText(requireActivity(),"Please install a file manager.",Toast.LENGTH_SHORT).show()
        }
    }

    private val launcherIntentAkte = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK){
            binding.uploadButton2.visibility = View.GONE
            binding.deleteButton2.visibility = View.VISIBLE
            binding.ivCloseFcAkte.visibility = View.GONE
            binding.ivCheckFcAkte.visibility = View.VISIBLE
        }
    }

    private fun showFileIjazah() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try {
            launcherIntent.launch(intent)
//            startActivityForResult(Intent.createChooser(intent,"Select a File"),
//                100)
        }catch (exception:Exception){
            Toast.makeText(requireActivity(),"Please install a file manager.",Toast.LENGTH_SHORT).show()
        }
    }

    private val launcherIntent = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK){
            binding.uploadButton1.visibility = View.GONE
            binding.deleteButton1.visibility = View.VISIBLE
            binding.ivCloseFcIjazah.visibility = View.GONE
            binding.ivCheckFcIjazah.visibility = View.VISIBLE
        //          binding.fileArtikel.text = it.data?.data.toString()
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