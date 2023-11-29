package com.example.projekakhir

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.OpenableColumns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.projekakhir.databinding.FragmentSklBinding
import java.lang.Exception


class SklFragment : Fragment() {
    lateinit var binding : FragmentSklBinding
    private val PICK_FILE_REQUEST_CODE = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSklBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnClose.setOnClickListener {
            binding.consLay.visibility = View.GONE
        }
        binding.menuskl.setOnClickListener{
            findNavController().navigate(R.id.action_sklFragment_to_menuDashboardFragment2)
        }
        binding.logoutskl.setOnClickListener{
            findNavController().navigate(R.id.action_sklFragment_to_loginFragment)
        }
        binding.buttonartikel.setOnClickListener {
           //pickFileArtikel()
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*" // Semua jenis file
            startActivityForResult(intent, PICK_FILE_REQUEST_CODE)
        }

        binding.btnlp.setOnClickListener {
            pickFilelp()
        }
        binding.btnsk.setOnClickListener {
            pickFilesk()
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                val fileName = getFileName(uri)
                binding.fileArtikel.text = "$fileName"
            }
        } else {
            Toast.makeText(requireContext(), "Pemilihan file dibatalkan", Toast.LENGTH_SHORT).show()
        }
    }
    private fun getFileName(uri: android.net.Uri): String {
        var result: String? = null
        if (uri.scheme == "content") {
//            val cursor = requireContext().contentResolver.query(uri, null, null, null, null)
//            cursor?.use {
//                if (it.moveToFirst()) {
//                    result = it.getString(it.getColumnIndex(OpenableColumns.DISPLAY_NAME))
//                }
//            }
            val cursor = requireContext().contentResolver.query(uri, null, null, null, null)

            cursor?.use {
                if (it.moveToFirst()) {
                    val displayNameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                    result = if (displayNameIndex != -1) {
                        it.getString(displayNameIndex)
                    } else {
                        "unknown"
                    }
                }
            } ?: return "unknown"

        }
        if (result == null) {
            result = uri.path
            val cut = result?.lastIndexOf('/')
            if (cut != null && cut != -1) {
                result = result?.substring(cut + 1)
            }
        }
        return result ?: "unknown"
    }

    private fun pickFileArtikel(uri: android.net.Uri) {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try {
            launcherIntentArtikel.launch(intent)

        }catch (exception:Exception){
            Toast.makeText(requireActivity(),"Please install a file manager.",Toast.LENGTH_SHORT).show()
        }

        val fileName = getFileName(uri)
        binding.fileArtikel.text = "$fileName"

    }

    private val launcherIntentArtikel = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if (it.resultCode== Activity.RESULT_OK){
            binding.fileArtikel.text = it.data?.data.toString()

        }
    }

    private fun pickFilelp() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try {
            launcherIntentlp.launch(intent)

        }catch (exception:Exception){
            Toast.makeText(requireActivity(),"Please install a file manager.",Toast.LENGTH_SHORT).show()
        }
    }

    private val launcherIntentlp = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if (it.resultCode== Activity.RESULT_OK){
            binding.filelp.text = it.data?.data.toString()
        }
    }

    private fun pickFilesk() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try {
            launcherIntentsk.launch(intent)

        }catch (exception:Exception){
            Toast.makeText(requireActivity(),"Please install a file manager.",Toast.LENGTH_SHORT).show()
        }
    }

    private val launcherIntentsk = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if (it.resultCode== Activity.RESULT_OK){
            binding.filesk.text = it.data?.data.toString()

        }
    }

}