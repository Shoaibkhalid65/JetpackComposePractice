package com.gshoaib998.signin1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf

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
   Column(modifier = Modifier.fillMaxSize()
       .background(colorResource(R.color.white_background))
       .padding(20.dp)
   ) {
       CustomSpacer(40)
       Image(
           painter = painterResource(R.drawable.instagram_icon),
           contentDescription = "instagram icon",
           modifier = Modifier.fillMaxWidth().size(110.dp)
       )
       CustomSpacer(80)
       CustomOutlinedTextFiled("Username, email or mobile number")
       CustomSpacer(5)
       CustomOutlinedTextFiled("Password")
       CustomSpacer(15)
       Button(
           onClick = {},
           modifier = Modifier.fillMaxWidth().height(47.dp),
           colors = ButtonDefaults.buttonColors(
               containerColor = colorResource(R.color.blue)
           )
       ) {
           Text("Log in", style = TextStyle(fontSize = 17.sp, fontWeight = FontWeight.Medium))
       }
       CustomSpacer(5)
       TextButton(onClick = {}) {
           Text(
               text="Forgot password?",
               color = Color.Black,
               style= TextStyle(fontSize = 17.sp, fontWeight = FontWeight.Medium),
               modifier=Modifier.fillMaxWidth(),
               textAlign = TextAlign.Center
           )
       }
       CustomSpacer(140)
       OutlinedButton(
           onClick = {},
           modifier = Modifier.fillMaxWidth().height(47.dp),
           border = BorderStroke(1.dp, colorResource(R.color.blue)),
           shape = RoundedCornerShape(18.dp)
       ) {
            Text(
                text="Create new account",
                style= TextStyle(
                    color= colorResource(R.color.blue),
                    fontSize=18.sp,
                    fontWeight = FontWeight.Medium
                )
            )
       }
       CustomSpacer(25)
       Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(R.drawable.meta),
                contentDescription ="meta icon",
                modifier = Modifier.size(24.dp)
            )
           Spacer(modifier = Modifier.width(3.dp))
           Text(
               text="Meta",
               color= colorResource(R.color.dark_grey),
               style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium)

           )
       }
   }
}

@Preview
@Composable
fun SignInScreenPreview(){
    SignInScreen()
}


@Composable
fun CustomOutlinedTextFiled(labelText:String){
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value=text,
        onValueChange = {text=it},
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(labelText)
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedLabelColor = colorResource(R.color.light_grey),
            unfocusedBorderColor = colorResource(R.color.stroke_color)
        ),
        shape = RoundedCornerShape(12.dp)
    )
}

@Composable
fun CustomSpacer(height:Int){
    Spacer(modifier = Modifier.height(height.dp))
}







