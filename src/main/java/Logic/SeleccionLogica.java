/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Model.*;
import java.util.ArrayList;

/**
 *
 * @author johan
 */
public class SeleccionLogica {
    private ArrayList<SeleccionFutbol> integrantes;

    public SeleccionLogica(){
        this.integrantes = new ArrayList<>();
        
    }
    
    public void agregarFutbolista(int id, int dorsal, String demarcacion, String nombre, String apellidos, int edad){
        Futbolista f = new Futbolista(id, dorsal, demarcacion, nombre, apellidos, edad);
        this.integrantes.add(f);
    }
    
    public void agregarEntrenador(String idFederacion, int id, String nombre, String apellidos, int edad){
        Entrenador e = new Entrenador(idFederacion, id, nombre, apellidos, edad);
        this.integrantes.add(e);
    }
    
    public void agregarMasagista(int id, String titulacion, int exp,  String nombre, String apellidos, int edad){
        Masagista m = new Masagista(id, titulacion, exp, nombre, apellidos, edad);
        this.integrantes.add(m);
    }
    
    public String obtenerListaIntegrantes(){
        StringBuilder sb = new StringBuilder("Lista de integrantes");
        for(SeleccionFutbol integrante : integrantes){
            sb.append(integrante.getNombreCompleto())
                    .append(" ( ").append(integrante.getEdad()).append(" años) ")
                    .append(integrante.getDetallesEspecificos())
                    .append("\n");
        }
        return sb.toString();
    }
    
    public String ejecutarConcentracion(){
        StringBuilder sb = new StringBuilder("Iniciando concentracion"); 
        for(SeleccionFutbol integrante : integrantes){
            sb.append(integrante.concentrarse()).append("\n");
        }
        return sb.toString();
    }
    
    public String ejecutarViaje(){
        StringBuilder sb = new StringBuilder("Iniciando Viaje");
        for(SeleccionFutbol integrante : integrantes){
            sb.append(integrante.viajar()).append("\n");
        }
        return sb.toString();
    }
    
    public String ejecutarTrabajoPolimorfico(){
        StringBuilder sb = new StringBuilder("Iniciando jornada");
        for(SeleccionFutbol integrante : integrantes){
            sb.append(integrante.trabajar()).append("\n");
        }
        return sb.toString();
    }
}
