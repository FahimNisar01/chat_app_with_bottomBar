package com.example.chatui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juraj.fluid.R
import com.juraj.fluid.ui.theme.lightPurple
import com.juraj.fluid.ui.theme.purple


@Composable
fun PreviewItem() {
    LazyRow(content = {
        items(getItemData()) { it ->
            ItemView(img = it.img, name = it.name)
        }
    })


}

data class ItemData(val img: Int, val name: String)

@Composable
fun ItemView(img: Int, name: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(5.dp)) {

        Image(

            painter = painterResource(id = img),
            contentDescription = "image",
            modifier = Modifier
                .size(width = 80.dp, height = 100.dp)

        )


        Text(
            text = name,
            style = TextStyle(color = Color.White, fontSize = 10.sp)
        )
    }
}

@Composable
fun ChatItemView(img: Int, name: String, message: String, time: String, requests: Int) {

    Card(
//        elevation = .cardElevation(5.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(vertical = 5.dp),
        border = BorderStroke(1.dp, brush = Brush.horizontalGradient(colors = listOf(Color(0xFF444444), Color(0xFF7D7783))))


    ) {
        Box(modifier = Modifier.background(color =  Color(0xFF444444))) {

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = "chat",
                    modifier = Modifier
                        .size(width = 67.dp, height = 67.dp)

                )
                Spacer(modifier = Modifier.padding(5.dp))
                Column(modifier = Modifier.fillMaxWidth(0.8f)) {
                    Text(text = name, style = TextStyle(color = Color.White, fontSize = 14.sp))
                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        text = message,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(text = "$time min", style = TextStyle(color = lightPurple, fontSize = 14.sp))
                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        modifier = Modifier
                            .padding(1.dp)
                            .drawBehind {
                                drawCircle(
                                    color = lightPurple,
                                    radius = this.size.maxDimension
                                )
                            },
                        text = requests.toString(),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,

                            )
                    )
                }

            }
        }

    }

}

@Composable
fun PreviewChat() {

    LazyColumn(content = {
        items(getChatData()) { chatData ->
            ChatItemView(
                img = chatData.img,
                name = chatData.name,
                message = chatData.message,
                time = chatData.time,
                requests = chatData.request
            )

        }
    })
}

data class ChatDataClass(
    val img: Int,
    val name: String,
    val message: String,
    val time: String,
    val request: Int
)

fun getChatData(): MutableList<ChatDataClass> {
    val list = mutableListOf<ChatDataClass>()
    list.add(ChatDataClass(R.drawable.circle_yellow_girl, "Isabella", "What's Up", "4", 1))
    list.add(ChatDataClass(R.drawable.circle_off_glasses, "Michal", "What's Up", "8", 1))
    list.add(ChatDataClass(R.drawable.cirlce_color_glasses, "Bob", "What's Up", "9", 4))
    list.add(ChatDataClass(R.drawable.circle_yellow_girl, "Isabella", "What's Up", "4", 1))
    list.add(ChatDataClass(R.drawable.circle_off_glasses, "Michal", "What's Up", "8", 1))
    list.add(ChatDataClass(R.drawable.cirlce_color_glasses, "Bob", "What's Up", "9", 4))

    return list
}

fun getItemData(): MutableList<ItemData> {
    val list = mutableListOf<ItemData>()
    list.add(ItemData(R.drawable.girl_yrllow_back, "Isabella"))
    list.add(ItemData(R.drawable.boy_blue_back, "John"))
    list.add(ItemData(R.drawable.boy_blue_not, "Michal"))
    list.add(ItemData(R.drawable.boy_blue_back, "Bob"))
    list.add(ItemData(R.drawable.girl_yrllow_back, "Isabella"))
    list.add(ItemData(R.drawable.boy_blue_back, "John"))
    list.add(ItemData(R.drawable.boy_blue_not, "Michal"))
    list.add(ItemData(R.drawable.boy_blue_back, "Bob"))
    list.add(ItemData(R.drawable.girl_yrllow_back, "Isabella"))
    list.add(ItemData(R.drawable.boy_blue_back, "John"))
    list.add(ItemData(R.drawable.boy_blue_not, "Michal"))
    list.add(ItemData(R.drawable.boy_blue_back, "Bob"))
    return list
}
