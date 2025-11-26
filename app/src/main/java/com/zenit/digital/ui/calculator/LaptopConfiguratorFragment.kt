package com.zenit.digital.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.zenit.digital.databinding.FragmentLaptopConfiguratorBinding
import java.text.NumberFormat
import java.util.Locale

class LaptopConfiguratorFragment : Fragment() {

    private var _binding: FragmentLaptopConfiguratorBinding? = null
    private val binding get() = _binding!!

    private val rams = listOf(
        Component("Selecciona Memoria RAM", 0.0),
        Component("8GB DDR4", 0.0),
        Component("16GB DDR4", 320000.0),
        Component("32GB DDR4", 640000.0),
        Component("16GB DDR5", 400000.0),
        Component("32GB DDR5", 800000.0),
        Component("64GB DDR5", 1600000.0)
    )

    private val storages = listOf(
        Component("Selecciona Almacenamiento", 0.0),
        Component("256GB NVMe SSD", 0.0),
        Component("512GB NVMe SSD", 200000.0),
        Component("1TB NVMe SSD", 400000.0),
        Component("2TB NVMe SSD", 800000.0),
        Component("4TB NVMe SSD", 1600000.0)
    )

    private var totalPrice = 3600000.0 // Base price for a laptop
    private val format = NumberFormat.getCurrencyInstance(Locale("es", "CO"))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLaptopConfiguratorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinners()
        updateTotalPrice()
    }

    private fun setupSpinners() {
        setupSpinner(binding.ramSpinner, rams) { updateTotalPrice() }
        setupSpinner(binding.storageSpinner, storages) { updateTotalPrice() }
    }

    private fun setupSpinner(spinner: android.widget.Spinner, components: List<Component>, onItemSelected: () -> Unit) {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, components.map { it.name })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                onItemSelected()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun updateTotalPrice() {
        var currentPrice = totalPrice
        currentPrice += (binding.ramSpinner.selectedItemPosition.let { if (it > 0) rams[it].price else 0.0 })
        currentPrice += (binding.storageSpinner.selectedItemPosition.let { if (it > 0) storages[it].price else 0.0 })
        binding.totalPriceTextView.text = "Precio Total: ${format.format(currentPrice)}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}