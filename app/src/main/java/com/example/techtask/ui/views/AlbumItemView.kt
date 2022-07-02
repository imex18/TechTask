package com.example.techtask.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.techtask.R
import com.example.techtask.ui.AlbumListItem
import com.example.techtask.ui.theme.Typography

@Composable
fun AlbumItemView(modifier: Modifier = Modifier, albumItem: AlbumListItem, onFavouriteClicked: () -> Unit) {

    var isFavourite by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 5.dp),
        elevation = 2.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.LightGray
    ) {

        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row {
                Column {
                    Text(
                        text = "title:",
                        style = Typography.h1.copy(color = Color.Gray)
                    )
                    Text(
                        text = "id:",
                        style = Typography.body1.copy(color = Color.Gray)
                    )
                }

                Column(modifier = Modifier.padding(start = 5.dp)) {
                    Text(
                        text = albumItem.title,
                        style = Typography.h1
                    )
                    Text(
                        text = albumItem.id,
                        style = Typography.body1
                    )
                }
            }

            Icon(
                painter = if (isFavourite) painterResource(id = R.drawable.ic_baseline_favorite_24) else painterResource(
                    id = R.drawable.ic_baseline_favorite_border_24
                ),
                contentDescription = "",
                tint = if (isFavourite) Color.Black else Color.Gray,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .clickable {
                        isFavourite = !isFavourite
                        onFavouriteClicked()
                    }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AlbumItemView(albumItem = AlbumListItem(id = "1", title = "Nirvana")) {
    }
}