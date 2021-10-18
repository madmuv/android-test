package com.donyawan.testandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.donyawan.testandroid.databinding.ActivityMainBinding
import com.donyawan.testandroid.ui.FirstPage
import com.donyawan.testandroid.viewmodel.TaskViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    val firstPage = FirstPage()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.mainContainer.id, firstPage)
            .commit()
    }

}