package com.example.notatnikdemo.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.notatnikdemo.R
import com.example.notatnikdemo.model.Note
import com.example.notatnikdemo.viewmodel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*


class AddFragment : Fragment() {

    private lateinit var mNoteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)
        val button: FloatingActionButton= view.findViewById(R.id.floatingBtnConfirm)

        mNoteViewModel= ViewModelProvider(this).get(NoteViewModel::class.java)

        button.setOnClickListener(){
            insertDataToDatabase(view)
        }

        return view
    }

    private fun insertDataToDatabase(view: View) {
        val topicNote: EditText = view.findViewById(R.id.titleText)
        val contentNote: EditText = view.findViewById(R.id.contentText)
        val topic= topicNote.text.toString()
        val content = contentNote.text.toString()
        val date = Calendar.getInstance().time.toString()

        if(inputCheck(topic,content)){
            val note = Note(0,topic, content, date)
            mNoteViewModel.addNote(note)
            Toast.makeText(requireContext(),"Pomyślnie dodano!",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Należy wypełnić wszystkie pola!",Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(topic: String, content: String): Boolean{
     return !(TextUtils.isEmpty(topic) && TextUtils.isEmpty(content))
    }

}