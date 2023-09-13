package com.example.registropersonascompose.ui.person

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.example.registropersonascompose.Nav.AppScreens
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonsConsultScreen(
    viewModel: PersonViewModel = hiltViewModel(),
    navController: NavController
)
{
    Scaffold (
        topBar = { TopAppBar(title = { Text(text = "Registro personas") },
            modifier = Modifier.shadow(8.dp),
            colors =TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
        )
        },
        content = ({
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 50.dp,start = 15.dp, end= 10.dp, bottom = 50.dp)
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                OutlinedButton(modifier = Modifier.fillMaxWidth(),onClick = {
                    navController.navigate(route = AppScreens.OccupationsScreen.route)
                }) {
                    Icon(imageVector = Icons.Default.CheckCircle, contentDescription ="Guardar" )
                    Text("Registro Ocupaciones")
                }

                Spacer(modifier = Modifier.height(15.dp))
                OutlinedButton(modifier = Modifier.fillMaxWidth(),onClick = {
                    navController.navigate(route = AppScreens.FormScreen.route)
                }) {
                    Icon(imageVector = Icons.Default.CheckCircle, contentDescription ="Guardar" )
                    Text("Registro Personas")
                }
                PersonConsult(viewModel)
            }



        })
    )

}
@Composable
fun PersonConsult(
    personViewModel: PersonViewModel = hiltViewModel(),
    occupationViewModel: OccupationViewModel = hiltViewModel()
)
{
    val persons by personViewModel.persons.collectAsStateWithLifecycle()
    
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
    ) {
        items(persons) { person ->
           Card(modifier = Modifier
               .padding(10.dp)
           ) {
                Column {

                    Text(text = """
                        Telefono  : ${person.name}
                        Telefono  : ${person.telephone}
                        Celular   : ${person.cellphone}
                        Email     : ${person.email}
                        Direccion : ${person.direccion}
                        Ocupacion : ${person.ocupationId}    
                    """.trimIndent(),modifier = Modifier.padding(10.dp))
                }

           }
        }
    }
}


