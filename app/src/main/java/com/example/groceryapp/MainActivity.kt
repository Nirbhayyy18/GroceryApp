package com.example.groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {

        }
    }
}


@OptIn(ExperimentalFoundationApi::class) // Allow Using Sticky Headers
@Composable
fun LazyColumnDemo() {
    val groupedItems = mapOf(  // mapOf creates an immutable Map (key → value).
        "Fruites" to listOf("Apple", "Banana", "Cherry", "Mango", "Grapes", "WaterMelon"),
        "Vegetables" to listOf("Carrot", "Lettuce", "Tomato", "Onion", "Potato", "Eggplant")
    )

//    val myFruites = groupedItems["Fruites"]
//    val myVegetables = groupedItems["Vegetables"]

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        groupedItems.forEach { (header, items) ->
            stickyHeader {
                CustomHeader(header)
            }
            items(items){
                data->
                CustomCard(data)
            }
        }
    }
}

@Composable
fun CustomHeader(title: String)
{
    Text(
        text = title,
        fontSize = 32.sp,
        modifier = Modifier
            .background(Color.Red)
            .padding(8.dp)
            .fillMaxSize()
    )
}

@Composable
fun CustomCard(items: String)
{
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = items,
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowApp(){
    //LazyColumnDemo()
}