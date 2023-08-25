package com.example.treebuilder.ui.spider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.treebuilder.ui.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpiderMainScreen(
    mainViewModel: MainViewModel
) {
    LazyColumn {
        itemsIndexed(mainViewModel.tree) { index, match ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(15.dp)
                ) {
                Column (
                    modifier = Modifier.padding(top = 10.dp, start = 15.dp, end = 10.dp, bottom = 10.dp)
                ) {
                    Text("Match ${index + 1}", fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(bottom = 10.dp))
                    Text(
                        text = match.p1,
                        modifier = Modifier.padding(5.dp)
                    )
                    Text(
                        text = match.p2,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
        }
    }
}