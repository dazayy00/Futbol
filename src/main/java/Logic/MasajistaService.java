/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Model.Masajista;

/**
 *
 * @author johan
 */
public class MasajistaService {
    public Masajista registrarMasajista(int id, String titulacion, int exp, String nombre, String apellidos, int edad) {
        return new Masajista(id, titulacion, exp, nombre, apellidos, edad);
    }

    public String obtenerInfoProfesional(Masajista masajista) {
        return "ESPECIALISTA: " + masajista.getNombreCompleto() + 
               " (" + masajista.getTitulacion() + ") - " + masajista.getExp() + " años de experiencia.";
    }
}
