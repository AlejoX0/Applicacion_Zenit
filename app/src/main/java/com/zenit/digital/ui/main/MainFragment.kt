package com.zenit.digital.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.zenit.digital.R
import com.zenit.digital.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the Toolbar
        (activity as? AppCompatActivity)?.setSupportActionBar(binding.toolbar)
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        binding.toolbar.setupWithNavController(findNavController(), appBarConfiguration)

        // Set up the RecyclerView
        val menuItems = listOf(
            MenuItem(getString(R.string.main_topic), R.id.action_mainFragment_to_mainTopicFragment),
            MenuItem(getString(R.string.mission_vision), R.id.action_mainFragment_to_missionFragment),
            MenuItem(getString(R.string.about_us), R.id.action_mainFragment_to_aboutUsFragment),
            MenuItem(getString(R.string.catalog), R.id.action_mainFragment_to_catalogFragment),
            MenuItem(getString(R.string.gallery), R.id.action_mainFragment_to_galleryFragment),
            MenuItem(getString(R.string.video), R.id.action_mainFragment_to_videoFragment),
            MenuItem(getString(R.string.contact), R.id.action_mainFragment_to_contactFragment),
            MenuItem(getString(R.string.social), R.id.action_mainFragment_to_socialFragment),
            MenuItem(getString(R.string.calculator), R.id.action_mainFragment_to_calculatorFragment)
        )

        binding.mainMenuRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.mainMenuRecyclerView.adapter = MainMenuAdapter(menuItems)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}