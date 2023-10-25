package com.example.projekakhir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projekakhir.databinding.FragmentSklBinding


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
    }
}