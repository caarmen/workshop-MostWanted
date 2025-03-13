package fr.o80.mostwanted.exercises

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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

@Composable
fun ExerciseNavigation(modifier: Modifier = Modifier) {
    var currentPage by rememberSaveable { mutableIntStateOf(0) }
    Scaffold(
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
        Text("Page $currentPage", modifier = Modifier.padding(paddingValues))

    }

}

@Preview
@Composable
private fun ExerciseNavigationPreview() {
    PreviewTheme {
        ExerciseNavigation()
    }
}
