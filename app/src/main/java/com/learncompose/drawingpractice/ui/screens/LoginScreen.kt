package com.learncompose.drawingpractice.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learncompose.drawingpractice.R
import com.learncompose.drawingpractice.ui.theme.DrawingPracticeTheme

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier.fillMaxSize()

    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.app_background),
            contentDescription = ""
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Surface(
                    modifier = Modifier.padding(top = 12.dp, end = 10.dp)
                        .clickable(onClick = {}),
                    color = Color.Transparent,
                    shape = RoundedCornerShape(size = 100.dp),
                    border = BorderStroke(width = 1.dp, color = Color.White)
                ) {
                    Row(
                        modifier = Modifier.padding(
                            top = 4.dp,
                            end = 12.dp,
                            bottom = 4.dp,
                            start = 8.dp
                        ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(R.drawable.ic_language_vn),
                            contentDescription = "",
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            modifier = Modifier,
                            text = "VI",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(140.dp),
                    painter = painterResource(R.drawable.ic_app),
                    contentDescription = ""
                )
            }

            Surface(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(
                    topStart = 36.dp,
                    topEnd = 36.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                ),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        placeholder = {
                            Text(text = "Account")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Next
                        ),
                        shape = RoundedCornerShape(28.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth(),
                        placeholder = { Text(text = "Password") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        shape = RoundedCornerShape(28.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        modifier = Modifier
                            .clickable(onClick = {})
                            .padding(4.dp),
                        textAlign = TextAlign.Center,
                        text = "Forgot password",
                        fontSize = 14.sp,
                        color = Color(0xFF2D74E7),
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2D74E7)
                        )
                    ) {
                        Text(text = "Login", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(4.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "Do not have an account?",
                            fontSize = 16.sp,
                            color = Color(0xFF8B9CB2)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            modifier = Modifier.clickable(onClick = {}),
                            text = "Register",
                            fontSize = 16.sp,
                            color = Color(0xFF2D74E7),
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "Need help setting up?",
                            fontSize = 16.sp,
                            color = Color(0xFF8B9CB2)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            modifier = Modifier.clickable(onClick = {}),
                            text = "See manual",
                            fontSize = 16.sp,
                            color = Color(0xFF2D74E7),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        Text(
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 30.dp
                ),
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {
                append("Bằng việc tiếp tục, bạn đồng ý với ONE Home về ")
                withLink(
                    LinkAnnotation.Url(
                        url = "https://sanphamvnpt.vn/one-home-dieu-khoan-su-dung-n777",
                        styles = TextLinkStyles(
                            style = SpanStyle(
                                color = Color(0xFF2D74E7),
                                fontWeight = FontWeight.Bold
                            )
                        )
                    ),
                    block = {
                        append("Điều khoản sử dụng")
                    }
                )
                append(" và ")
                withLink(
                    LinkAnnotation.Url(
                        url = "",
                        styles = TextLinkStyles(
                            style = SpanStyle(
                                color = Color(0xFF2D74E7),
                                fontWeight = FontWeight.Bold
                            )
                        )
                    ),
                    block = {
                        append("Chính sách bảo mật")
                    }
                )
            },
            color = Color(0xFF262F3B),
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    DrawingPracticeTheme {
        LoginScreen()
    }
}