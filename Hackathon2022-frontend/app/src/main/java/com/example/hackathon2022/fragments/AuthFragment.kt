package com.example.hackathon2022.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hackathon2022.R
import com.example.hackathon2022.databinding.FragmentAuthBinding




class AuthFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var binding:FragmentAuthBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding=FragmentAuthBinding.inflate(inflater,container,false)
        binding=fragmentBinding
        binding!!.button.setOnClickListener {
            goNext()
        }
            return fragmentBinding.root

    }

    fun goNext()
    {
        findNavController().navigate(R.id.action_authFragment3_to_formFragment)
    }
}