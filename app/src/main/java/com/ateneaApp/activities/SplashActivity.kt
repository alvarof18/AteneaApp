package com.ateneaApp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import com.ateneaApp.databinding.ActivitySplashBinding

/* Aqui agregar la siguiente logica
* Siempre se debe mostrar esta pantalla al inicio de la aplicacion
* si el usuario esta logeado se debe redirigir a la pantalla principal de la apliacion
* Sino despues de la pantalla de ir a la pagina de Login or Sing Up y luego de eso ir a la pantalla de Bienvenida y despues a la principal de la aplicacion
* */
class SplashActivity : AppCompatActivity() {

    private lateinit var bindingSplash: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSplash = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(bindingSplash.root)

        //val sideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
       // bindingSplash.logoIcon.startAnimation(sideAnimation)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)


    }
}