package juniar.nicolas.simpleslider.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import juniar.nicolas.simpleslider.R
import kotlinx.android.synthetic.main.fragment_image.image

class ImageFragment : Fragment(R.layout.fragment_image) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("image")?.let {
            image.setBackgroundResource(it)
        }
    }
}