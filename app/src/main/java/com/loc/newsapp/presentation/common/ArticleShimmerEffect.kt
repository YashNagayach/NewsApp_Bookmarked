package com.loc.newsapp.presentation.common

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.loc.newsapp.R
import com.loc.newsapp.presentation.Dimens
import com.loc.newsapp.presentation.Dimens.ExtraSmallPadding
import com.loc.newsapp.presentation.Dimens.MediumPadding1
import com.loc.newsapp.ui.theme.NewsAppTheme

fun Modifier.shimmerEffect(cornerRadius: CornerRadius = CornerRadius(x = 12f, y = 12f)) = composed {
    val transition = rememberInfiniteTransition(label = "shimmer effect")
    val alpha = transition.animateFloat(
        initialValue = 0.2f, targetValue = 0.9f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "transparency of the background color"
    ).value
    val color = colorResource(id = R.color.shimmer).copy(alpha = alpha)
    drawBehind {
        drawRoundRect(
            color = color,
            cornerRadius = cornerRadius
        )
    }
}

@Composable
fun ArticleCardShimmerEffect(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        // Shimmer effect for image placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp) // Adjust the height according to your design
                .shimmerEffect()
        )

        Spacer(modifier = Modifier.height(ExtraSmallPadding))

        // Shimmer effect for title placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp) // Adjust the height according to your design
                .padding(horizontal = MediumPadding1)
                .shimmerEffect()
        )

        Spacer(modifier = Modifier.height(ExtraSmallPadding))

        // Shimmer effect for source and date placeholder
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Shimmer effect for source placeholder
            Box(
                modifier = Modifier
                    .height(14.dp) // Adjust the height according to your design
                    .width(100.dp) // Adjust the width according to your design
                    .padding(horizontal = MediumPadding1)
                    .shimmerEffect()
            )

            Spacer(modifier = Modifier.width(ExtraSmallPadding))

            // Shimmer effect for date placeholder
            Box(
                modifier = Modifier
                    .height(14.dp) // Adjust the height according to your design
                    .width(70.dp) // Adjust the width according to your design
                    .shimmerEffect()
            )
        }
    }
}
