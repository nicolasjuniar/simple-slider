package juniar.nicolas.simpleslider.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import juniar.nicolas.simpleslider.R
import juniar.nicolas.simpleslider.R.drawable
import juniar.nicolas.simpleslider.ui.ImageFragment
import juniar.nicolas.simpleslider.ui.dashboard.ImageSliderAdapter
import kotlinx.android.synthetic.main.fragment_home.image_slider

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    var selected = 0
    lateinit var mainHandler: Handler

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageSliderAdapter = ImageSliderAdapter(parentFragmentManager, listOf(
            ImageFragment().apply { arguments = bundleOf("image" to drawable.image_1) },
            ImageFragment().apply { arguments = bundleOf("image" to drawable.image_2) },
            ImageFragment().apply { arguments = bundleOf("image" to drawable.image_3) }
        ))
        with(image_slider) {
            adapter = imageSliderAdapter
        }
        mainHandler = Handler(Looper.getMainLooper())

        mainHandler.post(object : Runnable {
            override fun run() {
                if (selected <= 2) {
                    selected += 1
                } else {
                    selected = 0
                }
                image_slider.currentItem = selected
            }
        })
    }

    override fun onPause() {
        super.onPause()
    }
}
