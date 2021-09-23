/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.musicalstore.dao;

import java.util.ArrayList;
import productos.cuerda.Guitarra;

/**
 *
 * @author Farid Huaman
 */
public interface GuitarraDAO {
    int insertar(Guitarra guitarra);
    int modificar(Guitarra guitarra);
    int eliminar(int id_guitarra);
    ArrayList<Guitarra> listarTodas();
}
