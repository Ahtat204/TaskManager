package com.lahcen.taskmanager.components
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lahcen.taskmanager.model.TaskViewModel
import com.lahcen.taskmanager.model.data.Task
import kotlin.math.abs

@RequiresApi(Build.VERSION_CODES.R)
//@Preview(showSystemUi = true, device = "spec:parent=pixel_5,navigation=gesture")
@Composable
fun MiddleTopScreen(modifier: Modifier = Modifier,taskViewModel: TaskViewModel) {
    val PopUpScreen:Boolean by remember{ mutableStateOf(false) }
    val taskList by taskViewModel.allTask.observeAsState(listOf(Task("","task2")))

    Column(
            modifier = Modifier
                .offset(20.dp, 45.dp)
                .padding(0.dp, 60.dp)
    ){
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 97.dp),
            ) {
                items(abs(taskList.size)) {item->
                  // TaskCard (task =taskList[item],modify = {taskViewModel.updateTask(taskList[item])}, delete = {taskViewModel.deletetask(taskList[item])},isVisible = PopUpScreen)
//////////////////////////////////////////////////



                    Box(
                        contentAlignment = Alignment.TopStart,
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.Blue)
                            .fillMaxWidth()
                            .padding(70.dp, 70.dp)
                            .clickable {
                                PopUpScreen != PopUpScreen
                                Log.d("task list", PopUpScreen.toString())
                            }
                    ) {
                       Button(onClick = {}, modifier = Modifier
                           .offset(0.dp, 0.dp)
                           .fillMaxSize()) {


                       }


                    }




///////////////////////////////////////////////
                    AnimatedVisibility(visible = PopUpScreen, enter = fadeIn(), exit = fadeOut()) {

                        Column(modifier = Modifier
                            .fillMaxHeight(0.5f)
                            .fillMaxWidth()
                            .background(Color.Blue), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "task.Title",
                                modifier = Modifier.border(width = 1.dp, color = Color.White),
                                fontSize = 25.sp,
                                color = Color.White
                            )
                            Spacer(Modifier.height(40.dp))
                            Text(textAlign = TextAlign.Center,text = "Task.description Task.descriptionTask.descriptionTask.descriptionTask.descriptionTask.descriptionTask.description",
                                fontSize = 10.sp, color = Color.White, modifier = Modifier
                                    .offset(0.dp, 0.dp)
                                    .border(width = 1.dp, color = Color.White))
                            Spacer(Modifier.height(40.dp))
                            Row {
                                Text(
                                    text = "task.category",
                                    modifier = Modifier
                                        .border(width = 1.dp, color = Color.White)
                                        .offset(0.dp, 0.dp),
                                    fontSize = 29.sp,
                                    color = Color.White
                                )
                                Spacer(Modifier.width(20.dp))
                                Text(
                                    text = "task.priority",
                                    modifier = Modifier
                                        .border(width = 1.dp, color = Color.White)
                                        .offset(0.dp, 0.dp),
                                    fontSize = 29.sp,
                                    color = Color.White
                                )
                            }
                        }



                    }
                }
            }
        }

}


@Composable
fun TaskCard(task: Task,modify: () -> Unit,delete:()->Unit,isVisible:Boolean) {
    val taskBackground = Color(0xFF156CD0)

    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(taskBackground)
            .fillMaxWidth()
            .padding(70.dp, 70.dp)
            .clickable {
                isVisible != isVisible
                Log.d("task list", isVisible.toString())
            }
    ) {

        Text(
            textDecoration = TextDecoration.Underline,
            text = task.title,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(0.dp, (-30).dp)
        )
        IconButton(
            onClick = modify, modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(49.dp, (-60).dp)
        ) {
            Image(
                contentDescription = null,
                imageVector = Icons.Rounded.Create,
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
        IconButton(
            onClick = delete, modifier = Modifier.offset((-50).dp, (-60).dp)
        ) {
            Image(
                contentDescription = null,
                imageVector = Icons.Rounded.Delete,
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
        Text(
            task.description.toString(),
            fontSize = 10.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .width(130.dp),maxLines=1, overflow = TextOverflow.Ellipsis

        )
        Text(
           text = if(task.priority==null)
           {""}else{
               task.priority.toString()
                   } ,
            fontSize = 10.sp,
            color = Color.Green,
            modifier = Modifier
                .offset(40.dp, 50.dp)
                .align(Alignment.BottomEnd),maxLines=1, overflow = TextOverflow.Ellipsis, softWrap = true, letterSpacing = TextUnit(1f,
                TextUnitType(11)
            )
        )
        Text(
           text =
           if(task.category==null){
               ""
           } else{
               task.category.toString()
           }
            ,
            fontSize = 10.sp,
            color = Color.Green,
            modifier = Modifier
                .offset((-30).dp, 50.dp)
                .align(Alignment.BottomStart),maxLines=1, overflow = TextOverflow.Ellipsis, softWrap = true, letterSpacing = TextUnit(1f,
                TextUnitType(11)
            )
        )
    }


}
/*
@Composable
private fun ShowTaskDetails(isOpen: Boolean ){
AnimatedVisibility(visible = isOpen, enter = fadeIn() , exit = fadeOut()  ) { }
     Column(modifier = Modifier
         .fillMaxHeight(0.5f)
         .background(Color.Blue), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
         Text(
             text = "task.Title",
             modifier = Modifier.border(width = 1.dp, color = Color.White),
             fontSize = 25.sp,
             color = Color.White
         )
         Spacer(Modifier.height(40.dp))
         Text(textAlign = TextAlign.Center,text = "Task.description Task.descriptionTask.descriptionTask.descriptionTask.descriptionTask.descriptionTask.description",
             fontSize = 10.sp, color = Color.White, modifier = Modifier
                 .offset(0.dp, 0.dp)
                 .border(width = 1.dp, color = Color.White))
         Spacer(Modifier.height(40.dp))
         Row {
             Text(
                 text = "task.category",
                 modifier = Modifier
                     .border(width = 1.dp, color = Color.White)
                     .offset(0.dp, 0.dp),
                 fontSize = 29.sp,
                 color = Color.White
             )
             Spacer(Modifier.width(20.dp))
             Text(
                 text = "task.priority",
                 modifier = Modifier
                     .border(width = 1.dp, color = Color.White)
                     .offset(0.dp, 0.dp),
                 fontSize = 29.sp,
                 color = Color.White
             )
         }
     }
     
 }
       */


