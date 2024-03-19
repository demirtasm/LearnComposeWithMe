package md.learn.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
fun UnitConverter(){
    Column {
        //Here all the UI elements will be stacked below each other
        Text("Unit converter")
        
        OutlinedTextField(value ="" , onValueChange = {
            //Here goes what sould happen, when he value of our OutlinedTextField changes
        })
        Row {
            //Here all the UI elements will be stacked next each other
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Click Me")
                
            }

        }
        Text(text = "result")
    }
}

@Preview(showBackground = true) //Use the @Preview annotation to mark the next function for preview
//To the @Preview annotation, add a parameter to show a background: showBackground = true.
//Observe how the preview now has a white background, making elements more readable.
@Composable
fun UnitConverterPreview(){
    UnitConverter() //This will allow us to preview the unitConverter Composable.
}
