package com.learncompose.drawingpractice.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.learncompose.drawingpractice.R
import com.learncompose.drawingpractice.ui.theme.Dimens
import com.learncompose.drawingpractice.ui.theme.DrawingPracticeTheme
import com.learncompose.drawingpractice.ui.theme.extendedColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(MaterialTheme.extendedColors.screenBackground)
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.extendedColors.headerGradientStart,
                        MaterialTheme.extendedColors.headerGradientEnd
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
                            text = stringResource(R.string.profile_title),
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.titleMedium
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
                                contentDescription = stringResource(R.string.cd_back)
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
                    .padding(horizontal = Dimens.SpaceXl)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(Dimens.CornerCard),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = Dimens.ElevationCard
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = Dimens.SpaceXl, end = Dimens.SpaceXl),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_edit),
                                contentDescription = stringResource(R.string.cd_edit),
                                modifier = Modifier
                                    .size(Dimens.IconButtonSize)
                                    .clickable(onClick = {})
                                    .padding(Dimens.SpaceM)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(Dimens.Avatar)
                                .align(Alignment.CenterHorizontally),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_user_bg),
                                contentDescription = stringResource(R.string.cd_user),
                                modifier = Modifier.fillMaxSize()
                            )

                            Image(
                                painter = painterResource(R.drawable.bg_oval),
                                contentDescription = stringResource(R.string.cd_user),
                                modifier = Modifier
                                    .size(Dimens.AvatarBadge)
                                    .align(Alignment.BottomEnd)
                            )

                            Image(
                                painter = painterResource(R.drawable.ic_camera),
                                contentDescription = stringResource(R.string.cd_camera),
                                modifier = Modifier
                                    .size(Dimens.AvatarBadge)
                                    .clip(CircleShape)
                                    .clickable(onClick = {})
                                    .padding(Dimens.SpaceS)
                                    .align(Alignment.BottomEnd)
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = Dimens.SpaceXl,
                                    top = Dimens.SpaceXxxl,
                                    end = Dimens.SpaceXl,
                                    bottom = Dimens.SpaceXxl
                                )
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = stringResource(R.string.profile_label_name),
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.weight(0.45f),
                                    color = MaterialTheme.extendedColors.textLabel
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
                                    text = stringResource(R.string.profile_label_birthday),
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.weight(0.45f),
                                    color = MaterialTheme.extendedColors.textLabel
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
                                    text = stringResource(R.string.profile_label_email),
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.weight(0.45f),
                                    color = MaterialTheme.extendedColors.textLabel
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
                                    text = stringResource(R.string.profile_label_phone),
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.weight(0.45f),
                                    color = MaterialTheme.extendedColors.textLabel
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
                Spacer(modifier = Modifier.height(Dimens.SpaceXl))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(Dimens.CornerCard),
                    elevation = CardDefaults.cardElevation(
                        Dimens.ElevationCard
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            Modifier.fillMaxWidth()
                                .padding(Dimens.SpaceXl),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(R.string.profile_change_password),
                                style = MaterialTheme.typography.bodyLarge,
                            )

                            Image(
                                painter = painterResource(R.drawable.ic_arrow_right),
                                contentDescription = "",
                                modifier = Modifier.size(Dimens.IconMedium)
                                    .clickable(onClick = {})
                                    .padding(Dimens.SpaceXxs)
                            )
                        }
                        HorizontalDivider(
                            modifier = Modifier
                        )
                        Row(
                            Modifier.fillMaxWidth()
                                .padding(Dimens.SpaceXl),
                        ) {
                            Text(
                                text = stringResource(R.string.profile_logout),
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(Dimens.SpaceXl))
                ElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(Dimens.CornerCard),
                    elevation = CardDefaults.elevatedCardElevation(
                        Dimens.ElevationCard
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Text(
                        text = stringResource(R.string.profile_delete_account),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(Dimens.SpaceXl)
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