package com.alithya.boilerplate.core.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import boilerplate.composeapp.generated.resources.Res
import boilerplate.composeapp.generated.resources.sf_pro_bold
import boilerplate.composeapp.generated.resources.sf_pro_light
import boilerplate.composeapp.generated.resources.sf_pro_medium
import boilerplate.composeapp.generated.resources.sf_pro_regular
import boilerplate.composeapp.generated.resources.sf_pro_semibold
import boilerplate.composeapp.generated.resources.sf_pro_thin
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

//import com.alithya.boilerplate.platform.font

/**
 * created by Josue Lubaki
 * date : 2023-12-04
 * version : 1.0.0
 */

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun getTypography(): Typography {
    val sfProRegular = Font(
        resource = Res.font.sf_pro_regular,
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    )

    val sfProBold =
        Font(
            resource = Res.font.sf_pro_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        )

    val sfProLight =
        Font(
            resource = Res.font.sf_pro_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        )

    val sfProMedium =
        Font(
            resource = Res.font.sf_pro_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal
        )

    val sfProSemiBold =
        Font(
            resource = Res.font.sf_pro_semibold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal
        )

    val sfProThin =
        Font(
            resource = Res.font.sf_pro_thin,
            weight = FontWeight.Thin,
            style = FontStyle.Normal
        )

    @Composable
    fun sfPro() = FontFamily(
        sfProThin,
        sfProLight,
        sfProRegular,
        sfProMedium,
        sfProSemiBold,
        sfProBold
    )

    return Typography(
        bodyLarge = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight(510),
            fontSize = 18.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight(510),
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.15.sp
        ),
        bodySmall = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight(510),
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.4.sp
        ),
        titleLarge = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight(700),
            fontSize = 24.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.15.sp
        ),
        titleMedium = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight(700),
            fontSize = 20.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp,
        ),
        titleSmall = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight(700),
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp,
        ),
        labelLarge = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight(500),
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp,
        ),
        labelMedium = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight(500),
            fontSize = 14.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp,
        ),
        labelSmall = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight(500),
            fontSize = 12.sp,
            lineHeight = 12.sp,
            letterSpacing = 0.4.sp,
        ),
        displayLarge = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight.Bold,
            fontSize = 57.sp,
            lineHeight = 64.sp,
        ),
        displayMedium = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight.Bold,
            fontSize = 48.sp,
            lineHeight = 48.sp,
        ),
        displaySmall = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            lineHeight = 40.sp,
        ),
        headlineLarge = TextStyle(
            fontFamily = sfPro(),
            fontWeight = FontWeight(700),
            fontSize = 24.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.15.sp,
        ),
    )
}