/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.musicalstore.main;

import pe.edu.pucp.musicalstore.dao.GuitarraDAO;
import pe.edu.pucp.musicalstore.mysql.GuitarraMySQL;
import productos.cuerda.Guitarra;

/**
 *
 * @author farid
 */
public class Principal {
    public static void main(String[] args){
        GuitarraDAO daoEmpleado = new GuitarraMySQL();
        Guitarra gui1 = null;
        Guitarra gui2 = null;
        try{
            gui1 = new Guitarra("Slash","Rojo","Caoba",5,true,3000.0);
            gui2 = new Guitarra("Slashed","Verde","Caoba",8,true,4000.0);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        daoEmpleado.insertar(gui1);
        daoEmpleado.insertar(gui2);
    }
}
