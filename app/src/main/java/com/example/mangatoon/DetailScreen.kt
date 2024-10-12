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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.mangatoon.ui.theme.Periwinkle
import com.example.mangatoon.ui.theme.Purple80
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(webtoon: Webtoon,
                 onAddFavorite: (WebtoonEntity) -> Unit,
                 viewModel: WebtoonViewModel,
                 onBackClick: () -> Unit){
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val scrollstate = rememberScrollState()
    var userRating by remember { mutableStateOf(0) }
    var averageRating by remember{ mutableStateOf(4.0) }
    var totalRatings by remember{ mutableStateOf(100) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = webtoon.title) },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Periwinkle // Customize top bar color
                )
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) } // Add SnackbarHost to show messages
    ){
        paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)){
        // Display larger image
        Image( rememberAsyncImagePainter(model = webtoon.imageUrl,
            placeholder = painterResource(id = R.drawable.placeholder_image),
            error =  painterResource(id = R.drawable.error_image)
        ),
            contentDescription = webtoon.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Purple80)
        )

        //

        // Description
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .weight(1f)
                    .verticalScroll(scrollstate)
            ){
                Column {
                    Text(text = webtoon.title,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    // Dynamic Average Rating Display
                    Text(
                        text = "Average Rating: %.1f/5".format(averageRating),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "Total Ratings: $totalRatings",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        repeat(5) { index ->
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = "Rate",
                                tint = if (index < userRating) Color.Yellow else Color.Gray,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clickable {
                                        userRating = index + 1
                                        // Update average rating dynamically
                                        averageRating =
                                            ((averageRating * totalRatings + userRating) / (totalRatings + 1))
                                        totalRatings += 1
                                    }
                            )
                        }
                        Text(
                            text = "$userRating/5",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }





                    Spacer(modifier = Modifier.height(16.dp))
                    //Description Starts here
                    Text(text = webtoon.description,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Button(onClick = {
                        val webtoonEntity = WebtoonEntity(
                            id = webtoon.id,
                            title = webtoon.title,
                            imageUrl = webtoon.imageUrl,
                            description = webtoon.description
                        )
                        onAddFavorite(webtoonEntity)
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "${webtoon.title} added to favorites",
                                duration = SnackbarDuration.Short
                            )
                        }

                    },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text(text = "Add to Favorites")
                    }
                }

            }


        // Add to Favorites Button

    }

    }

}


