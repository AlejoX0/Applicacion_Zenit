package com.zenit.digital.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.zenit.digital.R
import com.zenit.digital.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val images = listOf(
            GalleryImage(R.drawable.bose_earbuts),
            GalleryImage(R.drawable.dellxps_14),
            GalleryImage(R.drawable.google_nest_hub),
            GalleryImage(R.drawable.iphone15pro),
            GalleryImage(R.drawable.nintendo_switch_oled),
            GalleryImage(R.drawable.philips),
            GalleryImage(R.drawable.playstation5),
            GalleryImage(R.drawable.samsung_galaxys24_utra),
            GalleryImage(R.drawable.sony_wh1000xm5)
        )

        binding.galleryRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.galleryRecyclerView.adapter = GalleryAdapter(images)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}