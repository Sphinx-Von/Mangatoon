package com.example.mangatoon


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mangatoon.ui.theme.Anti_Flash_White
import com.example.mangatoon.ui.theme.Cornflower_Blue
import com.example.mangatoon.ui.theme.Periwinkle
import com.example.mangatoon.ui.theme.UT_Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(viewModel: WebtoonViewModel,

                   onBackClick: () -> Unit){
    val favorites = viewModel.favorites.collectAsState(initial = emptyList())
Scaffold(
    topBar = {
        TopAppBar(
            title = {Text("Favourite Webtoons")},
            navigationIcon = {
                             IconButton(onClick = {onBackClick()}){
                                 Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                             }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Cornflower_Blue
            )
        )
    }
){
    paddingValues ->
    if(favorites.value.isEmpty()){
        Text(text = "No favorite webtoons yet.",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
            )
    }else{
        LazyColumn(modifier = Modifier.padding(paddingValues)){
            items(favorites.value){
                    webtoon ->
                WebtoonItem(webtoon = webtoon, onRemove =  {
                    viewModel.removeFavorite(it)

                })
            }

        }
    }

}

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebtoonItem(webtoon: WebtoonEntity, onRemove:(WebtoonEntity) -> Unit){

    // Dismiss state to manage swipe action
    val dismissState = rememberDismissState()
    SwipeToDismiss(state = dismissState,
        directions = setOf(DismissDirection.EndToStart),
        background = {
                     Box(
                         modifier = Modifier
                             .fillMaxSize()
                             .background(Anti_Flash_White)
                     ){
                         Text(text = "Remove",
                             modifier = Modifier.align(Alignment.CenterEnd).padding(16.dp),
                             color = Color.Black)
                     }
        },
        dismissContent = {
            // the card will be dismissed
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onRemove(webtoon) } ,
                colors = CardDefaults.cardColors(containerColor = Periwinkle)
            // Handle item click if necessary
            ){
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        rememberAsyncImagePainter(model = webtoon.imageUrl, // loading image from entity
                            placeholder = painterResource(id = R.drawable.placeholder_image),
                            error =  painterResource(id = R.drawable.error_image)
                        ),
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
        })
    // Handle dismissal
    LaunchedEffect(dismissState.isDismissed(DismissDirection.EndToStart)) {
        if (dismissState.isDismissed(DismissDirection.EndToStart)) {
            onRemove(webtoon) // Call the onRemove function when swiped
        }
    }

}