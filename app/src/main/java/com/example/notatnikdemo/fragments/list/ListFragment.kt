package com.example.notatnikdemo.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.notatnikdemo.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list, container, false)
        val button: FloatingActionButton = view.findViewById(R.id.floatingAdd)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }

}