package com.example.mykrestik

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mykrestik.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("GameFragment == null")
    private val tvOptions by lazy {
        mutableListOf<TextView>().apply {
            add(binding.view1)
            add(binding.view2)
            add(binding.view3)
            add(binding.view5)
            add(binding.view6)
            add(binding.view7)
            add(binding.view9)
            add(binding.view10)
            add(binding.view11)

        }
    }
    private var charList = mutableListOf<Char>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       touch(tvOptions)
    }

    private fun touch(list: List<TextView>) {

        for (view in list) {

            view.setOnClickListener {
                val lastItem = charList.last()
               if(charList.isEmpty() || lastItem.equals("0") ){
                   view.text = "X"

               }else{
                   view.text = "0"
               }
            }

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}