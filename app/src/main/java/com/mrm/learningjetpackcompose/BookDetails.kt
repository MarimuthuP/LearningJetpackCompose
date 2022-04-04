package com.mrm.learningjetpackcompose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BookDetails(){
    BookInfo(Book("Who will cry when you die!", "Robin Sharma"))
}

@Composable
fun BookInfo(book: Book) {
    Row(modifier = Modifier.padding(all = 8.dp)){
        Image(
            painter = painterResource(id = R.drawable.secret),
            contentDescription = "book cover picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(0.5.dp, MaterialTheme.colors.primary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = book.title,
                fontStyle = FontStyle.Normal,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = book.author,
                modifier = Modifier.padding(4.dp),
                fontStyle = FontStyle.Italic,
                fontSize = 12.sp,
                style = MaterialTheme.typography.subtitle1

            )
        }
    }

}


data class Book(val title: String, val author: String)

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun BookInfoPreview(){
    BookInfo(Book("Secrets", "The God"))
}