import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSpinner(
    modifier: Modifier = Modifier,
    placeholder: String,
    selectedLanguage: String,
    languages: List<String>,
    isExpanded: Boolean,
    onExpandChange: (Boolean) -> Unit,
    onLanguageSelected: (String) -> Unit,
) {
    ExposedDropdownMenuBox(
        modifier = modifier.background(Color.White),
        expanded = isExpanded,
        onExpandedChange = onExpandChange
    ) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            value = selectedLanguage,
            onValueChange = {},
            readOnly = true,
            decorationBox = { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = selectedLanguage,
                    shape = CircleShape,
                    innerTextField = innerTextField,
                    enabled = true,
                    singleLine = true,
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    visualTransformation = VisualTransformation.None,
                    placeholder = {
                        Text(
                            text = placeholder,
                        )
                    },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                    },
                    contentPadding = PaddingValues(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                )
            }
        )

        ExposedDropdownMenu(
            modifier = Modifier.width(100.dp)
                .background(Color.White)
                .height(300.dp),
            expanded = isExpanded,
            onDismissRequest = {
                onExpandChange.invoke(false)
            }
        ) {
            languages.forEach { language ->
                DropdownMenuItem(
                    modifier = Modifier.background(Color.White),
                    text = {
                        Text(
                            text = language,
                        )
                    },
                    onClick = {
                        onExpandChange.invoke(false)
                        onLanguageSelected.invoke(language)
                    }
                )
            }
        }
    }
}