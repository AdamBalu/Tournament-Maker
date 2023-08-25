package com.example.treebuilder.ui.spider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.treebuilder.ui.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOfPlayers(
    mainViewModel: MainViewModel,
    onCreateSpider: () -> Unit
) {
    LazyColumn {
        itemsIndexed(mainViewModel.contestants) { index, contestant ->
            var player by remember { mutableStateOf(contestant) }
            Row {
                TextField(
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    value = player,
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = {
                        player = it
                        mainViewModel.changePlayerName(index, it)
                    },
                    leadingIcon = { Icon(Icons.Default.Edit, contentDescription = null, tint = Color(0xFF1759BD)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, top = 8.dp, bottom = 8.dp)
                )
            }
        }
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        mainViewModel.generateTree()
                        onCreateSpider()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 70.dp, end = 70.dp)
                ) {
                    Text("Create Matches")
                }
            }
        }
    }
}
