package com.ateneaApp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.ateneaApp.R
import com.ateneaApp.activities.HomeActivity
import com.squareup.picasso.Picasso

class WelcomeFragment : Fragment() {

    companion object{
        private const val ARG_IMAGE = "image"
        private const val ARG_VISIBLE = "visible"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val buttonView: Button = view.findViewById(R.id.ButtonHome)
        var intent = Intent(activity,HomeActivity::class.java)
        arguments?.takeIf { it.containsKey(ARG_IMAGE) }?.apply {
            val imagenView: ImageView =view.findViewById(R.id.imageViewWelcome)
            Picasso.get().load(getInt(ARG_IMAGE)).into(imagenView)
        }

        arguments?.takeIf { it.containsKey(ARG_VISIBLE)}?.apply {
            buttonView.isVisible = getBoolean(ARG_VISIBLE)
        }

        buttonView.setOnClickListener { View ->
            // Antes de invocar el activity guardar en el Share Preferences para no mostrar otra vez el welcome
        activity?.startActivity(intent)
        }
    }
}