package com.learncompose.drawingpractice.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.learncompose.drawingpractice.R
import com.learncompose.drawingpractice.ui.theme.Dimens
import com.learncompose.drawingpractice.ui.theme.DrawingPracticeTheme
import com.learncompose.drawingpractice.viewmodel.LoginUiEffect
import com.learncompose.drawingpractice.viewmodel.LoginUiEvent
import com.learncompose.drawingpractice.viewmodel.LoginUiState
import com.learncompose.drawingpractice.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackBarHostState = remember { SnackbarHostState() }
    val context = LocalResources.current
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(
        context, lifecycleOwner
    ) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    is LoginUiEffect.ShowSnackBar -> {
                        snackBarHostState.showSnackbar(context.getString(effect.messageRes))
                    }

                    LoginUiEffect.NavigateToHome -> {}
                }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        SnackbarHost(
            hostState = snackBarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
                .imePadding()
                .navigationBarsPadding()
        )
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.app_background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            LoginHeader(modifier = Modifier.fillMaxWidth())
            LoginContent(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                uiState = uiState,
                onEvent = viewModel::onEvent
            )
        }
    }
}

@Composable
private fun LoginHeader(modifier: Modifier = Modifier) {
    val languageShape = RoundedCornerShape(size = Dimens.CornerPill)

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Surface(
                // padding trước, clip theo shape rồi mới clickable: vùng bấm/ripple khớp đúng viên thuốc.
                modifier = Modifier
                    .padding(top = Dimens.SpaceL, end = Dimens.SpaceM)
                    .clip(languageShape)
                    .clickable(onClick = {}),
                color = Color.Transparent,
                shape = languageShape,
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
                        contentDescription = null,
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
                contentDescription = null
            )
        }
    }
}

@Composable
private fun LoginContent(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onEvent: (LoginUiEvent) -> Unit
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(
            topStart = Dimens.CornerSheet,
            topEnd = Dimens.CornerSheet
        ),
        color = MaterialTheme.colorScheme.surface
    ) {
        // Màn đủ cao: Terms nằm sát đáy (SpaceBetween + heightIn min = chiều cao khung nhìn).
        // Màn thấp: nội dung vượt khung nhìn thì cuộn được.
        // imePadding: bàn phím mở thì khung nhìn co lên trên bàn phím, ô đang nhập cuộn được vào tầm nhìn.
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .heightIn(min = maxHeight)
                    .padding(horizontal = Dimens.SpaceXxxl),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoginForm(
                        modifier = Modifier.fillMaxWidth(),
                        uiState = uiState,
                        onEvent = onEvent
                    )
                    Spacer(modifier = Modifier.height(Dimens.SpaceM))
                    LoginLinkRow(
                        text = stringResource(R.string.login_no_account),
                        linkText = stringResource(R.string.login_register),
                        onLinkClick = {}
                    )
                    Spacer(modifier = Modifier.height(Dimens.SpaceXs))
                    LoginLinkRow(
                        text = stringResource(R.string.login_need_help),
                        linkText = stringResource(R.string.login_see_manual),
                        onLinkClick = {}
                    )
                }
                LoginTerms(
                    modifier = Modifier
                        .padding(top = Dimens.SpaceXxxl, bottom = Dimens.SpaceXxxl)
                        .navigationBarsPadding()
                )
            }
        }
    }
}

// Nhập liệu đăng nhập: tài khoản, mật khẩu, quên mật khẩu, nút Login.
@Composable
private fun LoginForm(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onEvent: (LoginUiEvent) -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = uiState.account,
            onValueChange = {
                onEvent.invoke(LoginUiEvent.ChangeAccount(it))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimens.SpaceXxxl),
            placeholder = {
                Text(text = stringResource(R.string.login_account_hint))
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            shape = RoundedCornerShape(Dimens.CornerTextField),
            supportingText =
                if (uiState.isAccountError) {
                    {
                        Text(text = stringResource(R.string.login_account_invalid))
                    }
                } else null,
            isError = uiState.isAccountError
        )
        Spacer(modifier = Modifier.height(Dimens.SpaceXl))
        OutlinedTextField(
            value = uiState.password,
            onValueChange = {
                onEvent.invoke(LoginUiEvent.ChangePassword(it))
            },
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = { Text(text = stringResource(R.string.login_password_hint)) },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
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
            text = stringResource(R.string.login_forgot_password),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelLarge
        )
        Spacer(modifier = Modifier.height(Dimens.SpaceXxxl))
        Button(
            onClick = {
                onEvent.invoke(LoginUiEvent.ClickLogin)
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(Dimens.CornerButton),
            enabled = uiState.account.isNotBlank() && uiState.password.isNotBlank()
        ) {
            Text(text = stringResource(R.string.login_button))
        }
    }
}

// Một dòng "chữ thường + link". FlowRow: màn hẹp thì link xuống hàng nguyên vẹn thay vì bị ép vỡ chữ.
@Composable
private fun LoginLinkRow(
    text: String,
    linkText: String,
    onLinkClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Dimens.SpaceXxs),
        horizontalArrangement = Arrangement.spacedBy(
            Dimens.SpaceXxs,
            Alignment.CenterHorizontally
        ),
        itemVerticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            modifier = Modifier.clickable(onClick = onLinkClick),
            text = linkText,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
private fun LoginTerms(modifier: Modifier = Modifier) {
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

    Text(
        modifier = modifier,
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginPreview() {
    DrawingPracticeTheme {
        LoginScreen()
    }
}