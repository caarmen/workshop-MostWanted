package fr.o80.mostwanted.exercises

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.o80.mostwanted.internals.PreviewTheme

@Composable
fun CIAIdentity(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("CIA")
                }
            )
        },
        bottomBar = {
            Text(
                "Badge",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(4.dp)
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
            ) {
                CIAProfile()
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    item {
                        CIASkill(
                            label = "Compose",
                            level = "Expert",
                            isBest = true,
                            modifier = modifier
                        )
                    }
                    item {
                        CIASkill(
                            label = "Compose",
                            level = "Expert",
                            isBest = false,
                            modifier = modifier
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CIAIdentityPreview() {
    PreviewTheme {
        CIAIdentity()
    }
}
