package com.learncompose.drawingpractice.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learncompose.drawingpractice.R
import com.learncompose.drawingpractice.ui.theme.DrawingPracticeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFBDE6FF),
                        Color(0x00F9FAFB)
                    )
                )
            )
    ) {
        Scaffold(
            modifier = Modifier,
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Account Info",
                            color = Color(0xFF262F3B),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {},
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = Color.Transparent
                            )
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_back_pair_screen),
                                contentDescription = "Back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
            },
            containerColor = Color.Transparent
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp, end = 16.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_edit),
                                contentDescription = "Edit",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clickable(onClick = {})
                                    .padding(10.dp)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(105.dp)
                                .align(Alignment.CenterHorizontally),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_user_bg),
                                contentDescription = "User",
                                modifier = Modifier.fillMaxSize()
                            )

                            Image(
                                painter = painterResource(R.drawable.bg_oval),
                                contentDescription = "User",
                                modifier = Modifier
                                    .size(35.dp)
                                    .align(Alignment.BottomEnd)
                            )

                            Image(
                                painter = painterResource(R.drawable.ic_camera),
                                contentDescription = "Camera",
                                modifier = Modifier
                                    .size(35.dp)
                                    .clip(CircleShape)
                                    .clickable(onClick = {})
                                    .padding(8.dp)
                                    .align(Alignment.BottomEnd)
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, top = 30.dp, end = 16.dp, bottom = 20.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Tên:",
                                    fontSize = 16.sp,
                                    modifier = Modifier.weight(0.45f),
                                    color = Color(0xFF748792)
                                )
                                TextField(
                                    value = "Phạm Thị Ngà",
                                    onValueChange = {},
                                    modifier = Modifier.weight(0.55f),
                                    colors = TextFieldDefaults.colors(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                    )
                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Ngày sinh:",
                                    fontSize = 16.sp,
                                    modifier = Modifier.weight(0.45f),
                                    color = Color(0xFF748792)
                                )
                                TextField(
                                    value = "",
                                    onValueChange = {},
                                    modifier = Modifier.weight(0.55f),
                                    colors = TextFieldDefaults.colors(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                    )
                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Email:",
                                    fontSize = 16.sp,
                                    modifier = Modifier.weight(0.45f),
                                    color = Color(0xFF748792)
                                )
                                TextField(
                                    value = "",
                                    onValueChange = {},
                                    modifier = Modifier.weight(0.55f),
                                    colors = TextFieldDefaults.colors(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                    )
                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Số điện thoại:",
                                    fontSize = 16.sp,
                                    modifier = Modifier.weight(0.45f),
                                    color = Color(0xFF748792)
                                )
                                TextField(
                                    value = "",
                                    onValueChange = {},
                                    modifier = Modifier.weight(0.55f),
                                    colors = TextFieldDefaults.colors(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                    )
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(
                        4.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            Modifier.fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Change password",
                                fontSize = 16.sp,
                            )

                            Image(
                                painter = painterResource(R.drawable.ic_arrow_right),
                                contentDescription = "",
                                modifier = Modifier.size(24.dp)
                                    .clickable(onClick = {})
                                    .padding(4.dp)
                            )
                        }
                        HorizontalDivider(
                            modifier = Modifier
                        )
                        Row(
                            Modifier.fillMaxWidth()
                                .padding(16.dp),
                        ) {
                            Text(
                                text = "Logout",
                                fontSize = 16.sp,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                ElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.elevatedCardElevation(
                        4.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Text(
                        text = "Delete account",
                        fontSize = 16.sp,
                        color = Color(0xFFFF4C4C),
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ProfilePreview() {
    DrawingPracticeTheme {
        ProfileScreen()
    }
}