package com.example.mykrestik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
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
            add(binding.view4)
            add(binding.view5)
            add(binding.view6)
            add(binding.view7)
            add(binding.view8)
            add(binding.view9)

        }
    }
    private var charList = mutableListOf<Int>()

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
        binding.image.setOnClickListener {
            charList.clear()
            clearFields(tvOptions)
        }


    }

    private fun clearFields(list: List<TextView>) {
        for (view in list) {
            view.isClickable = true
            view.text = ""

        }
        binding.textView.text = getString(R.string.let_go)
    }

    private fun touch(list: List<TextView>) {

        for (view in list) {

            view.setOnClickListener {


                if (charList.isEmpty()) {
                    view.text = "X"
                    view.isClickable = false
                    charList.add(1)
                    checkWinner(list)

                } else if (charList.isNotEmpty() && charList.size % 2 != 0) {
                    view.text = "0"
                    view.isClickable = false
                    charList.add(1)
                    checkWinner(list)

                } else if (charList.isNotEmpty() && charList.size % 2 == 0) {
                    view.text = "X"
                    view.isClickable = false
                    charList.add(1)
                    checkWinner(list)

                }
            }

        }


    }

    private fun checkWinner(list: List<TextView>) = with(binding) {
        if (view1.text == "X" && view2.text == "X" && view3.text == "X" ||
            view4.text == "X" && view5.text == "X" && view6.text == "X" ||
            view7.text == "X" && view8.text == "X" && view9.text == "X" ||
            view1.text == "X" && view4.text == "X" && view7.text == "X" ||
            view2.text == "X" && view5.text == "X" && view8.text == "X" ||
            view3.text == "X" && view6.text == "X" && view9.text == "X" ||
            view1.text == "X" && view5.text == "X" && view9.text == "X" ||
            view3.text == "X" && view5.text == "X" && view7.text == "X"
        ) {
            textView.text = getString(R.string.player1)
            for (i in list) i.isClickable = false
            charList.clear()


        } else if (view1.text == "0" && view2.text == "0" && view3.text == "0" ||
            view4.text == "0" && view5.text == "0" && view6.text == "0" ||
            view7.text == "0" && view8.text == "0" && view9.text == "0" ||
            view1.text == "0" && view4.text == "0" && view7.text == "0" ||
            view2.text == "0" && view5.text == "0" && view8.text == "0" ||
            view3.text == "0" && view6.text == "0" && view9.text == "0" ||
            view1.text == "0" && view5.text == "0" && view9.text == "0" ||
            view3.text == "0" && view5.text == "0" && view7.text == "0"
        ) {
            binding.textView.text = getString(R.string.player0)
            for (i in list) i.isClickable = false
            charList.clear()

        }else if (checkCells(list)){
            binding.textView.text = getString(R.string.draw)


        }else return


    }
    private fun checkCells(list: List<TextView>):Boolean{
        var state : Boolean
        val checkList = mutableListOf<String>()
        for (i in list)
            if (i.text.toString()!= ""){
                checkList.add(i.text.toString())
            }
        state = checkList.size == 9


        return state
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}