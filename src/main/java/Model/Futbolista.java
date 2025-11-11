/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Futbolista extends SeleccionFutbol{
    private int dorsal;
    private String demarcacion;

    public Futbolista( int id, int dorsal, String demarcacion, String nombre, String apellidos, int edad) {
        super(id, nombre, apellidos, edad);
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getDemarcacion() {
        return demarcacion;
    }

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }
    
    @Override
    public void entrenar(){
        System.out.println("Realizando entrenamiento...");
    }
    
    @Override
    public void jugarPartido(){
        System.out.println("Jugando partido...");
    }

    /*
    //implementacion polimorfica
    @Override
    public String trabajar(){
        return getNombreCompleto()+ " Esta jugando el partido y entrenando";
    }
    
    @Override
    public String getDetallesEspecificos(){
        return "{Futbolista } Dorsal "+ dorsal+" Demarcacion "+ demarcacion;
    }
    */

}
