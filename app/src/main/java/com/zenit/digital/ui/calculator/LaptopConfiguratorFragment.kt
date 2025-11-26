package com.zenit.digital.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.zenit.digital.databinding.FragmentLaptopConfiguratorBinding

class LaptopConfiguratorFragment : Fragment() {

    private var _binding: FragmentLaptopConfiguratorBinding? = null
    private val binding get() = _binding!!

    private val rams = listOf(
        Component("Selecciona Memoria RAM", 0.0),
        Component("8GB DDR4", 0.0),
        Component("16GB DDR4", 79.99),
        Component("32GB DDR4", 159.99),
        Component("16GB DDR5", 99.99),
        Component("32GB DDR5", 199.99),
        Component("64GB DDR5", 399.99)
    )

    private val storages = listOf(
        Component("Selecciona Almacenamiento", 0.0),
        Component("256GB NVMe SSD", 0.0),
        Component("512GB NVMe SSD", 49.99),
        Component("1TB NVMe SSD", 99.99),
        Component("2TB NVMe SSD", 199.99),
        Component("4TB NVMe SSD", 399.99)
    )

    private var totalPrice = 899.99 // Base price for a laptop

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
        binding.totalPriceTextView.text = "Precio Total: $${String.format("%.2f", currentPrice)}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}