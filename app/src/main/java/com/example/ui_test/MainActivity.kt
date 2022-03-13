package com.example.ui_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.example.ui_test.databinding.ActivityMainBinding

import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.bar)

        binding.menuButton.setOnClickListener { getPopup() }
    }

    private fun getPopup() {
        val popupMenu = PopupMenu(this,binding.menuButton)

        popupMenu.getMenu().add(0, Menu.FIRST, 0, "pink")
        popupMenu.getMenu().add(1, Menu.CATEGORY_ALTERNATIVE, 1, "list")


        popupMenu.setOnMenuItemClickListener(object :
            PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem): Boolean {
                Toast.makeText(applicationContext, "${item.order}  ${item.title} ", Toast.LENGTH_SHORT).show()
                when(item.order){
                    0 -> with(binding.navHostFragment){
                            if (findNavController().currentDestination?.id == R.id.listFragment){
                                binding.navHostFragment.findNavController().navigate(R.id.action_listFragment_to_addonFragment)
                            }
                            else{
                                Toast.makeText(applicationContext, "Other than list", Toast.LENGTH_SHORT).show()
                            }
                        }

                    1 -> binding.navHostFragment.findNavController().navigateUp()
                }

                return false
            }
        })
        popupMenu.show()
    }


}

