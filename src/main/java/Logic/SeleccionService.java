/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Model.*;
import java.util.ArrayList;
import java.util.List;

public class SeleccionService {
    
    private List<SeleccionFutbol> integrantes;

    public SeleccionService() {
        this.integrantes = new ArrayList<>();
    }

    public void agregarIntegrante(SeleccionFutbol integrante) {
        this.integrantes.add(integrante);
    }

    public String obtenerNominaCompleta() {
        StringBuilder sb = new StringBuilder("--- NOMINA OFICIAL ---\n");
        for (SeleccionFutbol integrante : integrantes) {
            sb.append(integrante.getNombreCompleto())
              .append(" | ").append(integrante.getDetallesEspecificos())
              .append("\n");
        }
        return sb.toString();
    }

    
    public String planificarConcentracion() {
        StringBuilder sb = new StringBuilder(">> PLAN DE CONCENTRACIÓN:\n");
        integrantes.forEach(i -> sb.append(" * ").append(i.concentrarse()).append("\n"));
        return sb.toString();
    }

    public String gestionarViaje() {
        StringBuilder sb = new StringBuilder(">> ITINERARIO DE VIAJE:\n");
        integrantes.forEach(i -> sb.append(" * ").append(i.viajar()).append("\n"));
        return sb.toString();
    }

    public String iniciarEntrenamiento() {
        StringBuilder sb = new StringBuilder(">> EN EL CAMPO:\n");
        integrantes.forEach(i -> sb.append(" * ").append(i.trabajar()).append("\n"));
        return sb.toString();
    }
}