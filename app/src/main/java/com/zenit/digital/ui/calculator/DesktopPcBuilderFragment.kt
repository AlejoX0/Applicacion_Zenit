package com.zenit.digital.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.zenit.digital.databinding.FragmentDesktopPcBuilderBinding
import java.text.NumberFormat
import java.util.Locale

data class Component(val name: String, val price: Double)

class DesktopPcBuilderFragment : Fragment() {

    private var _binding: FragmentDesktopPcBuilderBinding? = null
    private val binding get() = _binding!!

    private val motherboards = listOf(
        Component("Selecciona una Tarjeta Madre", 0.0),
        Component("ASUS ROG Strix Z790-E Gaming", 2000000.0),
        Component("MSI MPG B550 Gaming Carbon", 880000.0),
        Component("Gigabyte A520M S2H", 320000.0),
        Component("ASRock B660M Pro RS", 520000.0),
        Component("NZXT N7 Z790", 1200000.0),
        Component("ASUS TUF Gaming X570-PRO", 880000.0),
        Component("MSI MAG B660 Tomahawk", 760000.0),
        Component("Gigabyte Z790 AORUS Elite", 1160000.0),
        Component("ASRock X670E Steel Legend", 1200000.0),
        Component("ASUS Prime B760M-A", 640000.0)
    )

    private val processors = listOf(
        Component("Selecciona un Procesador", 0.0),
        Component("Intel Core i9-13900K", 2360000.0),
        Component("AMD Ryzen 9 7950X", 2800000.0),
        Component("Intel Core i5-13600K", 1280000.0),
        Component("AMD Ryzen 7 7800X3D", 1800000.0),
        Component("Intel Core i7-13700K", 1640000.0),
        Component("AMD Ryzen 5 7600X", 1200000.0),
        Component("Intel Core i3-13100F", 440000.0),
        Component("AMD Ryzen 7 5800X", 1000000.0),
        Component("Intel Core i9-12900K", 1600000.0),
        Component("AMD Ryzen 5 5600X", 800000.0)
    )

    private val rams = listOf(
        Component("Selecciona Memoria RAM", 0.0),
        Component("Corsair Vengeance 32GB DDR5", 520000.0),
        Component("G.Skill Trident Z5 32GB DDR5", 600000.0),
        Component("Kingston Fury Beast 16GB DDR4", 200000.0),
        Component("Crucial Ballistix 16GB DDR4", 240000.0),
        Component("Teamgroup T-Force Vulcan 32GB DDR4", 400000.0),
        Component("Corsair Dominator Platinum 64GB DDR5", 1200000.0),
        Component("G.Skill Ripjaws V 16GB DDR4", 220000.0),
        Component("Kingston Renegade 32GB DDR5", 640000.0),
        Component("Crucial Pro 32GB DDR5", 480000.0),
        Component("Teamgroup Elite 16GB DDR4", 180000.0)
    )

    private val storages = listOf(
        Component("Selecciona Almacenamiento", 0.0),
        Component("Samsung 980 Pro 1TB NVMe SSD", 520000.0),
        Component("Crucial P5 Plus 2TB NVMe SSD", 760000.0),
        Component("WD Black SN850X 1TB NVMe SSD", 600000.0),
        Component("Seagate Barracuda 2TB HDD", 220000.0),
        Component("Samsung 970 Evo Plus 500GB NVMe SSD", 280000.0),
        Component("Crucial MX500 1TB SATA SSD", 360000.0),
        Component("WD Blue 1TB HDD", 180000.0),
        Component("Seagate FireCuda 530 2TB NVMe SSD", 1000000.0),
        Component("Samsung 870 QVO 4TB SATA SSD", 1200000.0),
        Component("WD Green 240GB SATA SSD", 120000.0)
    )

    private val gpus = listOf(
        Component("Selecciona Tarjeta de Video", 0.0),
        Component("NVIDIA GeForce RTX 4090", 6400000.0),
        Component("AMD Radeon RX 7900 XTX", 4000000.0),
        Component("NVIDIA GeForce RTX 4070 Ti", 3200000.0),
        Component("AMD Radeon RX 7800 XT", 2000000.0),
        Component("NVIDIA GeForce RTX 3060 Ti", 1600000.0),
        Component("AMD Radeon RX 6700 XT", 1400000.0),
        Component("NVIDIA GeForce RTX 4060", 1200000.0),
        Component("AMD Radeon RX 6600", 920000.0),
        Component("NVIDIA GeForce GTX 1660 Super", 800000.0),
        Component("Intel Arc A770", 1320000.0)
    )

    private var totalPrice = 0.0
    private val format = NumberFormat.getCurrencyInstance(Locale("es", "CO"))

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
        setupSpinner(binding.motherboardSpinner, motherboards) { updateTotalPrice() }
        setupSpinner(binding.processorSpinner, processors) { updateTotalPrice() }
        setupSpinner(binding.ramSpinner, rams) { updateTotalPrice() }
        setupSpinner(binding.storageSpinner, storages) { updateTotalPrice() }
        setupSpinner(binding.gpuSpinner, gpus) { updateTotalPrice() }
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
        totalPrice = 0.0
        totalPrice += (binding.motherboardSpinner.selectedItemPosition.let { if (it > 0) motherboards[it].price else 0.0 })
        totalPrice += (binding.processorSpinner.selectedItemPosition.let { if (it > 0) processors[it].price else 0.0 })
        totalPrice += (binding.ramSpinner.selectedItemPosition.let { if (it > 0) rams[it].price else 0.0 })
        totalPrice += (binding.storageSpinner.selectedItemPosition.let { if (it > 0) storages[it].price else 0.0 })
        totalPrice += (binding.gpuSpinner.selectedItemPosition.let { if (it > 0) gpus[it].price else 0.0 })
        binding.totalPriceTextView.text = "Precio Total: ${format.format(totalPrice)}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}