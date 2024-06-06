# Sistema-FitAdmin
Trabajo final del 3er cuatrimestre de la UTN-MDP (Tecnicatura en Programacion)

# FitAdmin

FitAdmin es un software versátil y rápido de control y gestión de gimnasios diseñado para propietarios de gimnasios pequeños y medianos. Ofrece una gama de soluciones para gestionar clientes, actividades, cuotas, ingresos mediante QR y más, modernizando y facilitando la administración del gimnasio.

## Tabla de Contenidos
- [Descripción](#descripción)
- [Requisitos del Sistema](#requisitos-del-sistema)
- [Instalación](#instalación)
- [Uso](#uso)
- [Características](#características)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Licencia](#licencia)
- [Contacto](#contacto)

## Descripción

FitAdmin resuelve el problema de implementar una solución integral para la gestión de gimnasios. Con FitAdmin, los dueños de gimnasios pueden:

- Gestionar clientes.
- Administrar actividades y cuotas.
- Controlar el acceso de los clientes mediante códigos QR.
- Enviar y recibir correos electrónicos.
- Subir y bajar fotos y PDFs desde Dropbox.
- Generar PDFs y estadísticas.

## Requisitos del Sistema

- **Java**: JDK 21.
- **Base de Datos**: Cuenta en Dropbox para almacenamiento de datos.
- **IDE**: Proyecto desarrollado en IntelliJ IDEA.

## Instalación

1. **Abre el proyecto en IntelliJ IDEA**.
2. **Configura Dropbox**:
   - Asegúrate de tener una cuenta en Dropbox y configura las credenciales necesarias en el proyecto.
3. **Configura Gmail**
   - Asegúrate de tener una cuenta en Gmail y configura las credenciales necesarias en el proyecto
5. **Compila y ejecuta el proyecto desde IntelliJ IDEA**.

## Uso

La interfaz de usuario de FitAdmin es intuitiva y fácil de entender. A continuación, se describen las principales funcionalidades:

### Clientes:
- Crear clientes.
- Archivar clientes.
- Cargar rutinas.
- Enviar rutinas por correo electrónico.

### Estadísticas:
- Visualización de diferentes estadísticas del gimnasio.

### Ingresos:
- Generación de códigos QR para habilitar o no el acceso de los usuarios.

La interfaz incluye botones para acceder a estas funcionalidades y utiliza ventanas emergentes (pop-ups) para notificaciones, errores y otras situaciones.

## Características

- Gestión de clientes.
- Generación y escaneo de códigos QR.
- Envío y recepción de correos electrónicos.
- Subida y bajada de fotos y PDFs desde Dropbox.
- Generación de PDFs.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:


Para representar la estructura del proyecto en un archivo Markdown (.md), puedes utilizar un bloque de código con un formato similar al que proporcionaste. Aquí tienes cómo se vería:


FitAdmin/  
├── java  
│   ├── API  
│   ├── Enum  
│   ├── Exceptions  
│   ├── GUI  
│   │   └── PopUps  
│   ├── Interfaces  
│   ├── JavaUtiles  
│   ├── Module  
│   └── Main  
└── resources  
    └── Images  
    
## Licencia

Este proyecto está licenciado bajo la licencia especificada en el repositorio.

## Contacto

Para preguntas o soporte, puedes contactar a f69343696@gmail.com. 
