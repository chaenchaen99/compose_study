package com.example.compose_study

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.allowHardware
import coil3.request.crossfade
import com.example.compose_study.MainActivity.Companion.cardData
import com.example.compose_study.ui.theme.Compose_studyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_studyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview()
                }
            }
        }
    }

    companion object {
        val cardData = ProfileCard(
            imageUrl = "https://cdn.blueconomy.co.kr/news/photo/202402/2399_3001_921.png",
            imageDescription = "귀여운 해달",
            author = "00기자",
            description = "귀여운 해달은 조개를 까먹고 있다."
        )
    }
}

@Composable
fun BoxEx() {
    //Box
    // 자식 요소를 겹치거나, 특정 위치에 배치할 때 사용
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Gray)
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.Cyan)
                .align(Alignment.CenterStart)
        )
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.Yellow)
                .align(Alignment.BottomEnd)
        )
    }

    //contentAlignment 사용 예시
    Box(
        modifier = Modifier
            .height(150.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.BottomEnd
    ) {
        Text(text = "Aligned Text", color = Color.White)
    }
}

@Composable
fun RowEx() {
    //수평으로 자식 컴포저블을 배치

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.size(width = 200.dp, height = 100.dp),
        verticalAlignment = Alignment.Bottom,
    ) {
        //weight : 비율이 2:3:2로 설정됨
        Text(
            text = "first",
            modifier = Modifier
                .align(Alignment.Top)
                .weight(2f),
            textAlign = TextAlign.End
        )
        Text(text = "second", modifier = Modifier.weight(3f))
        Icon(
            imageVector = Icons.Filled.CheckCircle, // 명확하게 아이콘을 지정
            contentDescription = null, // 접근성이 필요 없다면 null
            modifier = Modifier.weight(2f)
        )
        Text(text = "third", modifier = Modifier.weight(2f))

    }
}

@Composable
fun ColumnEx() {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.size(100.dp)
    ) {
        Text(text = "first")
        Text(text = "second")
        Text(text = "third")
    }
}

@Composable
fun ImageEx() {
    Image(painter = painterResource(id = R.drawable.review_stars), contentDescription = "별")
    Image(imageVector = Icons.Filled.Settings, contentDescription = "세팅")
}

@Composable
fun ComposeEx() {
    AsyncImage(
        model = "https://cdn.blueconomy.co.kr/news/photo/202402/2399_3001_921.png",
        contentDescription = "귀여운 해달",
    )

    val context = LocalContext.current
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data("https://cdn.blueconomy.co.kr/news/photo/202402/2399_3001_921.png")
            .crossfade(true)
            .allowHardware(false)
            .build(),
    )

    val state by painter.state.collectAsState()
    when (state) {
        is AsyncImagePainter.State.Loading -> {
            CircularProgressIndicator() // 로딩 중 표시
        }

        is AsyncImagePainter.State.Error -> {
            Text("Failed to load image") // 오류 시 표시
        }

        else -> {
            Image(
                painter = painter,
                contentDescription = "Loaded Image",
                modifier = Modifier
            )
        }
    }
}

@Composable
fun TextfieldEx() {
    var name by remember { mutableStateOf("Tom") }
    //mutableStateOf
    //name의 상태를 관리하는 객체를 생성
    //by 키워드를 통해 name의 상태를 읽고 쓸 수 있게 해준다.

    Column {
        TextField(value = name, onValueChange = { name = it })
        Text(text = "Hello $name")
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldEx() {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로가기",
                        )
                    }
                },
                title = {
                    Text(text = "Scaffold App")

                }
            )
        }
    ) {
        Surface(modifier = Modifier.padding(8.dp)) {

        }
    }
}

@Composable
fun CanvasEx() {
    Canvas(modifier = Modifier.size(20.dp)) {
        //1.drawLine
        drawLine(Color.Red, Offset(30f, 10f), Offset(50f, 40f))

        //2.drwaCircle
        drawCircle(Color.Yellow, 30f, Offset(15f, 15f))


    }
}

@Composable
fun DialogEx() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = true }) {
            Text("다이어로그 열기")
        }
        Text("카운터: $counter")
    }

    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                openDialog = false
            },
            confirmButton = {
                Button(onClick = {
                    counter++
                    openDialog = false
                }) {
                    Text("더하기")
                }
            },
            dismissButton = {
                Button(onClick = {
                    openDialog = false
                }) {
                    Text("취소")
                }
            },
            title = {
                    Text("더하기")
            }, text = {
                Text("더하기 버튼을 누르면 카운터를 증가합니다.\n버튼을 눌러주세요.")
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_studyTheme {
        DialogEx()
    }
}