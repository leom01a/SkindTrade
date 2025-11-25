🟦 README – SkinTrade (Android + Spring Boot)
📱 SkinTrade – Marketplace de Skins CS2

Aplicación móvil desarrollada en Kotlin + Jetpack Compose, con Room, API externa, microservicios Spring Boot, pruebas unitarias y APK firmado.
Proyecto correspondiente a la Evaluación Parcial 4 / Avance del Examen Final Transversal.

👥 Integrantes

Leonardo Moya

[Nombre del compañero, si corresponde]

🧩 Descripción del proyecto

SkinTrade es una app que permite:

Registrar usuarios (rol usuario / rol dueño)

Mostrar catálogo de skins (almacenado con Room)

Añadir skins a un carrito de compras

Finalizar una compra simulada

Mostrar imagen de un perrito usando una API externa

Conectarse a un microservicio Spring Boot para gestionar usuarios

Visualizar el último usuario guardado

Generar APK firmado para distribución

🧱 Tecnologías utilizadas
Frontend Android

Kotlin

Jetpack Compose

Navigation Compose

Room Database

ViewModel + StateFlow

Retrofit

Material 3

Backend

Java 23 / Spring Boot 3.5.8

Maven Wrapper (mvnw)

H2 Database (modo file)

Otros

JUnit 4

GitHub (control de versiones)

Trello (planificación)

APK firmado (.jks)

🗂️ Estructura del repositorio
SkindTrade/
│
├── app/                  # Proyecto Android completo
│
├── backend/              # Microservicio Spring Boot
│   ├── src/main/java/...
│   ├── src/main/resources/application.properties
│   ├── pom.xml
│   ├── mvnw / mvnw.cmd
│
├── apk/                  # APK firmado
│   └── app-release.apk
│
├── skindtrade_keystore.jks    # Keystore para la firma
│
└── README.md

🔌 Microservicio – Cómo ejecutarlo

El microservicio de usuarios está en la carpeta backend/ y se ejecuta así:

1. Abrir terminal en la carpeta backend
   cd backend

2. Ejecutar Spring Boot con Maven Wrapper
   ./mvnw spring-boot:run


En Windows:

mvnw.cmd spring-boot:run

3. Endpoints disponibles
   Método	Endpoint	Descripción
   POST	/api/usuarios	Crear usuario
   GET	/api/usuarios	Obtener todos los usuarios
   GET	/api/usuarios/{id}	Consultar usuario por ID

Base de datos: H2 persistente
URL consola H2:
http://localhost:8081/h2-console

JDBC URL:

jdbc:h2:file:./data/usuariosdb


Usuario: sa
Password: (vacío)

🌐 API externa utilizada

Uso de Dog API para mostrar imágenes de perros aleatorios en la app:

URL:

https://dog.ceo/api/breeds/image/random


Se consume mediante Retrofit al registrar un usuario.

🛠️ Funciones principales de la app
✔ Registro de usuario

Nombre

Correo

Dirección

Rol (Usuario o Dueño)

Obtiene una imagen desde la API externa

✔ Resumen de usuario

Muestra el último usuario registrado desde Room.

✔ Catálogo de skins

Datos cargados en Room:

Nombre

Precio

Imagen

✔ Carrito de compras

Agregar skins

Calcular total

Mensaje de compra exitosa

✔ Microservicio

El registro en la app funciona local con Room.
El microservicio permite CRUD externo para demostrar backend.

🧪 Pruebas unitarias

Pruebas en:

app/src/test/java/com/example/skintrade/


Incluye:

✔ PruebaBasicaTest.kt

Test mínimo obligatorio de JUnit.

✔ CartViewModelTest.kt

Calcula total vacío

Calcula total con skins agregadas

📦 APK firmado

El APK firmado se encuentra en:

/apk/app-release.apk


Keystore usada en la firma:

/skindtrade_keystore.jks

▶️ Pasos para ejecutar la app Android

Abrir proyecto en Android Studio

Ejecutar en emulador API 33 o superior

Microservicio NO es obligatorio para que la app funcione

Para presentar integración, se puede levantar con Maven

🎯 Estado Final del Proyecto

✔ App funcional
✔ Microservicio operativo
✔ Integración REST
✔ API externa funcionando
✔ Room funcionando
✔ Pruebas unitarias aprobando
✔ APK firmado
✔ Repositorio GitHub completo