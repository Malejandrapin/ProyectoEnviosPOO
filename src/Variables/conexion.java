/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Variables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Maira Pinilla
 */
public class conexion {

    //private final String driver="com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String pass = "12345678";
    private final String url = "jdbc:mysql://localhost:3306/proyectoa";
    private Connection con = null;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Nos conectamos a la bd
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Conexion establecida con la base de datos");
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa

        } // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Eror de conexion establecida");
        }
        return con;

    }

    public void getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}