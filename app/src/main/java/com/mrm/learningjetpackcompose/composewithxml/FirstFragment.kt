package com.mrm.learningjetpackcompose.composewithxml

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.mrm.learningjetpackcompose.R
import com.mrm.learningjetpackcompose.image.UserCard

class FirstFragment: Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ComposeView>(R.id.compose_view).setContent {
            UserCard()
        }
    }

    /**
     * when you don't need to use xml in fragment we can use it as below.
     */
    /*override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                UserCard()
            }
        }

    }*/
}