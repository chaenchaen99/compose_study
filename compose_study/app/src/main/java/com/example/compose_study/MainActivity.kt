package com.example.compose_study

import android.graphics.drawable.Icon
import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_studyTheme {
        CardEx(cardData = cardData)
    }
}