/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Model.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
public class SeleccionLogica {
    
    private List<SeleccionFutbol> integrantes;
    
    public SeleccionLogica(){
        integrantes = new ArrayList<>();
    }
    
    public void agregarIntegrante(SeleccionFutbol integrante){
        integrantes.add(integrante);
    }
    
    public void mostrarIntegrantes(){
        System.out.println("===Integrantes de la seleccion===");
        for(SeleccionFutbol integrante : integrantes){
            System.out.println(integrante.getId()+" "+integrante.getNombre()+" "+integrante.getApellidos()
            +"("+integrante.getClass().getSimpleName()+")");
        }
        System.out.println("================================");
    }
    
    public void concentrarEquipo(){
        System.out.println(">>>>>>El equipo se concentra: ");
        for(SeleccionFutbol integrante : integrantes){
            integrante.concentrarse();
        }
        System.out.println();
    }
    
    public void viajarEquipo(){
        System.out.println(">>>>>>>>>>>El equipo viaja");
        for(SeleccionFutbol integrante : integrantes){
            integrante.viajar();
        }
        System.out.println();
    }
    
    public void entrenarEquipo(){
        System.out.println(">>>>>>>>>>>>Entrenamiento de equipo");
        for(SeleccionFutbol integrante : integrantes){
            integrante.entrenar();
        }
        System.out.println();
    }
    
    public void jugarPartido(){
        System.out.println(">>>>>>>>>>Partido de futbol");
        for(SeleccionFutbol integrante : integrantes){
            integrante.jugarPartido();
        }
        System.out.println();
    }
    /*
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
            sb.append(integrante.Concentrarse()).append("\n");
        }
        return sb.toString();
    }
    
    public String ejecutarViaje(){
        StringBuilder sb = new StringBuilder("Iniciando Viaje");
        for(SeleccionFutbol integrante : integrantes){
            sb.append(integrante.Viajar()).append("\n");
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
*/
}
