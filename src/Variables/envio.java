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
public class envio extends conexion{
    conexion connet = new conexion ();
    java.sql.Connection con = connet.getConexion();   
    
    
    public boolean registrar (usuarios usr)
    {
       PreparedStatement ps = null;
        //Conexion conet = new Conexion ();
        //conet.conector();
       
       
        String insertsql="INSERT INTO `envio` (`Id_envio`, `Id_Cliente`, `Id_Empleado`, `nombreD`, `Identificacion_D`, `Fecha`, `Telefono`, `Direccion`, `Ciudad_origen`, `Ciudad_destino`, `Observaciones`) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        
        try {
            ps = con.prepareStatement(insertsql);
            ps.setInt(1, usr.getIdEnvio());
            ps.setInt(2, usr.getIdUsuario());
            ps.setInt(3, usr.getIdUsuario());
            ps.setString(4, usr.getNombreUsuario());
            ps.setInt(5, usr.getIdUsuario());
            ps.setDate(6, usr.getFechaNacimiento());
            ps.setString(7, usr.getTelefono());
            ps.setString(8, usr.getDireccionUsuario());
            ps.setString(9, usr.getCiudadOrigen());
            ps.setString(10, usr.getCiudadDestino());
            ps.setString(11, usr.getObservaciones());
            ps.execute();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(envio.class.getName()).log(Level.SEVERE, null, ex);
            return false; 
        }
    }
    public boolean modificar (usuarios usr)
    {
       PreparedStatement ps = null;
        //Conexion conet = new Conexion ();
        //conet.conector();
       
       
        String modificasql=("UPDATE envio SET Id_Cliente=?, Id_Empleado=?, nombreD=?, Identificacion_D=?, Fecha=?, Telefono=?, Direccion=?, Ciudad_origen=?, Ciudad_destino=?, Observaciones=? WHERE Id_envio=?");
        
        try {
            ps = con.prepareStatement(modificasql);
            ps.setInt(1, usr.getIdUsuario());
            ps.setInt(2, usr.getIdUsuario());
            ps.setString(3, usr.getNombreUsuario());
            ps.setInt(4, usr.getIdUsuario());
            ps.setDate(5, usr.getFechaNacimiento());
            ps.setString(6, usr.getTelefono());
            ps.setString(7, usr.getDireccionUsuario());
            ps.setString(8, usr.getCiudadOrigen());
            ps.setString(9, usr.getCiudadDestino());
            ps.setString(10, usr.getObservaciones());
            ps.setInt(11, usr.getIdEnvio());
            ps.execute();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(envio.class.getName()).log(Level.SEVERE, null, ex);
            return false; 
        }
    }
    public boolean eliminar (usuarios usr)
    {
       PreparedStatement ps = null;
        //Conexion conet = new Conexion ();
        //conet.conector();
       
       
        String eliminasql="DELETE FROM envio WHERE Id_envio=?" ;
        
        try {
            ps = con.prepareStatement(eliminasql);        
            ps.setInt(1, usr.getIdEnvio());
            ps.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(envio.class.getName()).log(Level.SEVERE, null, ex);
            return false; 
        }
    }
}
