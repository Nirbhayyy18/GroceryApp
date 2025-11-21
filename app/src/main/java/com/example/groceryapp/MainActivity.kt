package com.example.groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            LazyColumnDemo()
        }
    }
}


@OptIn(ExperimentalFoundationApi::class) // Allow Using Sticky Headers
@Composable
fun LazyColumnDemo() {
    val groupedItems = mapOf(  // mapOf creates an immutable Map (key → value).
        "Fruites" to listOf(
            DataClass("Apple", "This is Apple", R.drawable.apple),
            DataClass("Banana", "This is Banana", R.drawable.banana),
            DataClass("Orange", "This is Orange", R.drawable.apple),
            DataClass("Grapes", "This is Grapes", R.drawable.banana),
            DataClass("Mango", "This is Mango", R.drawable.apple),
        ),
        "Vegetables" to listOf(
            DataClass("Apple", "This is Apple", R.drawable.apple),
            DataClass("Banana", "This is Banana", R.drawable.banana),
            DataClass("Orange", "This is Orange", R.drawable.apple),
            DataClass("Grapes", "This is Grapes", R.drawable.banana),
            DataClass("Mango", "This is Mango", R.drawable.apple),

        )
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        groupedItems.forEach { (header, itemss) ->
            stickyHeader {
                CustomHeader(header)
            }
            items(itemss){
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
            .background(Color.Green)
            .padding(8.dp)
            .fillMaxWidth()
    )
}

@Composable
fun CustomCard(mydata: DataClass)
{
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(mydata.Image),
                contentDescription = mydata.title,
                modifier = Modifier.fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = mydata.title,
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp)
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = mydata.desc,
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowApp(){
    LazyColumnDemo()
//    val item1 = DataClass("Apple", "This is Apple", R.drawable.apple)
//    CustomCard(item1)
}