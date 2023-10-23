package com.example.projekakhir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.projekakhir.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding

    var username:String = "yaman.nurtria"
    var password:String = "12345678"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHome.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        binding.btnLogin.setOnClickListener{
            val usernameInput = binding.inputUsername.text.toString()
            val passwordInput = binding.inputPassword.text.toString()
            if (username == usernameInput && password == passwordInput ){
                findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                Toast.makeText(context,"Login Berhasil",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,"Login Gagal",Toast.LENGTH_SHORT).show()

            }
        }
    }


}