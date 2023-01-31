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
public class cliente extends conexion{
    /**ResultSet rs;*/
    conexion connet = new conexion ();
    java.sql.Connection con = connet.getConexion();
   
public boolean registrar (usuarios usr)
    {
       PreparedStatement ps = null;
        //Conexion conet = new Conexion ();
        //conet.conector();
       
       
        String insertsql="INSERT INTO `cliente` (`identificacion`, `nombreCompleto`,`fechaNacimiento`, `teléfono`, `dirección`, `Ciudad_idCiudad`) VALUES (?,?,?,?,?,?);";
        
        try {
            ps = con.prepareStatement(insertsql);
            ps.setInt(1, usr.getIdUsuario());
            ps.setString(2, usr.getNombreUsuario());
            ps.setDate(3, usr.getFechaNacimiento());
            ps.setString(4, usr.getTelefono());
            ps.setString(5, usr.getDireccionUsuario());
            ps.setInt(6, usr.getCiudad());
            ps.execute();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false; 
        }
    }
public boolean modificar (usuarios usr)
    {
       PreparedStatement ps = null;
        //Conexion conet = new Conexion ();
        //conet.conector();
       
       
        String modificasql=("UPDATE cliente SET nombreCompleto=?,fechaNacimiento=?, teléfono=?, dirección=?, Ciudad_idCiudad=? WHERE identificacion=?") ;
        
        try {
            ps = con.prepareStatement(modificasql);        
            ps.setString(1, usr.getNombreUsuario());
            ps.setDate(2, usr.getFechaNacimiento());
            ps.setString(3, usr.getTelefono());
            ps.setString(4, usr.getDireccionUsuario());
            ps.setInt(5, usr.getCiudad());
            ps.setInt(6, usr.getIdUsuario());
            ps.execute();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false; 
        }
    }
  public boolean eliminar (usuarios usr)
    {
       PreparedStatement ps = null;
        //Conexion conet = new Conexion ();
        //conet.conector();
       
       
        String eliminasql="DELETE FROM cliente WHERE identificacion=?" ;
        
        try {
            ps = con.prepareStatement(eliminasql);        
            ps.setInt(1, usr.getIdUsuario());
            ps.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false; 
        }
    }
  
}
