package com.example.projekakhir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projekakhir.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private lateinit var binding:FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnClose.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_homeFragment)
        }
        binding.tvHome.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_homeFragment)
        }
        binding.tvLogin.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_loginFragment)
        }
        binding.tvPersyaratan.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_persyaratanFragment)
        }


    }


}