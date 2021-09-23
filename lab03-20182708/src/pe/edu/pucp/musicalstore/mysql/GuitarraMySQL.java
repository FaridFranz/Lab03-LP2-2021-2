/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.musicalstore.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.musicalstore.config.DBManager;
import pe.edu.pucp.musicalstore.dao.GuitarraDAO;
import productos.cuerda.Guitarra;

/**
 *
 * @author farid huaman
 */
public class GuitarraMySQL implements GuitarraDAO{
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    
    @Override
    public int insertar(Guitarra guitarra) {
        int resultado=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, 
                    DBManager.user, DBManager.password);
            String instruccion = "INSERT INTO instrumento("
                    + "nombre,color,tipo_madera,precio) "
                    + "VALUES(?,?,?,?)";
            ps = con.prepareStatement(instruccion);
            ps.setString(1, guitarra.getNombre());
            ps.setString(2, guitarra.getColor());
            ps.setString(3, guitarra.getTipoMadera());
            ps.setDouble(4, guitarra.getPrecio());
            ps.executeUpdate();
            
            instruccion = "SELECT @@last_insert_id AS id";
            ps = con.prepareStatement(instruccion);
            rs = ps.executeQuery();
            rs.next();
            guitarra.setIdInstrumento(rs.getInt("id"));
            
            instruccion = "INSERT INTO guitarra(id_guitarra,"
                    + "cant_pastillas,tremolo,activo) values"
                    + "(?,?,1,1)";
            
            ps = con.prepareStatement(instruccion);
            ps.setInt(1, guitarra.getIdInstrumento());
            ps.setInt(2, guitarra.getCantPastillas());
            
            ps.executeUpdate();
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{ps.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
   }
    
    @Override
    public int modificar(Guitarra guitarra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int idGuitarra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Guitarra> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
