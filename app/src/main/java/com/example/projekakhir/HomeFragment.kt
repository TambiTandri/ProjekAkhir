package com.example.projekakhir

import android.content.Context
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.example.projekakhir.databinding.FragmentHomeBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView
import java.lang.IllegalArgumentException


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.menu.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_menuFragment)
        }
        binding.cvFcIjazahSma.setOnClickListener {
            handlerCardViewClikc(binding.cvFcIjazahSma)
        }
        binding.cvFcAkteLahir.setOnClickListener {  }
        binding.cvFcKK.setOnClickListener {  }
        binding.cvFcKTP.setOnClickListener {  }
        binding.cvFcKTM.setOnClickListener {  }
        binding.cvPasFoto.setOnClickListener {  }
        binding.cvSkl.setOnClickListener {  }
        binding.cvSertifToeic.setOnClickListener {  }
        resetCardViewColors()
    }

    private fun handlerCardViewClikc(cardView:CardView){
        resetCardViewColors()

        val linearLayout =cardView.findViewById<LinearLayout>(R.id.linearLayout)
        val ivCheck = cardView.findViewById<ShapeableImageView>(R.id.ivCheck1)
        linearLayout.setBackgroundColor(resources.getColor(R.color.biru))
        ivCheck.setColorFilter(resources.getColor(R.color.biru))
    }

    private fun resetCardViewColors() {
        val cardViews = listOf(
            binding.cvFcIjazahSma,
            binding.cvFcAkteLahir,
            binding.cvFcKK,
            binding.cvFcKTP,
            binding.cvFcKTM,
            binding.cvPasFoto,
            binding.cvSkl,
            binding.cvSertifToeic
        )
        for(cardView in cardViews){
            val linearLayout = cardView.findViewById<LinearLayout>(R.id.linearLayout)
            val ivCheck = cardView.findViewById<ShapeableImageView>(R.id.ivCheck1)
            linearLayout.setBackgroundColor(resources.getColor(R.color.white))
            ivCheck.setColorFilter(resources.getColor(R.color.black))
        }
    }

//    private fun selectedIndex(selectIndex:Int){
//        val cvSelectList = listOf(
//            binding.cvFcIjazahSma,
//            binding.cvFcAkteLahir,
//            binding.cvFcKK,
//            binding.cvFcKTP,
//            binding.cvFcKTM,
//            binding.cvPasFoto,
//            binding.cvSkl,
//            binding.cvSertifToeic
//        )
//        cvSelectList.forEachIndexed { index, cvList ->
//            val isSelected = (index == selectIndex)
//            val iconColor = if(isSelected){
//                R.color.white
//            }else{
//                R.color.black
//            }
//            val backgroundColorRes = if (isSelected){
//                R.color.biru
//            }else{
//                R.color.white
//            }
//            cvList.findFragment<LinearLayout>(layoutIndex(index)).setBackgroundColor(resources.getColor(backgroundColorRes))
//            cvList.findViewById<ShapeableImageView>(checklisIcon(index)).setBackgroundColor(resources.getColor(iconColor))
//        }
//    }
//
//    private fun checklisIcon(index : Int):Int{
//        return when(index){
//            0 -> R.id.ivCheck1
//            1 -> R.id.ivCheck2
//            2 -> R.id.ivCheck3
//            3 -> R.id.ivCheck4
//            4 -> R.id.ivCheck5
//            5 -> R.id.ivCheck6
//            6 -> R.id.ivCheck7
//            7 -> R.id.ivCheck8
//            else -> throw IllegalArgumentException("Invalid index")
//        }
//    }
//
//    private fun layoutIndex(index:Int):Int{
//        return when(index){
//            0 -> R.id.linearLayout
//            1 -> R.id.linearLayout2
//            2 -> R.id.linearLayout3
//            3 -> R.id.linearLayout4
//            4 -> R.id.linearLayout5
//            5 -> R.id.linearLayout6
//            6 -> R.id.linearLayout7
//            7 -> R.id.linearLayout8
//            else -> throw IllegalArgumentException("Invalid Index")
//        }
//    }
}
