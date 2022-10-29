package com.example.hackathon2022.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.hackathon2022.R
import com.example.hackathon2022.databinding.FragmentAuthBinding
import com.example.hackathon2022.databinding.FragmentFormBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var binding:FragmentFormBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding= FragmentFormBinding.inflate(inflater,container,false)
        binding=fragmentBinding
        binding!!.button1.setOnClickListener {

            var list= listOf(binding!!.spinner.selectedItem.toString(),
                binding!!.spinner2.selectedItem.toString(),
                binding!!.spinner3.selectedItem.toString(),
                binding!!.spinner4.selectedItem.toString())
            binding!!.textResulted.text=list.joinToString()
        }

        return fragmentBinding.root
    }


}