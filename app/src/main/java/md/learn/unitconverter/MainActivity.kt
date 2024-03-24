package md.learn.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import md.learn.unitconverter.ui.theme.UnitConverterTheme
import java.time.format.TextStyle
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    var conversionFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor = remember { mutableStateOf(1.00) }

    val customTextStyle = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Monospace,
        fontSize = 32.sp,
        color = Color.Blue
    )

    fun convertUnits() {
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0 //?: -> elvis operator
        val result = (inputValueDouble * conversionFactor.value * 100.0/ oConversionFactor.value).roundToInt()/ 100.0
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(), //we say fill max size
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        /**
         * Instead of using fill max size, which does that in all directions, we can also fill the max width
         * only on the horizontal direction, or fill max height on a vertical, so you have control over these
         */
    ) {
        //Column is the parent of row
        //Here all the UI elements will be stacked below each other
        Text("Unit converter", style  = customTextStyle)
        Spacer(modifier = Modifier.height(16.dp)) //Spacer is a blank element that is used to create a Space between two UI elements
        OutlinedTextField(value = inputValue, onValueChange = {
            //Here goes what sould happen, when he value of our OutlinedTextField changes
            inputValue = it // enter someting into outlined textfield
            convertUnits()
        }, label = { Text(text = "Enter Value") })
        Row {
            //Here all the UI elements will be stacked next each other
            val context = LocalContext.current

            Box {
                /**
                 * A box is layout element just like  row nd column.
                 * It works differently n that it arranges and stacks composables on top of ach other.
                 * It is commonly used to create custom nd complex layouts, because the dropdown enu cannot stand
                 * on its own, as t required a parent, which can help it position itself on the screen
                 */
                Button(onClick = { iExpanded = true }) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centimeters"
                            conversionFactor.value = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Meters"
                            conversionFactor.value = 1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Feet"
                            conversionFactor.value = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Milimieters") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Milimieters"
                            conversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                }
                /**
                 * we have this expanded boolean.
                 * it's a boolean which says is it expanded.
                 * So is it drop down menu open or is it closed.
                 */
            }
            Spacer(modifier = Modifier.width(18.dp))
            Box {
                Button(onClick = { oExpanded = true }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, "Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Centimeters"
                            oConversionFactor.value = 0.01
                            convertUnits()}
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Meters"
                            oConversionFactor.value = 1.00
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Feet"
                            oConversionFactor.value = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Milimieters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Milimieters"
                            oConversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                }
            }


        }
        Spacer(modifier = Modifier.height(16.dp))
        // Result Text
        Text("Result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Preview(showBackground = true) //Use the @Preview annotation to mark the next function for preview
//To the @Preview annotation, add a parameter to show a background: showBackground = true.
//Observe how the preview now has a white background, making elements more readable.
@Composable
fun UnitConverterPreview() {
    UnitConverter() //This will allow us to preview the unitConverter Composable.
}
