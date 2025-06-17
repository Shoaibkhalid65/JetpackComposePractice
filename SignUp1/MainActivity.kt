package com.gshoaib998.signup1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
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
           SignUpScreen()
        }
    }
}

@Composable
fun SignUpScreen(){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).padding(20.dp)
    ) {
        HeightSpacer(30)
        Text(
            text = "Sign Up",
            style = TextStyle(
                color = Color.Black,
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        HeightSpacer(30)
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle()){
                    append("Sign Up and Find.Collect and Create your Best ")
                }
                withStyle(style = SpanStyle(color = colorResource(R.color.text_blue), fontWeight = FontWeight.Medium)){
                    append("NFTs")
                }
            },
            modifier = Modifier.padding(horizontal = 5.dp),
            fontSize = 13.sp
        )
        HeightSpacer(40)
        TextAboveTextField("E-Mail")
        HeightSpacer(3)
        CustomTextField("Enter Email address")
        HeightSpacer(25)
        TextAboveTextField("Mobile")
        HeightSpacer(3)
        CustomTextField("Enter Mobile No")
        HeightSpacer(25)
        TextAboveTextField("Password")
        HeightSpacer(3)
        var value by remember { mutableStateOf("") }
        TextField(
            value = value,
            onValueChange = {value=it},
            placeholder = {
                Text("Enter Password", color = Color.Gray)
            },
            modifier = Modifier.fillMaxWidth().padding(0.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Gray
            ),
            trailingIcon = {
                Icon(painter = painterResource(R.drawable.hide), contentDescription = "",
                    modifier = Modifier.size(20.dp),)
            }
        )
        HeightSpacer(50)
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle()){
                    append("By signing up you are agreeing to our ")
                }
                withStyle(style = SpanStyle(color = colorResource(R.color.text_blue), fontWeight = FontWeight.Medium)){
                    append("Terms & conditions ")
                }
                withStyle(style = SpanStyle()){
                    append("and ")
                }
                withStyle(style = SpanStyle(color = colorResource(R.color.text_blue), fontWeight = FontWeight.Medium)){
                    append("Privacy Policy")
                }
            },
            modifier = Modifier.padding(horizontal = 20.dp),
            fontSize = 13.sp,
            textAlign = TextAlign.Center
        )
        HeightSpacer(50)
        Button(onClick = {}, modifier = Modifier.fillMaxWidth().height(50.dp), colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.btn_blue)
        )
        ) {
            Text("SIGN UP", style = TextStyle(fontWeight = FontWeight.Medium))
        }
        HeightSpacer(50)
        Text(
            text=buildAnnotatedString {
                withStyle(style = SpanStyle()){
                    append("Already a member? ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                    append("Log In")
                }
            },
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 15.sp
        )
    }
}

@Preview
@Composable
fun SignUpScreenPreview(){
    SignUpScreen()
}

@Composable
fun HeightSpacer(height:Int){
    Spacer(modifier = Modifier.height(height = height.dp))
}

@Composable
fun TextAboveTextField(text:String){
   Text(
       text=text,
       style = TextStyle(fontWeight = FontWeight.Medium, color = Color.Black, fontSize = 20.sp)
   )
}

@Composable
fun CustomTextField(text:String){
    var value by remember { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = {value=it},
        placeholder = {
            Text(text, color = Color.Gray)
        },
        modifier = Modifier.fillMaxWidth().padding(0.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Gray
        )
    )
}