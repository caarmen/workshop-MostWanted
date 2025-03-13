package fr.o80.mostwanted.exercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import fr.o80.mostwanted.internals.PreviewTheme

@Composable
fun CIAImage(modifier: Modifier = Modifier) {
    var corner by remember { mutableIntStateOf(0) }
    Image(
        modifier = Modifier
            .clickable {
                corner = if (corner == 48) {
                    0
                } else {
                    48
                }
            }
            .clip(RoundedCornerShape(corner)),
        painter = painterResource(R.drawable.avatar_red),
        contentDescription = "Avatar",
    )
}

@Preview
@Composable
private fun CIAImagePreview() {
    PreviewTheme {
        CIAImage()
    }
}
