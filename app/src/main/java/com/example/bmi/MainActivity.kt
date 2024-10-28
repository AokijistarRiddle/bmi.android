package com.example.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmi.ui.theme.BmiTheme
import com.example.bmi.R as R1
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var weightInput: EditText
    private lateinit var heightInput: EditText
    private lateinit var healthyCheckbox: CheckBox
    private lateinit var weightSeekBar: SeekBar
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    private val bmiModel = BmiModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R1.layout.activity_main)

        // Vinculación de vistas
        weightInput = findViewById(R1.id.weightInput)
        heightInput = findViewById(R1.id.heightInput)
        healthyCheckbox = findViewById(R1.id.healthyCheckbox)
        weightSeekBar = findViewById(R1.id.weightSeekBar)
        calculateButton = findViewById(R1.id.calculateButton)
        resultTextView = findViewById(R1.id.resultTextView)

        // Controlador de eventos
        weightSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                weightInput.setText(progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        calculateButton.setOnClickListener {
            val weight = weightInput.text.toString().toFloatOrNull() ?: 0f
            val height = heightInput.text.toString().toFloatOrNull() ?: 0f
            val bmi = bmiModel.calculateBmi(weight, height)
            resultTextView.text = "Tu IMC es: %.2f".format(bmi)

            healthyCheckbox.isChecked = bmiModel.isHealthy(bmi)
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BmiTheme {
        Greeting("Android")
    }
}