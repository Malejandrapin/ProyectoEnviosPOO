/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Variables;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Variables.conexion;

/**
 *
 * @author Maira Pinilla
 */
public class empleado extends conexion {

    /**
     * ResultSet rs;
     */
    conexion connet = new conexion();
    java.sql.Connection con = connet.getConexion();

    public boolean registrar(usuarios usr) {
        PreparedStatement ps = null;
        //Conexion conet = new Conexion ();
        //conet.conector();

        String insertsql = "INSERT INTO `empleado` (`identificacion`, `nombreCompleto`,`fechaNacimiento`, `teléfono`, `username`,`contraseña`, `Rol_idRol`) VALUES (?,?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(insertsql);
            ps.setInt(1, usr.getIdUsuario());
            ps.setString(2, usr.getNombreUsuario());
            ps.setDate(3, usr.getFechaNacimiento());
            ps.setString(4, usr.getTelefono());
            ps.setString(5, usr.getUsername());
            ps.setString(6, usr.getContraseña());
            ps.setInt(7, usr.getRol());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean modificar(usuarios usr) {
        PreparedStatement ps = null;
        //Conexion conet = new Conexion ();
        //conet.conector();

        String modificasql = ("UPDATE empleado SET nombreCompleto=?,fechaNacimiento=?, teléfono=?, username=?, contraseña=?, Rol_idRol=? WHERE identificacion=?");

        try {
            ps = con.prepareStatement(modificasql);
            ps.setString(1, usr.getNombreUsuario());
            ps.setDate(2, usr.getFechaNacimiento());
            ps.setString(3, usr.getTelefono());
            ps.setString(4, usr.getUsername());
            ps.setString(5, usr.getContraseña());
            ps.setInt(6, usr.getRol());
            ps.setInt(7, usr.getIdUsuario());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminar(usuarios usr) {
        PreparedStatement ps = null;
        //Conexion conet = new Conexion ();
        //conet.conector();

        String eliminasql = "DELETE FROM empleado WHERE identificacion=?";

        try {
            ps = con.prepareStatement(eliminasql);
            ps.setInt(1, usr.getIdUsuario());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
/** public int logueo(String username)
            
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
           java.sql.Connection con = getConexion();
        
        
        String sql = "SELECT * FROM empleado WHERE  username = ?";
    
        try {
            ps = con.prepareStatement(sql);
            ps.setString(5, username);
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                return rs.getInt(5);
            }
            
            return 5;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    
            return 1;
    }

   public boolean Inicio(usuarios usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();
//identificacion, nombreCompleto, fechaNacimiento, teléfono, username, contraseña, Rol_idRol 
        String sql = "SELECT identificacion, nombreCompleto, fechaNacimiento, teléfono, username, contraseña, Rol_idRol  FROM empleado WHERE username=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(5, usr.getUsername());
            rs = ps.executeQuery();

            if (rs.next()) {
               
                if (usr.getUsername().equals(rs.getString(5))) 
                if (usr.getContraseña().equals(rs.getString(6))) 
              
                {
                    usr.setIdUsuario(rs.getInt(1));
                    usr.setNombreUsuario(rs.getString(2));
                    usr.setFechaNacimiento(rs.getDate(3));
                    usr.setTelefono(rs.getString(4));
                    usr.setUsername(rs.getString(5));
                    usr.setContraseña(rs.getString(6));
                    usr.setRol(rs.getInt(7));
                    return true;
                } else {
                    return false;
                }
            }

            return false;

        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
 */
}

