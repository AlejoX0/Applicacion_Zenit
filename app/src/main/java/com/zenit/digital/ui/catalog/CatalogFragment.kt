package com.zenit.digital.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.zenit.digital.R
import com.zenit.digital.databinding.FragmentCatalogBinding
import java.text.NumberFormat
import java.util.Locale

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

        val format = NumberFormat.getCurrencyInstance(Locale("es", "CO"))

        val products = listOf(
            Product("Bose Earbuds", "Sonido de alta fidelidad en un diseño compacto.", format.format(1100000), R.drawable.bose_earbuts),
            Product("Dell XPS 14", "Potencia y elegancia para profesionales.", format.format(6000000), R.drawable.dellxps_14),
            Product("Google Nest Hub", "El centro de tu hogar inteligente.", format.format(400000), R.drawable.google_nest_hub),
            Product("iPhone 15 Pro", "La experiencia móvil definitiva.", format.format(4000000), R.drawable.iphone15pro),
            Product("Nintendo Switch OLED", "Juega donde quieras, como quieras.", format.format(1400000), R.drawable.nintendo_switch_oled),
            Product("Philips Hue", "Iluminación inteligente para cada momento.", format.format(200000), R.drawable.philips),
            Product("PlayStation 5", "La nueva generación de videojuegos ya está aquí.", format.format(2000000), R.drawable.playstation5),
            Product("Samsung Galaxy S24 Ultra", "El poder de la IA en tus manos.", format.format(5200000), R.drawable.samsung_galaxys24_utra),
            Product("Sony WH-1000XM5", "El silencio es oro. Disfruta de la mejor cancelación de ruido.", format.format(1600000), R.drawable.sony_wh1000xm5)
        )

        binding.catalogRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.catalogRecyclerView.adapter = CatalogAdapter(products)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}