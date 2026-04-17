package com.example.myfirstapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

private val sampleItems = listOf("Apple", "Banana", "Cherry", "Date", "Elderberry")

@Composable
fun HomeScreen(onLogout: () -> Unit) {
    var counter by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Welcome, admin!",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(bottom = 24.dp)
                .testTag("welcomeText")
        )

        // Counter section
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Counter",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$counter",
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.testTag("counterValue")
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Button(
                        onClick = { counter-- },
                        modifier = Modifier.testTag("decrementButton")
                    ) {
                        Text("-")
                    }
                    Button(
                        onClick = { counter++ },
                        modifier = Modifier.testTag("incrementButton")
                    ) {
                        Text("+")
                    }
                }
            }
        }

        // Item list section
        Text(
            text = "Fruits",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .testTag("itemList"),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(sampleItems) { index, item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("listItem_$index")
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onLogout,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            ),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("logoutButton")
        ) {
            Text("Logout")
        }
    }
}
