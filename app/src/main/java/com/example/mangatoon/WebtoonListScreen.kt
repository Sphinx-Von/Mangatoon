package com.example.mangatoon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.mangatoon.ui.theme.Anti_Flash_White
import com.example.mangatoon.ui.theme.Cornflower_Blue
import com.example.mangatoon.ui.theme.Periwinkle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebtoonListScreen(
    webtoons : List<Webtoon>,
    onWebtoonClick: (Webtoon) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mangatoon") },
                navigationIcon = {
                                 IconButton(onClick = {onBackClick()}) {
                                     Icon(Icons.Filled.ArrowForward,
                                         contentDescription = "Back")
                                 }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Cornflower_Blue // Customize the background color here
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(Anti_Flash_White)
                .padding(8.dp)
        ){
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(webtoons) { webtoon ->
                    WebtoonItem(webtoon = webtoon, onClick = onWebtoonClick)


                }

            }
        }


    }
}

@Composable
fun WebtoonItem(webtoon: Webtoon, onClick:(Webtoon) -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(webtoon) },
        colors = CardDefaults.cardColors(containerColor = Periwinkle)
    ){
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                rememberAsyncImagePainter(model = webtoon.imageUrl,
                        placeholder = painterResource(id = R.drawable.placeholder_image),
                   error =  painterResource(id = R.drawable.error_image)),
                contentDescription = webtoon.title,
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = webtoon.title,
                    style = MaterialTheme.typography.titleMedium)
                Text(text = webtoon.description,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                    )
            }

        }
    }
}

@Preview
@Composable
fun PreviewWebtoonListScreen() {
    WebtoonListScreen(
        webtoons = getWebtoons(),  // Sample data for preview
        onWebtoonClick = {} , onBackClick = {} // Empty click handler for preview
    )
}
