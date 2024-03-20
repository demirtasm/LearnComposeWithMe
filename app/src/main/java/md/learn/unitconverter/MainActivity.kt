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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import md.learn.unitconverter.ui.theme.UnitConverterTheme

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
    Column (
        modifier = Modifier.fillMaxSize(), //we say fill max size
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        /**
         * Instead of using fill max size, which does that in all directions, we can also fill the max width
         * only on the horizontal direction, or fill max height on a vertical, so you have control over these
         */
    ){
        //Column is the parent of row
        //Here all the UI elements will be stacked below each other
        Text("Unit converter")
        Spacer(modifier = Modifier.height(16.dp)) //Spacer is a blank element that is used to create a Space between two UI elements
        OutlinedTextField(value = "", onValueChange = {
            //Here goes what sould happen, when he value of our OutlinedTextField changes
        })
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
                Button(onClick = {
                    Toast.makeText(
                        context,
                        "Thanks for clicking",
                        Toast.LENGTH_LONG
                    ).show()
                }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown,"Arrow Down")
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Milimieters") },
                        onClick = { /*TODO*/ }
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
                Button(onClick = {
                    Toast.makeText(
                        context,
                        "Thanks for clicking",
                        Toast.LENGTH_LONG
                    ).show()
                }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown,"Arrow Down")
                }
            }


        }
        Text(text = "result")
    }
}

@Preview(showBackground = true) //Use the @Preview annotation to mark the next function for preview
//To the @Preview annotation, add a parameter to show a background: showBackground = true.
//Observe how the preview now has a white background, making elements more readable.
@Composable
fun UnitConverterPreview() {
    UnitConverter() //This will allow us to preview the unitConverter Composable.
}
