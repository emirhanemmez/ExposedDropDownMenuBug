import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            var isLongListExpanded by remember {
                mutableStateOf(false)
            }

            var selectedLongListItem by remember {
                mutableStateOf("English")
            }

            var isShortListExpanded by remember {
                mutableStateOf(false)
            }

            var selectedShortListItem by remember {
                mutableStateOf("English")
            }

            LanguageSpinner(
                placeholder = "Select a language",
                languages = longList,
                selectedLanguage = selectedLongListItem,
                onLanguageSelected = {
                    selectedLongListItem = it
                },
                onExpandChange = {
                    isLongListExpanded = it
                },
                isExpanded = isLongListExpanded
            )

            LanguageSpinner(
                placeholder = "Select a language",
                languages = shortList,
                selectedLanguage = selectedShortListItem,
                onLanguageSelected = {
                    selectedShortListItem = it
                },
                onExpandChange = {
                    isShortListExpanded = it
                },
                isExpanded = isShortListExpanded
            )
        }
    }
}