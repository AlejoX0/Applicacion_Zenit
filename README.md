# Zenit Digital

Aplicación Android nativa construida con **Kotlin** y **Jetpack Compose** siguiendo Material Design 3. Incluye pantallas para inicio de sesión, menú principal, catálogo con filtros, información institucional, galería, video promocional y accesos a redes sociales.

## Estructura rápida
- `app/src/main/java/com/zenitdigital/app/MainActivity.kt`: navegación y todas las pantallas Compose.
- `app/src/main/java/com/zenitdigital/app/ui/theme`: colores, tipografía y tema M3.
- `app/src/main/res`: manifiesto, recursos de la app y espacios para que agregues tus imágenes.

## Cómo probar
1. Abre el proyecto en Android Studio Flamingo o superior.
2. Si el wrapper no descarga automáticamente el binario de Gradle (el entorno de preparación no tuvo acceso a internet), regenera el wrapper con `gradle wrapper --gradle-version 8.7` o utiliza la versión de Gradle local de Android Studio.
3. Sincroniza el proyecto y ejecuta en un emulador/ dispositivo con Android 7.0+ (API 24).
4. Usa las credenciales demo indicadas en la pantalla de login para acceder al menú.

## Personalización
- Sustituye los cuadros de color en el catálogo y la galería con tus imágenes (cargas en `res/drawable` o mediante URL).
- Cambia el `videoUrl` en `VideoScreen` por tu enlace real.
- Ajusta los enlaces en `SocialScreen` con tus redes oficiales.
