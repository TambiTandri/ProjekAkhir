package com.example.projekakhir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projekakhir.databinding.FragmentPengambilanIjazahBinding


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
    }


}