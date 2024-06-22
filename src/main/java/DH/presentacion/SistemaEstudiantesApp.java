package DH.presentacion;

import DH.datos.EstudianteDAO;
import DH.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        var estudianteDao = new EstudianteDAO();

        while(!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDao);
            } catch (Exception e) {
                System.out.println("Error al ejecutar el metodo 'Ejecutar Opciones': " + e.getMessage());
            }
            System.out.println();
        }// end while
    }
    private static void mostrarMenu(){
        System.out.println("""
                *** SISTEMA DE ESTUDIANTES ***
                1. Listar Estudiantes
                2. Buscar Estudiante
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                Elige una opcion: 
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> {//Listar Estudiantes
                System.out.println("Listado de Estudiantes: ");
                var estudiantes = estudianteDAO.listarEstudiantes();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> {//Buscar Estudiante por id
                System.out.println("Introduce el ID del Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if(encontrado) {
                    System.out.println("Estudiante encontrado: " +  estudiante);
                } else {
                    System.out.println("Estudiante NO encontrado: " + estudiante);
                }
            }
            case 3 -> {//AGregar Estudiante
                System.out.println("Agregar Estudiante: ");
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                //Crear el objeto
                var estudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDAO.agregarEstudiante(estudiante);
                if(agregado){
                    System.out.println("Estudiante agregado: " + estudiante);
                } else {
                    System.out.println("Estudiante NO agregado: " + estudiante);
                }
            }
            case 4 -> {//Modificar Estudiante
                System.out.println("Modificar Estudiante: ");
                System.out.println("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                //CREAR objeto
                var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var modificado = estudianteDAO.modificarEstudiante(estudiante);
                if(modificado){
                    System.out.println("Estudiante modificado: " + estudiante);
                } else {
                    System.out.println("Estudiante NO modificado: " + estudiante);
                }
            }
            case 5 -> {//Eliminar Estudiante
                System.out.println("Eliminar Estudiante: ");
                System.out.println("ID Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                if (eliminado){
                    System.out.println("Estudiante Eliminado: " + estudiante);
                } else {
                    System.out.println("Estudiante NO elimanado: " + estudiante);
                }
            }
            case 6 -> {//Salir
                System.out.println("Hasta pronto! ");
                salir = true;
            }
            default ->
                System.out.println("Opcion no reconocida! ");

        }
        return salir;
    }
}