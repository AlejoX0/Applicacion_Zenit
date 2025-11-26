package com.zenit.digital.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.zenit.digital.databinding.FragmentDesktopPcBuilderBinding

data class Component(val name: String, val price: Double)

class DesktopPcBuilderFragment : Fragment() {

    private var _binding: FragmentDesktopPcBuilderBinding? = null
    private val binding get() = _binding!!

    private val motherboards = listOf(
        Component("Selecciona una Tarjeta Madre", 0.0),
        Component("ASUS ROG Strix Z790-E Gaming", 499.99),
        Component("MSI MPG B550 Gaming Carbon", 219.99),
        Component("Gigabyte A520M S2H", 79.99),
        Component("ASRock B660M Pro RS", 129.99),
        Component("NZXT N7 Z790", 299.99),
        Component("ASUS TUF Gaming X570-PRO", 219.99),
        Component("MSI MAG B660 Tomahawk", 189.99),
        Component("Gigabyte Z790 AORUS Elite", 289.99),
        Component("ASRock X670E Steel Legend", 299.99),
        Component("ASUS Prime B760M-A", 159.99)
    )

    private val processors = listOf(
        Component("Selecciona un Procesador", 0.0),
        Component("Intel Core i9-13900K", 589.99),
        Component("AMD Ryzen 9 7950X", 699.99),
        Component("Intel Core i5-13600K", 319.99),
        Component("AMD Ryzen 7 7800X3D", 449.99),
        Component("Intel Core i7-13700K", 409.99),
        Component("AMD Ryzen 5 7600X", 299.99),
        Component("Intel Core i3-13100F", 109.99),
        Component("AMD Ryzen 7 5800X", 249.99),
        Component("Intel Core i9-12900K", 399.99),
        Component("AMD Ryzen 5 5600X", 199.99)
    )

    private val rams = listOf(
        Component("Selecciona Memoria RAM", 0.0),
        Component("Corsair Vengeance 32GB DDR5", 129.99),
        Component("G.Skill Trident Z5 32GB DDR5", 149.99),
        Component("Kingston Fury Beast 16GB DDR4", 49.99),
        Component("Crucial Ballistix 16GB DDR4", 59.99),
        Component("Teamgroup T-Force Vulcan 32GB DDR4", 99.99),
        Component("Corsair Dominator Platinum 64GB DDR5", 299.99),
        Component("G.Skill Ripjaws V 16GB DDR4", 54.99),
        Component("Kingston Renegade 32GB DDR5", 159.99),
        Component("Crucial Pro 32GB DDR5", 119.99),
        Component("Teamgroup Elite 16GB DDR4", 44.99)
    )

    private val storages = listOf(
        Component("Selecciona Almacenamiento", 0.0),
        Component("Samsung 980 Pro 1TB NVMe SSD", 129.99),
        Component("Crucial P5 Plus 2TB NVMe SSD", 189.99),
        Component("WD Black SN850X 1TB NVMe SSD", 149.99),
        Component("Seagate Barracuda 2TB HDD", 54.99),
        Component("Samsung 970 Evo Plus 500GB NVMe SSD", 69.99),
        Component("Crucial MX500 1TB SATA SSD", 89.99),
        Component("WD Blue 1TB HDD", 44.99),
        Component("Seagate FireCuda 530 2TB NVMe SSD", 249.99),
        Component("Samsung 870 QVO 4TB SATA SSD", 299.99),
        Component("WD Green 240GB SATA SSD", 29.99)
    )

    private val gpus = listOf(
        Component("Selecciona Tarjeta de Video", 0.0),
        Component("NVIDIA GeForce RTX 4090", 1599.99),
        Component("AMD Radeon RX 7900 XTX", 999.99),
        Component("NVIDIA GeForce RTX 4070 Ti", 799.99),
        Component("AMD Radeon RX 7800 XT", 499.99),
        Component("NVIDIA GeForce RTX 3060 Ti", 399.99),
        Component("AMD Radeon RX 6700 XT", 349.99),
        Component("NVIDIA GeForce RTX 4060", 299.99),
        Component("AMD Radeon RX 6600", 229.99),
        Component("NVIDIA GeForce GTX 1660 Super", 199.99),
        Component("Intel Arc A770", 329.99)
    )

    private var totalPrice = 0.0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDesktopPcBuilderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinners()
    }

    private fun setupSpinners() {
        setupSpinner(binding.motherboardSpinner, motherboards) { component -> updateTotalPrice() }
        setupSpinner(binding.processorSpinner, processors) { component -> updateTotalPrice() }
        setupSpinner(binding.ramSpinner, rams) { component -> updateTotalPrice() }
        setupSpinner(binding.storageSpinner, storages) { component -> updateTotalPrice() }
        setupSpinner(binding.gpuSpinner, gpus) { component -> updateTotalPrice() }
    }

    private fun setupSpinner(spinner: android.widget.Spinner, components: List<Component>, onItemSelected: (Component) -> Unit) {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, components.map { it.name })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                onItemSelected(components[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun updateTotalPrice() {
        totalPrice = 0.0
        totalPrice += (binding.motherboardSpinner.selectedItemPosition.let { if (it > 0) motherboards[it].price else 0.0 })
        totalPrice += (binding.processorSpinner.selectedItemPosition.let { if (it > 0) processors[it].price else 0.0 })
        totalPrice += (binding.ramSpinner.selectedItemPosition.let { if (it > 0) rams[it].price else 0.0 })
        totalPrice += (binding.storageSpinner.selectedItemPosition.let { if (it > 0) storages[it].price else 0.0 })
        totalPrice += (binding.gpuSpinner.selectedItemPosition.let { if (it > 0) gpus[it].price else 0.0 })
        binding.totalPriceTextView.text = "Precio Total: $${String.format("%.2f", totalPrice)}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}