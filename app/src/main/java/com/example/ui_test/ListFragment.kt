package com.example.ui_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.ui_test.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleListSetup()
    }


    val someList = listOf("aaa aaa","bbb bbb","ccc ccc","ddd ddd","eee eee","fff fff","ggg ggg","hhh hhh","iii iii","jjj jjj","kkk kkk","lll lll","mmm mmm","nnn nnn","ooo ooo","ppp ppp")

    fun recycleListSetup(){
        var adapter = RecycleListAdapter(someList)

        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.recycleView.adapter = adapter
    }
}