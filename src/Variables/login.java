/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Variables;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maira Pinilla
 */
public class login extends conexion {

    conexion connet = new conexion();
    java.sql.Connection con = connet.getConexion();

   /**  public boolean logueo(usuarios usr) {

      PreparedStatement ps = null;
        ResultSet rs = null;
        String loguesql = "SELECT identificacion, nombreCompleto, fechaNacimiento, teléfono, username, contraseña, Rol_idRol FROM empleado WHERE username=?";
        try {

            ps = con.prepareStatement(loguesql);
            ps.setString(1, usr.getUsername());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getContraseña().equals(rs.getString(6))) {
                    usr.setIdUsuario(rs.getInt(1));
                    usr.setNombreUsuario(rs.getString(2));
                    usr.setFechaNacimiento(rs.getDate(3));
                    usr.setTelefono(rs.getString(4));
                    usr.setRol(rs.getInt(7));
                    return true;
                } else {
                    return false;
                }
            }
                return false;

            }catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            return false; 
           }
        }
*/    
}
