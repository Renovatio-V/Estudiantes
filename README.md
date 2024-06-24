# Sistema de Estudiantes con Java y MySQL

## Descripción
Esta aplicación es un sistema de gestión de estudiantes desarrollado en Java y utilizando una base de datos MySQL. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una base de datos de estudiantes mediante una interfaz de línea de comandos.

## Características
- **Listar Estudiantes**: Muestra una lista de todos los estudiantes registrados.
- **Buscar Estudiante**: Permite buscar un estudiante por su ID.
- **Agregar Estudiante**: Permite añadir un nuevo estudiante a la base de datos.
- **Modificar Estudiante**: Permite actualizar la información de un estudiante existente.
- **Eliminar Estudiante**: Permite eliminar un estudiante de la base de datos.

## Requisitos
- Java JDK 16 o superior
- MySQL

## Instalación
1. Clona el repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   ```
   
2. Navega al directorio del proyecto:
  ```bash
  cd tu_repositorio
  ```
3. Configura la base de datos MySQL. Crea una base de datos llamada estudiantes_db y actualiza las credenciales en el archivo DH/conexion/Conexion.java si es necesario:
  ```bash
  var baseDatos = "estudiantes_db";
  var url = "jdbc:mysql://localhost:3306/" + baseDatos;
  var usuario = "root";
  var password = "admin";
  ```




