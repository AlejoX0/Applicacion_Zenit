package com.zenitdigital.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zenitdigital.app.ui.theme.ZenitDigitalTheme
import com.zenitdigital.app.ui.theme.heroGradient
import com.zenitdigital.app.ui.theme.CardOverlay
import com.zenitdigital.app.ui.theme.DeepSurface
import com.zenitdigital.app.ui.theme.AccentGreen
import com.zenitdigital.app.ui.theme.PrimaryBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZenitDigitalTheme {
                ZenitDigitalApp()
            }
        }
    }
}

data class Product(
    val name: String,
    val description: String,
    val tag: String,
    val priceHint: String
)

data class SocialLink(val title: String, val url: String)

enum class ZenitDestination(val route: String) {
    Login("login"),
    Home("home"),
    Products("products"),
    Company("company"),
    Gallery("gallery"),
    Video("video"),
    Social("social")
}

@Composable
fun ZenitDigitalApp() {
    val navController = rememberNavController()
    Surface(modifier = Modifier.fillMaxSize()) {
        NavHost(navController = navController, startDestination = ZenitDestination.Login.route) {
            composable(ZenitDestination.Login.route) {
                LoginScreen(onLogin = { navController.navigate(ZenitDestination.Home.route) })
            }
            composable(ZenitDestination.Home.route) {
                HomeScreen(navController)
            }
            composable(ZenitDestination.Products.route) {
                ProductsScreen()
            }
            composable(ZenitDestination.Company.route) {
                CompanyScreen()
            }
            composable(ZenitDestination.Gallery.route) {
                GalleryScreen()
            }
            composable(ZenitDestination.Video.route) {
                VideoScreen()
            }
            composable(ZenitDestination.Social.route) {
                SocialScreen()
            }
        }
    }
}

@Composable
fun LoginScreen(onLogin: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = heroGradient)
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(96.dp),
                color = Color.White.copy(alpha = 0.1f),
                shape = CircleShape,
                tonalElevation = 4.dp
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_dialog_info),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(42.dp)
                    )
                }
            }
            Spacer(Modifier.height(24.dp))
            Text(
                text = "Zenit Digital",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Cuenta demo: demo@zenit.com / 123456",
                color = Color.White.copy(alpha = 0.8f)
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Innovación, ingeniería y creatividad para tu negocio.",
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(32.dp))
            Button(
                onClick = onLogin,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = PrimaryBlue),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Ingresar", modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    val cards = listOf(
        Triple("Catálogo de productos", "Explora hardware, software y soluciones cloud", ZenitDestination.Products.route),
        Triple("Información de la empresa", "Historia, misión y cultura", ZenitDestination.Company.route),
        Triple("Galería inspiradora", "Espacios para tus mejores fotos", ZenitDestination.Gallery.route),
        Triple("Video promocional", "Comparte tu demo o trailer", ZenitDestination.Video.route),
        Triple("Redes sociales", "Conecta y conversa con la comunidad", ZenitDestination.Social.route)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Menú Principal", fontWeight = FontWeight.Bold) },
                actions = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = AccentGreen
                    )
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = DeepSurface),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(text = "¡Hola!", style = MaterialTheme.typography.titleLarge, color = Color.White)
                        Text(
                            text = "Todo listo para mostrar Zenit Digital con un estilo futurista.",
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }
            items(cards) { card ->
                ElevatedCard(
                    onClick = { navController.navigate(card.third) },
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.elevatedCardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Text(card.first, style = MaterialTheme.typography.titleLarge, color = PrimaryBlue)
                        Spacer(Modifier.height(6.dp))
                        Text(card.second, color = Color.Gray)
                    }
                }
            }
        }
    }
}

