package fr.o80.mostwanted.exercises

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
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

@Composable
fun CIABadge(modifier: Modifier = Modifier) {
    var currentPage by rememberSaveable { mutableIntStateOf(0) }
    Scaffold(
        modifier=modifier,
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
            Text("Liste de missions", modifier=Modifier.padding(paddingValues))
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
