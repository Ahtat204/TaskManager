package com.lahcen.taskmanager.components
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.R)
@Preview(showSystemUi = true, device = "spec:parent=pixel_5,navigation=gesture")
@Composable
fun MiddleTopScreen(modifier: Modifier = Modifier) {

    val taskBackground=Color(0xFF20207C)


Column(
            modifier = Modifier.offset(20.dp,70.dp).padding(0.dp,60.dp)
        ) {


            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 57.dp),
            ) {
                items(10) {
                    //TaskItem(task = tasklist[it])

                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(taskBackground)
                            .fillMaxWidth()
                            .padding(70.dp, 70.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "tasklist[it].title", color = Color.White, style = MaterialTheme.typography.titleLarge)



                        IconButton(onClick={},modifier=Modifier) {
                            Image(
                                contentDescription = null,
                                imageVector = Icons.Rounded.Create,
                                contentScale = ContentScale.Crop,
                                colorFilter = ColorFilter.tint(Color.White))
                        }
                    }

                }
            }
        }

}
