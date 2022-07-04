package com.mrm.learningjetpackcompose.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrm.learningjetpackcompose.R

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserList()
        }
    }
}

/**
 * used to display the cards in the column (vertical list with scrollable)
 */
@Composable
fun UserList(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for (i in 1..10){
            UserCard()
        }
    }
}

/**
 * This method used to display single card
 */
@Composable
fun UserCard() {
    Card(
        elevation = 4.dp, modifier = Modifier
            .padding(12.dp)
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.secret),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.dummy_text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )
                Button(onClick = {
                    //Perform some button action
                }) {
                    Text(text = "View Profile")
                }
            }

        }

    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        UserCard()
    }
}