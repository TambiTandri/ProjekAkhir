package com.example.projekakhir

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.projekakhir.databinding.FragmentSklBinding
import java.lang.Exception


class SklFragment : Fragment() {
    lateinit var binding : FragmentSklBinding

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
           pickFileArtikel()
        }
        binding.btnlp.setOnClickListener {
            pickFilelp()
        }
        binding.btnsk.setOnClickListener {
            pickFilesk()
        }
    }

    private fun pickFileArtikel() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try {
            launcherIntentArtikel.launch(intent)

        }catch (exception:Exception){
            Toast.makeText(requireActivity(),"Please install a file manager.",Toast.LENGTH_SHORT).show()
        }
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