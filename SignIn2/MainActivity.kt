package com.example.signin2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           SignInScreen()
        }
    }
}

@Composable
fun SignInScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color =  Color.Black)
            .padding(20.dp)
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(top = 20.dp)
                .size(40.dp)
                .background(
                    color = colorResource(R.color.light_black),
                    RoundedCornerShape(50.dp)
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back arrow",
                tint = Color.White
            )
        }
        Text(
            text = "Get your free account",
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp)
        )
        CustomOutlinedButton(
            topPadding = 25,
            text = "Continue with Apple",
            painter = painterResource(R.drawable.apple),
            colorOfIcon = Color.White
        )
        CustomOutlinedButton(
            topPadding = 15,
            text = "Continue with Google",
            painter = painterResource(R.drawable.search),
            colorOfIcon = Color.Unspecified
        )
        Row (modifier = Modifier.padding(top = 23.dp)){
            CustomHorizontalDivider(width = 142, topPadding = 7)
            Text(
                text = "OR",
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                color = Color.LightGray
            )
            CustomHorizontalDivider(width = 142, topPadding = 7)
        }
        Text(
            text = buildAnnotatedString {
                withStyle (style = SpanStyle(
                    fontSize = 16.sp,
                    color = Color.White,
                )
                ){
                   append("Work Email ")
                }
                withStyle (style = SpanStyle(fontSize = 17.sp, color = colorResource(R.color.green))){
                   append("*")
                }
            },
            modifier = Modifier.padding(top = 25.dp)
        )
        var value by remember { mutableStateOf("") }
        OutlinedTextField(
           value=value,
           onValueChange = {value=it},
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp).height(46.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.DarkGray,
                unfocusedLabelColor = Color.LightGray
            ),
            label = {Text("hello@company.com")}
        )
        Button(
            onClick = {},
            modifier = Modifier.padding(top=36.dp).fillMaxWidth().height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(7.dp)
        ) {
            Text(
                text = "Continue with Email",
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
        Text(
            text = buildAnnotatedString {
                withStyle (style = SpanStyle(color = Color.Gray)){
                    append("Already have an account  ")
                }
                withStyle(style = SpanStyle(color = colorResource(R.color.green), fontWeight = FontWeight.SemiBold)) {
                    append("Login")
                }
            },
            modifier = Modifier.padding(top = 30.dp).fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 15.sp
        )
    }
}
@Preview
@Composable
fun SignInScreenPreview(){
    SignInScreen()
}
@Composable
fun CustomOutlinedButton(topPadding:Int,text: String,painter: Painter,colorOfIcon: Color) {
    OutlinedButton(
        onClick = {},
        modifier = Modifier
            .padding(top = topPadding.dp)
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(width = 1.dp, color = Color.DarkGray),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp
        ),
        contentPadding = PaddingValues(14.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = text,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.align (Alignment.Center)
            )
            Icon(
                painter = painter,
                contentDescription = "apple",
                tint = colorOfIcon,
                modifier = Modifier.align(Alignment.CenterStart)
            )
        }
    }
}
@Composable
fun CustomHorizontalDivider(width: Int,topPadding: Int){
    HorizontalDivider(
        modifier = Modifier.width(width.dp).padding(top = topPadding.dp),
        color = Color.DarkGray
    )
}





