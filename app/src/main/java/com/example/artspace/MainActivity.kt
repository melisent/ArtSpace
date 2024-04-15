package com.example.artspace

import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
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

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayout() {


    var artTitleId: Int = R.string.art_title_1
    var authorYearIdId: Int = R.string.art_author_year_1


    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtImage(
            artId = R.drawable.art1,
            artTitleId = artTitleId
        )

        ArtInfo(
            artTitleId = artTitleId,
            authorYearId = authorYearIdId
        )

        ActionButtons(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                )

    }
}

@Composable
fun ArtImage(
    @DrawableRes artId: Int,
    @StringRes artTitleId: Int,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier,
        shape = RectangleShape,
        shadowElevation = 16.dp
    ) {
        Image(
            painter = painterResource(artId),
            contentDescription = stringResource(artTitleId),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ArtInfo(
    @StringRes artTitleId: Int,
    @StringRes authorYearId: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Text(
            text = stringResource(artTitleId),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier
            .padding(5.dp))

        Text(
            text = stringResource(authorYearId),
            fontStyle = FontStyle.Italic,
            fontSize = 15.sp)

    }

}

@Composable
fun ActionButtons(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(32.dp)) {

        Button(
            onClick = { /*TODO*/ },
            content = { Text(text = "Previous") },
            modifier = Modifier
                .weight(1f)
        )

        Button(
            onClick = { /*TODO*/ },
            content = { Text(text = "Next") },
            modifier = Modifier.weight(1f)
        )

    }
}

