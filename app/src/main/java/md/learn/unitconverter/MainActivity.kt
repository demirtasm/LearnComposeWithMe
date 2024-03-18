package md.learn.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
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
        Greeting("Android")
        Greeting("Android")

        //Here all the UI elements will be stacked below each other
        Row {
            //Here all the UI elements will be stacked next each other

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
    UnitConverterTheme {
        Greeting("Android")
    }
}

/*
IIn the contex of Android's Compose framework, the specific annotation directs the compiler to interpret a function declaratively.
This approach signals the framework that the function declaratively. This approach signals he framework that he function is
indeed to define a segment of the user interface, facilitating boot composition and recomposition processes.
Composition refers to the initial rendering of the UI, while recomposition involves the dynamic redisplay orr recalibration
of the UI's presentation based on changes in data or state. This mechanism ensures an efficient d responsive user interface in Android application
 */