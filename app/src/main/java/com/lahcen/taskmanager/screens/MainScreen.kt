package com.lahcen.taskmanager.screens
import android.os.Build
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lahcen.taskmanager.R
import com.lahcen.taskmanager.model.TaskViewModel
import com.lahcen.taskmanager.model.data.Task
import com.lahcen.taskmanager.ui.theme.opensansExtraBold
import com.lahcen.taskmanager.ui.theme.opensansbold
@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun Mainscreen(taskViewModel: TaskViewModel) {
    val taskBackground=Color(0xFF20207C)
    val SeeAll = Color(0xFFFFC300)
    var name: String by remember { mutableStateOf("Lahcen") }
    var task: String by remember { mutableStateOf("") }
    var ShowDialog by remember { mutableStateOf(false) }
        LocalContext.current.getSystemService(WindowManager::class.java).currentWindowMetrics
    var descrption: String by remember { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    val tasklist by taskViewModel.allTask.observeAsState(emptyList())
    fun insertTask(taskname: String, taskdescription: String) {
        taskViewModel.inserttask(Task(title = taskname, description = taskdescription))
        ShowDialog = false
    }
    Box(
        Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(Color.Black)
            .fillMaxHeight(0.3f)
            .wrapContentHeight(Alignment.Top)
    ) {
        Column(Modifier.offset(y = 4.dp)) {
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
                    text = "Your Progress",
                    color = Color.White,
                    fontFamily = opensansExtraBold,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "see More",
                        color = Color.White,
                        modifier = Modifier,
                        fontFamily = FontFamily(Font(R.font.opensansbold))
                    )
                }
            }
        }
    }

    Box(
        Modifier
            .fillMaxWidth()
            .offset(0.dp, 80.dp)
            .padding(vertical = 110.dp, horizontal = 1.dp)
            .fillMaxHeight(0.92f)
            .background(Color(0xFF111162))
    ) {
        Text(
            text = "All Tasks",
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.opensansbold)),
            color = Color.White,
            modifier = Modifier.padding(17.dp, 15.dp)
        )
        TextButton(onClick = { if (!ShowDialog) ShowDialog = true else null}, modifier = Modifier
            .offset(0.dp)
            .align(Alignment.TopEnd)) {
            Text(
                "Add",
                fontSize = 20.sp,
                color = SeeAll,
                fontStyle = FontStyle.Companion.Italic,
                fontFamily = FontFamily(Font(R.font.opensansbold)),
                modifier = Modifier
                    .padding(10.dp, 10.dp)
                    .offset(x = 10.dp)
            )
        }
        Column(
            modifier = Modifier.offset()
        ) {

///////////////////////////////////////////////////
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 57.dp),
            ) {
                items(tasklist.size) {
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
                        Text(text = tasklist[it].title, color = Color.White, style = MaterialTheme.typography.titleLarge)
                        tasklist[it].description?.let {
                            Text(
                                text = it, style = MaterialTheme.typography.bodyMedium, color = Color.White
                            )
                        }
                        IconButton(onClick = {taskViewModel.deletetask(tasklist[it])}) {
                            Image(
                                contentDescription = null,
                                imageVector = Icons.Rounded.Delete,
                                contentScale = ContentScale.Crop,
                                colorFilter = ColorFilter.tint(Color.White)
                            )
                        }

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


        AnimatedVisibility(
            visible = ShowDialog,
            enter = fadeIn() + fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF111162))
            ) {
                OutlinedTextField(
                    modifier = Modifier.offset(20.dp),
                    value = task,
                    onValueChange = { task = it },
                    label = { Text("Task name") },
                    placeholder = { Text("write the task here") },
                    shape = RoundedCornerShape(20.dp),
                    suffix = { Text("Title") },
                    isError = isError,
                )


                OutlinedTextField(
                    modifier = Modifier
                        .offset(20.dp, 70.dp)
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight(0.8f),
                    value = descrption,
                    onValueChange = { descrption = it },
                    label = { Text("Task Description") },
                    placeholder = { Text("write the task here") },
                    shape = RoundedCornerShape(20.dp),
                    suffix = { Text("details") },
                    enabled = true,

                    )
                if (descrption.isEmpty() || task.isEmpty()) {
                    IconButton(
                        onClick = { ShowDialog = false },
                        modifier = Modifier.offset(360.dp, 10.dp),
                        colors = IconButtonColors(
                            Color.Black, Color.White, Color.Yellow, Color.Green
                        )
                    ) {
                        Icon(
                            Icons.Rounded.Clear,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                } else {
                    IconButton(
                        onClick = { insertTask(task, descrption) },
                        modifier = Modifier
                            .offset()
                            .align(Alignment.TopEnd),
                        colors = IconButtonColors(
                            Color.Black, Color.White, Color.Yellow, Color.Green
                        )
                    ) {
                        Icon(
                            Icons.Rounded.AddCircle,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }

}





