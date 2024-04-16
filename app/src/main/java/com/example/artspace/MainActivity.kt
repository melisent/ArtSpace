package com.example.artspace

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@SuppressLint("AutoboxingStateCreation")
@Preview(showBackground = true)
@Composable
fun ArtSpaceLayout() {

    var counter by remember { mutableStateOf(1) }

    var artTitleId by remember { mutableStateOf(R.string.art_title_1) }
    var authorYearIdId by remember { mutableStateOf(R.string.art_author_year_1) }
    var artId by remember { mutableStateOf(R.drawable.art1) }


    when (counter) {
        1 -> {
            artId = R.drawable.art1
            artTitleId = R.string.art_title_1
            authorYearIdId = R.string.art_author_year_1
        }

        2 -> {
            artId = R.drawable.art2
            artTitleId = R.string.art_title_2
            authorYearIdId = R.string.art_author_year_2
        }

        3 -> {
            artId = R.drawable.art3
            artTitleId = R.string.art_title_3
            authorYearIdId = R.string.art_author_year_3
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.fillMaxHeight(0.6f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            ArtImage(
                artId = artId,
                artTitleId = artTitleId,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )

            ArtInfo(
                artTitleId = artTitleId,
                authorYearId = authorYearIdId
            )
        }

        Column(
            verticalArrangement = Arrangement.Bottom
        ) {
            ActionButtons(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                onPreviousClick = { counter-- },
                onNextClick = { counter++ },
                previousButtonEnabled = counter > 1,
                nextButtonEnabled = counter < 3
            )
        }


    }

}

@Composable
fun ArtImage(
    @DrawableRes artId: Int,
    @StringRes artTitleId: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RectangleShape,
        shadowElevation = 16.dp
    ) {
        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(artId),
            contentDescription = stringResource(artTitleId),
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun ArtInfo(
    @StringRes artTitleId: Int,
    @StringRes authorYearId: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(artTitleId),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        Spacer(
            modifier = Modifier
                .padding(5.dp)
        )

        Text(
            text = stringResource(authorYearId),
            fontStyle = FontStyle.Italic,
            fontSize = 15.sp
        )

    }

}

@Composable
fun ActionButtons(
    modifier: Modifier = Modifier,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    previousButtonEnabled: Boolean = true,
    nextButtonEnabled: Boolean = true
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {

        Button(
            enabled = previousButtonEnabled,
            onClick = onPreviousClick,
            content = { Text(text = "Previous") },
            modifier = Modifier
                .weight(1f)
        )

        Button(
            enabled = nextButtonEnabled,
            onClick = onNextClick,
            content = { Text(text = "Next") },
            modifier = Modifier.weight(1f)
        )

    }
}

