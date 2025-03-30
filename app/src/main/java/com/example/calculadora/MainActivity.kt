package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import android.widget.Button
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadora.ui.theme.CalculadoraTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {

    var textScreenValue : String = ""
    var operationResult : Double = 0.0
    var operation : String = ""
    lateinit var textScreen: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_layout)
        textScreen = findViewById(R.id.text_screen);

        val buttonNumbers = listOf(
            R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4,
            R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9,
            R.id.btn_dot
        )

        val buttonOperations = listOf(
            R.id.btn_adittion, R.id.btn_substraction, R.id.btn_division,
            R.id.btn_multiplication
        )

        buttonNumbers.forEach { id ->
            findViewById<Button>(id).setOnClickListener { onButtonNumberClick(it as Button) }
        }

        buttonOperations.forEach{ id ->
            findViewById<Button>(id).setOnClickListener { onButtonOperationClick(it as Button) }
        }

        findViewById<Button>(R.id.btn_result).setOnClickListener { computeResultClick() }
        findViewById<Button>(R.id.btn_delete).setOnClickListener { deleteAll() }


    }

    private fun onButtonNumberClick(button: Button){
        textScreenValue += button.text.toString();
        textScreen.text = textScreenValue
    }

    private fun onButtonOperationClick(button: Button){
        operationResult = textScreen.text.toString().toDouble()
        clearTextScreen()
        operation = button.text.toString()
    }

    private fun computeResultClick(){
        when(operation){
            "+" -> {
                var number2 = textScreen.text.toString().toDouble()
                operationResult += number2
                textScreen.text = operationResult.toString()
            }
            "-" -> {
                var number2 = textScreen.text.toString().toDouble()
                operationResult -= number2
                textScreen.text = operationResult.toString()
            }
            "/" -> {
                var number2 = textScreen.text.toString().toDouble()
                operationResult /= number2
                textScreen.text = operationResult.toString()
            }
            "X" -> {
                var number2 = textScreen.text.toString().toDouble()
                operationResult *= number2
                textScreen.text = operationResult.toString()
            }
        }
    }

    private fun deleteAll(){
        operationResult = 0.0
        clearTextScreen()
    }

    private fun doOperation(){

    }

    private fun clearTextScreen(){
        textScreen.text = ""
        textScreenValue = ""
    }


}