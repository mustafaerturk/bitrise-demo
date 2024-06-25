package com.bitrise.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bitrise.demo.GreetingProvider
import com.bitrise.demo.domain.MainViewModel
import com.bitrise.demo.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val titleState = viewModel.titleList.collectAsState()
                    Column {
                        Greeting(
                            name = GreetingProvider.title(),
                            modifier = Modifier.padding(innerPadding)
                        )

                        Button(
                            onClick = {
                                viewModel.fetch()
                            }
                        ) {
                            Text(
                                text = "Fetch Title",
                                modifier = Modifier.clearAndSetSemantics { },
                                textAlign = TextAlign.Center,
                                maxLines = 2
                            )
                        }

                        MessageList(titleState.value)
                    }
                }
            }
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


@Composable
fun MessageList(items: List<String>, onItemClick: () -> Unit = {}) {
    val listState = rememberLazyListState()

    LazyColumn(state = listState) {
        items(items.size) { index ->
            MessageItem(items[index], onItemClick)
        }
    }
}


@Composable
fun MessageItem(item: String, onItemClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Message #$item", Modifier.padding(end = 16.dp))
    }
}

@Preview(widthDp = 500)
@Composable
fun MessageListPreview() {
    MessageList(emptyList(), onItemClick = {})
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
        MessageList(listOf("1", "1", "1", "1", "1", "1", "1", "1", "1"))
    }
}
