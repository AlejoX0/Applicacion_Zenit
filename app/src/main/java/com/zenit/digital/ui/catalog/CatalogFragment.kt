package com.zenit.digital.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.zenit.digital.R
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
            Product("Bose Earbuds", "Sonido de alta fidelidad en un diseño compacto.", "$279.99", R.drawable.bose_earbuts),
            Product("Dell XPS 14", "Potencia y elegancia para profesionales.", "$1,499.99", R.drawable.dellxps_14),
            Product("Google Nest Hub", "El centro de tu hogar inteligente.", "$99.99", R.drawable.google_nest_hub),
            Product("iPhone 15 Pro", "La experiencia móvil definitiva.", "$999.99", R.drawable.iphone15pro),
            Product("Nintendo Switch OLED", "Juega donde quieras, como quieras.", "$349.99", R.drawable.nintendo_switch_oled),
            Product("Philips Hue", "Iluminación inteligente para cada momento.", "$49.99", R.drawable.philips),
            Product("PlayStation 5", "La nueva generación de videojuegos ya está aquí.", "$499.99", R.drawable.playstation5),
            Product("Samsung Galaxy S24 Ultra", "El poder de la IA en tus manos.", "$1,299.99", R.drawable.samsung_galaxys24_utra),
            Product("Sony WH-1000XM5", "El silencio es oro. Disfruta de la mejor cancelación de ruido.", "$399.99", R.drawable.sony_wh1000xm5)
        )

        binding.catalogRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.catalogRecyclerView.adapter = CatalogAdapter(products)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}