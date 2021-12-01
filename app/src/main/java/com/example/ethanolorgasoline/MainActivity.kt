package com.example.ethanolorgasoline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    var valorGas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekbar = findViewById<SeekBar>(R.id.seekBar)
        val txtGasoline = findViewById<TextView>(R.id.txtValorGasolina)
        val txtResult = findViewById<TextView>(R.id.txtResultado)
        val btn = findViewById<Button>(R.id.btnCalc)

        seekbar.max = 1000

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                valorGas = progress
                var text = "R$ "
                text += formatValue(valorGas/100.0)
                txtGasoline.text = text
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                txtResult.text = "Select the gasoline value"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                txtResult.text = "Click in Calculate for to know the Result"
            }

        })

        btn.setOnClickListener {
            var valorResult = (valorGas * 0.7)/100.0
            var text = "Fill up with Ethanol if it costs up to R$:"
            text += formatValue(valorResult)

            txtResult.text = text
        }
    }

    private fun formatValue(value: Double): Any? {
        return String.format(Locale.FRANCE,"%.2f",value)

    }
}