package com.donyawan.testandroid.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.donyawan.testandroid.R
import com.donyawan.testandroid.databinding.FirstPageBinding
import com.donyawan.testandroid.db.TaskEntry
import com.donyawan.testandroid.viewmodel.TaskViewModel

class FirstPage: Fragment() {

    lateinit var binding: FirstPageBinding
    private val taskViewModel: TaskViewModel by viewModels()
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FirstPageBinding.inflate(layoutInflater)
        taskAdapter = TaskAdapter()

        taskViewModel.getAllTask.observe(viewLifecycleOwner, {
            taskAdapter.submitList(it)
        })

        setDeleteButton()
        setAddButton()

        binding.input.addTextChangedListener {
            if (it != null) {
                binding.btnAdd.isEnabled = it.isNotEmpty()
            }
        }
        return binding.root
    }


    private fun setDeleteButton() {

    }

    private fun setAddButton() {
        binding.btnAdd.isEnabled = binding.input.text.isNotEmpty()
        binding.btnAdd.setOnClickListener {
            if (TextUtils.isEmpty(binding.input.text)) {
                Toast.makeText(requireContext(), "Please, Fill your task", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item_title = binding.input.text.toString()
            val itemEntry = TaskEntry(
                0,
                item_title,
                0,
                System.currentTimeMillis()
            )

            taskViewModel.insert(itemEntry)
        }
    }
}