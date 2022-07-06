package com.mrm.learningjetpackcompose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrm.learningjetpackcompose.cardview.CardViewActivity
import com.mrm.learningjetpackcompose.image.ImageActivity
import com.mrm.learningjetpackcompose.recyclerviewdemo.RecyclerViewDemoActivity
import com.mrm.learningjetpackcompose.text.SimpleTextActivity
import com.mrm.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewList()
        }
    }
}

@Composable
fun ViewList() {
    LazyColumn {
        items(views) { view ->
            TitleForTextView(title = view.title, type = view.type)
        }
    }
}

@Composable
fun TitleForTextView(title: String, type: CategoryType) {

    val context = LocalContext.current
    val shape = RoundedCornerShape(8.dp)
    val shadowElevationPx = with(LocalDensity.current) { 2.dp.toPx() }
    val backgroundColor = MaterialTheme.colors.primarySurface

    Text(
        text = title,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, MaterialTheme.colors.secondary, shape = shape)
            .graphicsLayer(shape = shape, shadowElevation = shadowElevationPx)
            .background(backgroundColor, shape = shape)
            .padding(10.dp)
            .clickable {
                when (type) {
                    CategoryType.SIMPLE_TEXT -> context.startActivity(
                        Intent(
                            context,
                            SimpleTextActivity::class.java
                        )
                    )
                    CategoryType.CARD_VIEW -> context.startActivity(
                        Intent(
                            context,
                            ImageActivity::class.java
                        )
                    )
                    CategoryType.RECYCLER_VIEW -> context.startActivity(
                        Intent(
                            context,
                            RecyclerViewDemoActivity::class.java
                        )
                    )
                    CategoryType.CARD_VIEW_ANIMATION -> context.startActivity(
                        Intent(
                            context,
                            CardViewActivity::class.java
                        )
                    )
                    CategoryType.BUTTONS -> simpleToast(context, "Buttons")
                }

            }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearningJetpackComposeTheme {
        ViewList()
    }
}

data class ViewTitle(val title: String, val type: CategoryType)

val views = listOf(
    ViewTitle("Simple TextView", CategoryType.SIMPLE_TEXT),
    ViewTitle("CardView with image and button", CategoryType.CARD_VIEW),
    ViewTitle("RecyclerView", CategoryType.RECYCLER_VIEW),
    ViewTitle("Buttons", CategoryType.BUTTONS),
    ViewTitle("CardView with animation", CategoryType.CARD_VIEW_ANIMATION)
)

enum class CategoryType {
    SIMPLE_TEXT, CARD_VIEW, RECYCLER_VIEW, BUTTONS, CARD_VIEW_ANIMATION
}

fun simpleToast(context: Context, message: String) {
    Toast
        .makeText(context, message, Toast.LENGTH_LONG)
        .show()
}