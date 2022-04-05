package com.example.notatnikdemo.fragments.update

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
import androidx.navigation.fragment.navArgs
import com.example.notatnikdemo.R
import com.example.notatnikdemo.model.Note
import com.example.notatnikdemo.viewmodel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mNoteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_update, container, false)
        mNoteViewModel= ViewModelProvider(this).get(NoteViewModel::class.java)
        val topic: EditText= view.findViewById(R.id.titleTextUpdate)
        val content: EditText= view.findViewById(R.id.contentTextUpdate)
        val button: FloatingActionButton= view.findViewById(R.id.floatingBtnConfirmUpdate)
        topic.setText(args.currentNote.topic)
        content.setText(args.currentNote.text)

        button.setOnClickListener{
            updateItem(view)
        }
        return view
    }

    fun updateItem(view: View){
        val topicText: EditText= view.findViewById(R.id.titleTextUpdate)
        val contentText: EditText= view.findViewById(R.id.contentTextUpdate)
        val topic = topicText.text.toString()
        val text = contentText.text.toString()
        val date = Calendar.getInstance().time.toString()
        if(inputCheck(topic,text)){
            val note = Note(args.currentNote.id,topic, text, date)
            mNoteViewModel.updateNote(note)
            Toast.makeText(requireContext(),"Dokonano edycji notatki!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else
            Toast.makeText(requireContext(),"Należy wypełnić wszystkie pola!",Toast.LENGTH_LONG).show()
    }

    private fun inputCheck(topic: String, content: String): Boolean{
        return !(TextUtils.isEmpty(topic) && TextUtils.isEmpty(content))
    }

}