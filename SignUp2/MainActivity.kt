package com.example.signup2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
           SignUpScreen()

        }
    }
}

@Composable
fun SignUpScreen(){
    Column(modifier = Modifier.fillMaxSize().background(color = Color.White).padding(20.dp)) {
        Image(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "back icon",
            modifier = Modifier.size(30.dp)
        )
        HeightSpacer(10)
        Text(
            text = "Create an account "+ stringResource(R.string.emoji),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        HeightSpacer(10)
        Text(
            text = "Welcome! Please enter your details.",
            color = colorResource(R.color.text_color),
            fontSize = 17.sp
        )
        HeightSpacer(20)
        CustomText("Name")
        CustomOutlinedTextField("Enter your name",Icons.Outlined.Person)
        HeightSpacer(15)
        CustomText("Email")
        CustomOutlinedTextField("Enter your email",Icons.Outlined.Email)
        HeightSpacer(15)
        CustomText("Password")
        OutlinedTextField(
            value ="",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            label = {
                Text(
                    text = "••••••••",
                    fontSize = 22.sp
                )
            },
            colors= OutlinedTextFieldDefaults.colors(
                unfocusedLabelColor = colorResource(R.color.text_field_label),
                unfocusedContainerColor = Color.Transparent,
                unfocusedBorderColor = Color.LightGray
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = "person",
                    tint = Color.Gray
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.eye_crossed),
                    contentDescription = "person",
                    tint = Color.Gray,
                    modifier = Modifier.size(22.dp)
                )
            }
        )
        Row{
         Checkbox(
            checked = true,
            onCheckedChange = {},
            colors = CheckboxDefaults.colors(
                checkedColor = colorResource(R.color.blue)
            )
         )
         Text(
            text = "Must be at least 8 characters",
            modifier = Modifier.padding(top = 15.dp),
            color = Color.Gray,
            fontSize = 16.sp
         )
        }
        HeightSpacer(20)
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.blue),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
             Text(
                 text = "Sign Up",
                 fontSize = 18.sp,
                 fontWeight = FontWeight.Medium
             )
        }
        HeightSpacer(15)
        Row {
            CustomHorizontalDivider()
            Text(
                text = "Or sign up with",
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                color = Color.Gray
            )
            CustomHorizontalDivider()
        }
        HeightSpacer(10)
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            CustomCardView(painterResource(R.drawable.apple))
            WidthSpacer(15)
            CustomCardView(painterResource(R.drawable.search))
            WidthSpacer(15)
            CustomCardView(painterResource(R.drawable.facebook))
        }
        HeightSpacer(88)
        Text(
            text = buildAnnotatedString {
                withStyle (style = SpanStyle(color = Color.Gray)){
                    append("Already have an account? ")
                }
                withStyle(style = SpanStyle(color = colorResource(R.color.blue), fontWeight = FontWeight.Bold)) {
                    append("Log in")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun SignUpScreenPreview(){
    SignUpScreen()
}
@Composable
fun HeightSpacer(height: Int){
    Spacer(modifier = Modifier.height(height.dp))
}
@Composable
fun WidthSpacer(width: Int){
    Spacer(modifier = Modifier.width(width.dp))
}

@Composable
fun CustomText(text: String){
    Text(
        text = text,
        color = Color.Black,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    )
}
@Composable
fun CustomOutlinedTextField(labelText:String,leadingIcon: ImageVector){
    OutlinedTextField(
        value ="",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        label = {
            Text(
                text = labelText,
                fontSize = 17.sp
            )
        },
        colors= OutlinedTextFieldDefaults.colors(
            unfocusedLabelColor = colorResource(R.color.text_field_label),
            unfocusedContainerColor = Color.Transparent,
            unfocusedBorderColor = Color.LightGray
        ),
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = "person",
                tint = Color.Gray
            )
        }
    )
}
@Composable
fun CustomHorizontalDivider(){
    HorizontalDivider(
        modifier = Modifier
            .width(100.dp)
            .padding(top = 8.dp),
        thickness = 1.dp,
        color = Color.Gray
    )
}
@Composable
fun CustomCardView(image: Painter){
    Card (
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(10.dp))
            .size(60.dp)
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ){
        Image(
            painter = image,
            contentDescription = "apple"
        )
    }
}