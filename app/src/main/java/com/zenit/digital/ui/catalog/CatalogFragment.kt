package com.zenit.digital.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.zenit.digital.databinding.FragmentCatalogBinding

class CatalogFragment : Fragment() {

    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val products = listOf(
            Product("Audífonos Inalámbricos", "La mejor experiencia de sonido sin cables.", "$49.99"),
            Product("Cámara de Acción", "Captura tus aventuras en 4K.", "$199.99"),
            Product("Smartwatch", "Tu vida conectada, en tu muñeca.", "$149.99"),
            Product("Teclado Mecánico", "La precisión que necesitan tus juegos.", "$89.99"),
            Product("Mouse Gamer", "Velocidad y precisión para la victoria.", "$59.99"),
            Product("Monitor Curvo", "Sumérgete en una experiencia visual única.", "$299.99")
        )

        binding.catalogRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.catalogRecyclerView.adapter = CatalogAdapter(products)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}