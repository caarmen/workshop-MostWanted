package fr.o80.mostwanted.exercises

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class CIAMissionUIModel(
    val publicTitle: String,
    val secretTitle: String,
    val secretIconStart: ImageVector,
    val secretIconEnd: ImageVector,
)

@Composable
fun CIAMission(uiModel: CIAMissionUIModel, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        var isRevealed by rememberSaveable { mutableStateOf(false) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clickable {
                    isRevealed = !isRevealed
                }
                .padding(PaddingValues(horizontal = 8.dp, vertical = 16.dp)),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            if (isRevealed) {
                Icon(
                    imageVector = uiModel.secretIconStart,
                    contentDescription = null,
                )
                Text(modifier = Modifier.weight(1f).padding(horizontal = 8.dp), text = uiModel.secretTitle,
                    style = MaterialTheme.typography.titleMedium
                )
                Icon(
                    imageVector = uiModel.secretIconEnd,
                    contentDescription = null,
                )
            } else {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null
                )
                Text(text = uiModel.publicTitle, style=MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Composable
@Preview
fun CIAMissionPreview() {
    CIAMission(
        uiModel = CIAMissionUIModel(
            publicTitle = "Mission 1",
            secretTitle = "Secret Mission",
            secretIconStart = Icons.Default.Person,
            secretIconEnd = Icons.Default.Done,
        )
    )
}
