package com.lahcen.taskmanager.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.sharp.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lahcen.taskmanager.R
import com.lahcen.taskmanager.ui.theme.opensansExtraBold
import com.lahcen.taskmanager.ui.theme.opensansbold

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TopScreen(modifier: Modifier = Modifier) {
    var name: String by remember { mutableStateOf("Lahcen") }
    var task: String by remember { mutableStateOf("") }
    Box(
        Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(Color.Black)
            .fillMaxHeight(0.3f)
            .wrapContentHeight(Alignment.Top)
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(x = 40.dp)
                        .align(Alignment.CenterVertically),
                )
                Text(
                    text = "Welcome \n $name",
                    fontFamily = opensansbold,
                    color = Color.White,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                IconButton(modifier = Modifier.padding(10.dp), onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Outlined.Notifications, contentDescription = null, tint = Color.White
                    )

                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(value = "",
                    modifier = Modifier.padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(20.dp),
                    onValueChange = { task = it },
                    placeholder = { Text("Search for a task", color = Color.White) })
                IconButton(
                    onClick = {}, modifier = Modifier.offset(x = (-10).dp)
                ) {
                    Icon(
                        Icons.Rounded.Settings, contentDescription = null, tint = Color.White
                    )
                }
            }
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Your Tasks",
                    color = Color.White,
                    fontFamily = opensansExtraBold,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "see all",
                        color = Color.White,
                        modifier = Modifier,
                        fontFamily = FontFamily(Font(R.font.opensansbold))
                    )
                }
            }
        }
    }
}