@Composable
fun ProductsScreen() {
    var query by remember { mutableStateOf("") }
    val products = remember {
        listOf(
            Product("Solución IoT", "Kit modular para sensores y pasarelas edge.", "Hardware", "Desde $249"),
            Product("Suite Mobile", "Aplicaciones nativas listas para personalizar.", "Software", "Bajo demanda"),
            Product("Cloud Zen", "Infraestructura lista para escalar con Kubernetes.", "Cloud", "Suscripción"),
            Product("IA Studio", "Modelos y copilotos entrenados para tu negocio.", "IA", "Demo en vivo")
        )
    }

    val filtered = products.filter { it.name.contains(query, true) || it.tag.contains(query, true) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Catálogo de productos", fontWeight = FontWeight.Bold) },
                actions = { Icon(imageVector = Icons.Default.FilterList, contentDescription = null) }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Filtrar por nombre o categoría") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(Modifier.height(12.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(filtered) { product ->
                    ProductCard(product)
                }
            }
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    ElevatedCard(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.Black.copy(alpha = 0.05f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Espacio para la imagen del producto",
                    color = PrimaryBlue,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(24.dp)
                )
            }
            Spacer(Modifier.height(12.dp))
            Text(product.name, style = MaterialTheme.typography.titleLarge, color = PrimaryBlue)
            Text(product.description, color = Color.Gray)
            Spacer(Modifier.height(6.dp))
            AssistChip(onClick = {}, label = { Text(product.tag) })
            Spacer(Modifier.height(6.dp))
            Text(product.priceHint, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun CompanyScreen() {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Identidad Zenit") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Surface(
                    color = DeepSurface,
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Text("Quiénes somos", color = Color.White, style = MaterialTheme.typography.titleLarge)
                        Text(
                            "Equipo multidisciplinario de tecnología, diseño y estrategia.",
                            color = Color.White.copy(alpha = 0.85f)
                        )
                    }
                }
            }
            item {
                CardBlock(
                    title = "Misión",
                    body = "Crear soluciones digitales que unan rendimiento con una estética impecable."
                )
            }
            item {
                CardBlock(
                    title = "Visión",
                    body = "Ser el partner que convierte ideas audaces en experiencias memorables."
                )
            }
            item {
                CardBlock(
                    title = "Valores",
                    body = "Transparencia, foco en el usuario, prototipado rápido y mejora continua."
                )
            }
        }
    }
}

@Composable
fun CardBlock(title: String, body: String) {
    ElevatedCard(shape = RoundedCornerShape(18.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleLarge, color = PrimaryBlue)
            Text(body, color = Color.Gray)
        }
    }
}

@Composable
fun GalleryScreen() {
    val gallerySpots = listOf("Lobby futurista", "Equipos en acción", "Presentaciones", "Momentos de equipo")
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Galería fotográfica") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(gallerySpots) { title ->
                ElevatedCard(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.elevatedCardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(CardOverlay),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Espacio para imagen: $title",
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(20.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.PhotoLibrary, contentDescription = null, tint = PrimaryBlue)
                            Spacer(Modifier.width(6.dp))
                            Text(title, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun VideoScreen() {
    val context = LocalContext.current
    val videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Video Promocional") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Listo para enlazar tu video: usa YouTube, Vimeo o un streaming propio.",
                style = MaterialTheme.typography.bodyLarge
            )
            ElevatedCard(shape = RoundedCornerShape(18.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(Color.Black.copy(alpha = 0.05f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Movie,
                            contentDescription = null,
                            tint = PrimaryBlue,
                            modifier = Modifier.size(64.dp)
                        )
                    }
                    Spacer(Modifier.height(12.dp))
                    Text("URL actual: $videoUrl", color = Color.Gray)
                    Spacer(Modifier.height(8.dp))
                    Button(onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
                        context.startActivity(intent)
                    }) {
                        Text("Reproducir video en el navegador")
                    }
                }
            }
        }
    }
}

@Composable
fun SocialScreen() {
    val context = LocalContext.current
    val links = listOf(
        SocialLink("Sitio web", "https://zenit.digital"),
        SocialLink("LinkedIn", "https://www.linkedin.com"),
        SocialLink("Instagram", "https://www.instagram.com"),
        SocialLink("YouTube", "https://www.youtube.com")
    )
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Redes Sociales") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            links.forEach { link ->
                ElevatedCard(onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link.url))
                    context.startActivity(intent)
                }) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(link.title, style = MaterialTheme.typography.titleLarge)
                            Text(link.url, color = Color.Gray, fontSize = 12.sp)
                        }
                        Icon(imageVector = Icons.Default.Public, contentDescription = null)
                    }
                }
            }
        }
    }
}
