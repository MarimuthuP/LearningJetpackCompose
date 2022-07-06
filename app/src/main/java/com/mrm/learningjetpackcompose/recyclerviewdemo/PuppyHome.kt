package com.mrm.learningjetpackcompose.recyclerviewdemo

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.mrm.learningjetpackcompose.recyclerviewdemo.data.DataProvider
import com.mrm.learningjetpackcompose.recyclerviewdemo.data.Puppy


@Composable
fun PuppyHomeContent(navigateToProfile: (Puppy) -> Unit) {
    val puppies = remember { DataProvider.puppyList }
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(items = puppies, itemContent = {
            PuppyListItem(it, navigateToProfile)
        })
    }
}