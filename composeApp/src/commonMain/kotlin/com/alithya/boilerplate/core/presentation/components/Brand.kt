package com.alithya.boilerplate.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import boilerplate.composeapp.generated.resources.Res
import boilerplate.composeapp.generated.resources.app_name
import boilerplate.composeapp.generated.resources.ic_alithya
import boilerplate.composeapp.generated.resources.ic_alithya_dark
import com.alithya.boilerplate.core.presentation.theme.BRAND_HEIGHT
import com.alithya.boilerplate.core.presentation.theme.BRAND_HEIGHT_LANDSCAPE
import com.alithya.boilerplate.core.presentation.theme.BRAND_WIDTH
import com.alithya.boilerplate.core.presentation.theme.BRAND_WIDTH_LANDSCAPE
import com.alithya.boilerplate.core.presentation.theme.dimensions
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Brand(
    modifier: Modifier = Modifier,
    isLandScape: Boolean = false,
) {
    Column(
        modifier = modifier
            .padding(MaterialTheme.dimensions.small),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(
                    width = if(!isLandScape) BRAND_WIDTH else BRAND_WIDTH_LANDSCAPE,
                    height = if(!isLandScape) BRAND_HEIGHT else BRAND_HEIGHT_LANDSCAPE
                ),
            painter = painterResource(Res.drawable.ic_alithya),
            contentDescription = "logo",
        )
        Text(
            text = stringResource(Res.string.app_name).uppercase(),
            style = TextStyle(
                fontSize = if(!isLandScape) 16.sp else 36.sp,
                fontWeight = FontWeight.Light
            ),
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}
