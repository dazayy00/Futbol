/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Model.Entrenador;

/**
 *
 * @author johan
 */
public class EntrenadorService {
    public Entrenador registrarEntrenador(String idFederacion, int id, String nombre, String apellidos, int edad) {
        if (idFederacion == null || idFederacion.isEmpty()) {
            throw new IllegalArgumentException("El ID de federación es obligatorio");
        }
        return new Entrenador(idFederacion, id, nombre, apellidos, edad);
    }

    public String verificarLicencia(Entrenador entrenador) {
        return "Licencia Federativa " + entrenador.getIdFederacion() + " verificada para " + entrenador.getNombre();
    }
}
