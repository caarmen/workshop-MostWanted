package fr.o80.mostwanted.exercises

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.o80.mostwanted.internals.PreviewTheme

val missions= listOf(
    CIAMissionUIModel(
        publicTitle = "Mission Secrète #1",
        secretTitle = "Configurer Android Studio",
        secretIconStart = Icons.Default.Info,
        secretIconEnd = Icons.Default.Done,
    ),
    CIAMissionUIModel(
        publicTitle = "Mission Secrète #2",
        secretTitle = "Apprendre les bases de Jetpack Compose",
        secretIconStart = Icons.Default.Info,
        secretIconEnd = Icons.Default.Done,
    ),
    CIAMissionUIModel(
        publicTitle = "Mission Secrète #3",
        secretTitle = "Finir l'atelier",
        secretIconStart = Icons.Default.Info,
        secretIconEnd = Icons.Default.Build,
    ),
    CIAMissionUIModel(
        publicTitle = "Mission Secrète #4",
        secretTitle = "Envoyer une photo de mon badge sur les réseaux sociaux",
        secretIconStart = Icons.Default.AccountCircle,
        secretIconEnd = Icons.Default.DateRange,
    ),
    CIAMissionUIModel(
        publicTitle = "Mission Secrète #5",
        secretTitle = "Créer ma propre application mobile",
        secretIconStart = Icons.Default.Build,
        secretIconEnd = Icons.Default.DateRange,
    ),
    CIAMissionUIModel(
        publicTitle = "Mission Secrète #6",
        secretTitle = "Déployer mon application sur les stores",
        secretIconStart = Icons.Default.Build,
        secretIconEnd = Icons.Default.DateRange,
    ),
)

@Composable
fun CIABadge(modifier: Modifier = Modifier) {
    var currentPage by rememberSaveable { mutableIntStateOf(0) }
    Scaffold(
        modifier=modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("CIA")
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentPage == 0,
                    onClick = {
                        currentPage = 0
                    },
                    label = {
                        Text("Badge")
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                        )
                    }
                )
                NavigationBarItem(
                    selected = currentPage == 1,
                    onClick = {
                        currentPage = 1
                    },
                    label = {
                        Text("Missions")
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null,
                        )
                    }
                )
            }
        }
    ) { paddingValues ->
        if (currentPage == 0) {
            CIAIdentity(modifier = Modifier.padding(paddingValues).fillMaxSize())
        } else {
            CIAMissionList(
                missions = missions,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }

}

@Preview
@Composable
private fun CIABadgePreview() {
    PreviewTheme {
        CIABadge()
    }
}
