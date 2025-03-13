package fr.o80.mostwanted.exercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.o80.mostwanted.internals.PreviewTheme

@Composable
fun CIASkill(
    label: String,
    level: String,
    /// Ce paramètre est utile pour le 2nd exercice de ce chapitre
    isBest: Boolean,
    modifier: Modifier = Modifier
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.skill),
                contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                Text(label)
                Text(level)
            }
            if(isBest) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "favorite",
                )
            }
        }

    }

}

@Preview
@Composable
private fun CIASkillPreview() {
    PreviewTheme {
        CIASkill(
            label = "some label",
            level = "some level",
            isBest = false
        )
    }
}
