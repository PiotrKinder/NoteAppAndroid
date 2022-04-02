package com.example.notatnikdemo.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.notatnikdemo.R
import com.example.notatnikdemo.data.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AddFragment : Fragment() {

    //private lateinit var mNoteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)


       val mNoteViewModel= ViewModelProvider(this).get(NoteViewModel::class.java)



        return view
    }



}