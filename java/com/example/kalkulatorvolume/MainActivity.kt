package com.example.kalkulatorvolume

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputAngka = findViewById<EditText>(R.id.inputAngka)
        val inputTinggi = findViewById<EditText>(R.id.inputTinggi)
        val rbPecahan = findViewById<RadioButton>(R.id.rbPecahan)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        // Fungsi pembantu untuk menentukan nilai Pi
        fun getPi(): Double {
            return if (rbPecahan.isChecked) (22.0 / 7.0) else 3.14
        }

        findViewById<Button>(R.id.btnKubus).setOnClickListener {
            val s = inputAngka.text.toString().toDoubleOrNull() ?: 0.0
            val volume = s.pow(3)
            tvHasil.text = "Volume Kubus: ${String.format("%.2f", volume)}"
        }

        findViewById<Button>(R.id.btnTabung).setOnClickListener {
            val r = inputAngka.text.toString().toDoubleOrNull() ?: 0.0
            val t = inputTinggi.text.toString().toDoubleOrNull() ?: 0.0
            val volume = getPi() * r.pow(2) * t
            tvHasil.text = "Volume Tabung : \n${String.format("%.2f", volume)}"
        }

        findViewById<Button>(R.id.btnBola).setOnClickListener {
            val r = inputAngka.text.toString().toDoubleOrNull() ?: 0.0
            val volume = (4.0 / 3.0) * getPi() * r.pow(3)
            tvHasil.text = "Volume Bola : \n${String.format("%.2f", volume)}"
        }
    }
}