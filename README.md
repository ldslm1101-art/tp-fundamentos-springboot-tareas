# TP Fundamentos de Spring Boot - Gestor de Tareas

Este es un Trabajo Práctico para la materia Programación III de la Tecnicatura Universitaria en Programación (UTN).

## 📝 Descripción del Proyecto

El objetivo de este proyecto es construir una aplicación de gestión de tareas (To-Do List) utilizando los conceptos fundamentales de Spring Boot. La aplicación no utiliza una base de datos real, sino que simula el almacenamiento en memoria para centrarse en la arquitectura de capas, la inyección de dependencias y la gestión de configuración.

El sistema permite:
* Agregar nuevas tareas con descripción y prioridad.
* Listar todas las tareas, las pendientes y las completadas.
* Marcar tareas como completadas.
* Obtener estadísticas sobre las tareas.

## 🛠️ Tecnologías Utilizadas

* **Java 17+**
* **Spring Boot 3.x**
* **Maven**
* **Lombok** (para reducir código boilerplate)

## 🚀 Cómo Clonar y Ejecutar el Proyecto

### 1. Clonar el Repositorio

```bash
git clone (Pega aquí la URL de tu repositorio GitHub)
cd tareas
```

### 2. Ejecutar la Aplicación (vía Maven)

La forma más sencilla de ejecutar el proyecto es usando el *wrapper* de Maven incluido.

```bash
# En Windows
./mvnw spring-boot:run

# En Linux o macOS
./mvnw spring-boot:run
```

La aplicación se iniciará en modo consola y ejecutará el flujo de prueba definido en `TareasApplication.java`.

## 🔃 Gestión de Perfiles (Profiles)

Este proyecto utiliza perfiles de Spring para gestionar diferentes configuraciones para entornos de desarrollo (`dev`) y producción (`prod`).

Para cambiar entre perfiles, debes editar el archivo: `src/main/resources/application.properties`

Cambia el valor de la propiedad `spring.profiles.active`:

```properties
# Para activar el perfil de desarrollo (límite 10 tareas, logs DEBUG)
spring.profiles.active=dev

# Para activar el perfil de producción (límite 1000 tareas, logs ERROR)
spring.profiles.active=prod
```

## 📸 Capturas de Pantalla de la Ejecución

Aquí se muestran las salidas de consola para ambos perfiles.

### Ejecución en Perfil `dev`

(Pega aquí tu captura de pantalla de la consola ejecutando con el perfil `dev`)

### Ejecución en Perfil `prod`

(Pega aquí tu captura de pantalla de la consola ejecutando con el perfil `prod`)

## 💡 Conclusiones Personales

(Escribe aquí 2 o 3 párrafos sobre lo que aprendiste. Por ejemplo: "En este TP pude aplicar en la práctica el concepto de Inversión de Control (IoC)...", "Entendí la importancia de desacoplar la configuración con @Value...", "La gestión de perfiles me pareció muy útil para...").

## 👨‍💻 Autor

* **Nombre:** Lautaro Montenegro
* **Legajo:** 51208
* **Mail:** lds.lm1101@gmail.com