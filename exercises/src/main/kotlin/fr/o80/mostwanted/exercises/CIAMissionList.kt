package fr.o80.mostwanted.exercises

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CIAMissionList(missions: List<CIAMissionUIModel>, modifier: Modifier = Modifier) {
    LazyColumn(modifier=modifier.padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        missions.forEach { mission ->
            item {
                CIAMission(uiModel = mission)
            }
        }
    }
}

@Composable
@Preview
private fun CIAMissionListPreview() {
    val missions = (1..20).map {
        CIAMissionUIModel(
            publicTitle = "public title $it",
            secretTitle = "secret title $it",
            secretIconStart = Icons.Default.Person,
            secretIconEnd = Icons.Default.Done,
        )
    }
    CIAMissionList(
        missions = missions,
    )
}
