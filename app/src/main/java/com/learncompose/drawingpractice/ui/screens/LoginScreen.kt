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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import com.learncompose.drawingpractice.R
import com.learncompose.drawingpractice.ui.theme.Dimens
import com.learncompose.drawingpractice.ui.theme.DrawingPracticeTheme

@Composable
fun LoginScreen() {
    // SpanStyle không phải @Composable, nên đọc theme trước khi build annotated string.
    val linkStyle = SpanStyle(
        color = MaterialTheme.colorScheme.primary,
        fontWeight = MaterialTheme.typography.titleSmall.fontWeight
    )
    val termsPrefix = stringResource(R.string.login_terms_prefix)
    val termsOfUse = stringResource(R.string.login_terms_of_use)
    val termsAnd = stringResource(R.string.login_terms_and)
    val privacyPolicy = stringResource(R.string.login_privacy_policy)
    val termsOfUseUrl = stringResource(R.string.url_terms_of_use)
    val privacyPolicyUrl = stringResource(R.string.url_privacy_policy)

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
                    modifier = Modifier.padding(top = Dimens.SpaceL, end = Dimens.SpaceM)
                        .clickable(onClick = {}),
                    color = Color.Transparent,
                    shape = RoundedCornerShape(size = Dimens.CornerPill),
                    border = BorderStroke(
                        width = Dimens.BorderThin,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(
                            top = Dimens.SpaceXxs,
                            end = Dimens.SpaceL,
                            bottom = Dimens.SpaceXxs,
                            start = Dimens.SpaceS
                        ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.size(Dimens.IconSmall),
                            painter = painterResource(R.drawable.ic_language_vn),
                            contentDescription = "",
                        )
                        Spacer(Modifier.width(Dimens.SpaceS))
                        Text(
                            text = stringResource(R.string.language_code_vi),
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.SpaceXxxl),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(Dimens.AppLogo),
                    painter = painterResource(R.drawable.ic_app),
                    contentDescription = ""
                )
            }

            Surface(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(
                    topStart = Dimens.CornerSheet,
                    topEnd = Dimens.CornerSheet
                ),
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = Dimens.SpaceXxxl),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = Dimens.SpaceXxxl),
                        placeholder = {
                            Text(text = stringResource(R.string.login_account_hint))
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Next
                        ),
                        shape = RoundedCornerShape(Dimens.CornerTextField)
                    )
                    Spacer(modifier = Modifier.height(Dimens.SpaceXl))
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth(),
                        placeholder = { Text(text = stringResource(R.string.login_password_hint)) },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        shape = RoundedCornerShape(Dimens.CornerTextField)
                    )
                    Spacer(modifier = Modifier.height(Dimens.SpaceXl))
                    Text(
                        modifier = Modifier
                            .clickable(onClick = {})
                            .padding(Dimens.SpaceXxs),
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.login_forgot_password),
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.labelLarge
                    )
                    Spacer(modifier = Modifier.height(Dimens.SpaceXxxl))
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(Dimens.CornerButton)
                    ) {
                        Text(text = stringResource(R.string.login_button))
                    }
                    Spacer(modifier = Modifier.height(Dimens.SpaceM))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(Dimens.SpaceXxs),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.login_no_account),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.width(Dimens.SpaceXxs))
                        Text(
                            modifier = Modifier.clickable(onClick = {}),
                            text = stringResource(R.string.login_register),
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                    Spacer(modifier = Modifier.height(Dimens.SpaceXs))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = Dimens.SpaceXxs),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.login_need_help),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.width(Dimens.SpaceXxs))
                        Text(
                            modifier = Modifier.clickable(onClick = {}),
                            text = stringResource(R.string.login_see_manual),
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                }
            }
        }

        Text(
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(
                    start = Dimens.SpaceXl,
                    end = Dimens.SpaceXl,
                    bottom = Dimens.SpaceXxxl
                ),
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {
                append(termsPrefix)
                withLink(
                    LinkAnnotation.Url(
                        url = termsOfUseUrl,
                        styles = TextLinkStyles(style = linkStyle)
                    ),
                    block = {
                        append(termsOfUse)
                    }
                )
                append(termsAnd)
                withLink(
                    LinkAnnotation.Url(
                        url = privacyPolicyUrl,
                        styles = TextLinkStyles(style = linkStyle)
                    ),
                    block = {
                        append(privacyPolicy)
                    }
                )
            },
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyMedium
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