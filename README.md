# 📚 LiterAlura - Catálogo de Libros CLI

---

## 📁 Índice

* [📚 Título e imagen de portada](#-literalura---catálogo-de-libros-cli)
* [🏅 Insignias](#-insignias)
* [📁 Índice](#-índice)
* [💾 Descripción del proyecto](#-descripción-del-proyecto)
* [🟢 Estado del proyecto](#-estado-del-proyecto)
* [✨ Características de la aplicación y demostración](#-características-de-la-aplicación-y-demostración)
* [🚀 Acceso al proyecto](#-acceso-al-proyecto)
* [💪 Tecnologías utilizadas](#-tecnologías-utilizadas)
* [👥 Personas Contribuyentes](#-personas-contribuyentes)
* [👨‍💻 Personas Desarrolladoras del Proyecto](#-personas-desarrolladoras-del-proyecto)
* [📄 Licencia](#-licencia)
* [✅ Conclusión](#-conclusión)

---

## 💾 Descripción del Proyecto

**LiterAlura** es una aplicación de consola desarrollada en Java que permite buscar, registrar y consultar libros utilizando la API pública de Gutendex. Los datos se almacenan en una base de datos PostgreSQL mediante Spring Data JPA. Es ideal para usuarios que desean explorar literatura clásica y gestionar un catálogo de libros de forma sencilla y eficiente desde la terminal.

---

## 🟢 Estado del Proyecto

El proyecto se encuentra en una fase funcional con las principales características implementadas. Se planean mejoras en la interfaz, filtros avanzados y exportación de datos en futuras versiones.

---

## ✨ Características de la Aplicación y Demostración

* 🔍 Buscar libros por título desde la API de Gutendex
* 💾 Guardar libros consultados en una base de datos local
* 📃 Listar todos los libros registrados
* 🧑‍💼 Filtrar por autor o por idioma
* 📊 Mostrar la cantidad de libros por idioma
* 📅 Consultar autores vivos en un año determinado

Ejemplo de uso:
*** LiterAlura - Catálogo de Libros ***

Buscar libro por título

Listar libros registrados

Listar libros por idioma

Buscar libros por autor

Mostrar cantidad de libros por idioma

Mostrar autores vivos en un año

Salir
Seleccione una opción:

yaml
Copy
Edit

---

## 🚀 Acceso al Proyecto

1. Clona el repositorio:

```bash
git clone https://github.com/tu-usuario/literalura.git
cd literalura
Asegúrate de tener instalado:

Java 17+

Maven

PostgreSQL (y crea la base de datos alura_series)

Configura las credenciales en application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:postgresql://localhost:5432/alura_series
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
Ejecuta el proyecto:

bash
Copy
Edit
mvn clean install
mvn spring-boot: run
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



