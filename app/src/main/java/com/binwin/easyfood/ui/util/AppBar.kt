package com.binwin.easyfood.ui.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.binwin.easyfood.ui.theme.Background
import com.binwin.easyfood.ui.theme.TitleColour

@Composable
fun AppBar(icon: ImageVector?, title: String, onClickBack: () -> Unit) {
    TopAppBar(
        navigationIcon = if (icon == null) null else {
            {
                Icon(
                    imageVector = icon,
                    contentDescription = "App Icon",
                    Modifier
                        .padding(horizontal = 12.dp)
                        .clickable(onClick = onClickBack)
                )
            }
        },
        title = { Text(text = title) },
        contentColor = TitleColour,
        elevation = 0.dp
    )
}

