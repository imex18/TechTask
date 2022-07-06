package com.example.techtask.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.techtask.R
import com.example.techtask.ui.models.AlbumItem
import com.example.techtask.ui.theme.TechTaskColors
import com.example.techtask.ui.theme.Typography

@Composable
fun AlbumItemView(
    modifier: Modifier = Modifier,
    albumItem: AlbumItem,
    onFavouriteClicked: () -> Unit
) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 5.dp),
        shape = RoundedCornerShape(8.dp),
        color = Color.LightGray.copy(alpha = 0.8f)
    ) {
        Box(
            modifier = Modifier.padding(10.dp),
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(end = 30.dp)
            ) {
                Text(
                    text = "Title: ",
                    style = Typography.h1.copy(color = Color.Gray)
                )
                Text(
                    text = albumItem.title,
                    style = Typography.h1
                )
            }

            Icon(
                painter = if (albumItem.isFavourite) painterResource(id = R.drawable.ic_baseline_favorite_24) else painterResource(
                    id = R.drawable.ic_baseline_favorite_border_24
                ),
                contentDescription = "",
                tint = TechTaskColors.GreyBlue700,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .clip(shape = RoundedCornerShape(5.dp))
                    .clickable {
                        onFavouriteClicked()
                    }
            )
        }
    }
}
