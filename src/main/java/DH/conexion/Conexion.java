package DH.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConnection(){
        Connection connection = null;
        var baseDatos = "estudiantes_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "admin";
        //Cargamos la clase del driver mysql en memoria

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocurrio un error en la conexión: " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConnection();
        if (conexion != null){
            System.out.println("Conexion exitosa: " + conexion);
        } else {
            System.out.println("Error al conectarse");
        }
    }
}
