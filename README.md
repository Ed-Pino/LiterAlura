# 📚 LiterAlura - Catálogo de Libros CLI

---

## 📁 Índice

- [📚 Título e imagen de portada](#-literalura---catálogo-de-libros-cli)
- [🏅 Insignias](#-insignias)
- [📁 Índice](#-índice)
- [💾 Descripción del proyecto](#-descripción-del-proyecto)
- [🟢 Estado del proyecto](#-estado-del-proyecto)
- [✨ Características implementadas](#-características-implementadas)
- [🚀 Acceso al proyecto](#-acceso-al-proyecto)
- [💻 Vista web con Thymeleaf (en desarrollo)](#-vista-web-con-thymeleaf-en-desarrollo)
- [💪 Tecnologías utilizadas](#-tecnologías-utilizadas)
- [👥 Personas Contribuyentes](#-personas-contribuyentes)
- [👨‍💻 Personas Desarrolladoras del Proyecto](#-personas-desarrolladoras-del-proyecto)
- [📄 Licencia](#-licencia)
- [✅ Conclusión](#-conclusión)

---

## 💾 Descripción del Proyecto

**LiterAlura** es una aplicación Java basada en consola que permite explorar literatura clásica mediante la API de [Gutendex](https://gutendex.com/). Integra una base de datos PostgreSQL utilizando Spring Boot y JPA para almacenar los libros consultados.

---

## 🟢 Estado del Proyecto

✔️ Proyecto en funcionamiento (CLI)  
🛠 En desarrollo: interfaz web con Thymeleaf  
📌 Futuras mejoras: filtros dinámicos, exportación de datos, integración web completa.

---

## ✨ Características Implementadas

- 🔍 Buscar libros por título desde Gutendex y guardarlos en la base de datos  
- 💾 Verificar si un libro ya fue registrado  
- 📃 Listar todos los libros almacenados  
- 🌐 Buscar libros por idioma  
- 👤 Buscar libros por autor (ignorando mayúsculas/minúsculas)  
- 📊 Mostrar cantidad total de libros agrupados por idioma  
- 📅 Consultar autores vivos en un año determinado  
- ♻️ Evitar duplicidad de autores al buscar por año  
- 👨‍🏫 Visualizar autores con nombre, nacimiento y defunción (o “vivo”)  
- 📦 Uso de DTOs para mostrar solo información relevante  
- 🧱 Arquitectura MVC: Controller, Service, Repository  
- 🌐 Integración inicial con frontend web usando Thymeleaf

---

## 🚀 Acceso al Proyecto

### 🔧 Requisitos

- Java 17+
- Maven
- PostgreSQL

### 🧬 Clonar y configurar

```bash
git clone https://github.com/Ed-Pino/LiterAlura.git
cd LiterAlura

Crea la base de datos alura_series en PostgreSQL y configura:
# src/main/resources/application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/alura_series
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña

▶️ Ejecutar el proyecto
bash
mvn clean install
mvn spring-boot:run

💻 Vista Web con Thymeleaf (en desarrollo)
Se ha comenzado la implementación de vistas HTML con Thymeleaf. Próximamente podrás:

Buscar libros desde el navegador

Visualizar listado de libros y autores

Realizar búsquedas por autor o idioma desde el frontend


💪 Tecnologías utilizadas
Java 17

Spring Boot & Spring Data JPA

PostgreSQL

Gutendex API

CLI con Scanner

Jackson para procesamiento JSON

Maven como gestor de dependencias

👥 Personas Contribuyentes
Aún no se han registrado colaboradores externos. ¡Estás invitado a participar!

👨‍💻 Personas Desarrolladoras del Proyecto
Ed Pino - GitHub

📄 Licencia
Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

✅ Conclusión
LiterAlura es una forma práctica de descubrir libros clásicos, almacenar un catálogo personal y explorar estadísticas literarias directamente desde la consola. ¡Perfecto para amantes de la lectura y desarrolladores en formación!



