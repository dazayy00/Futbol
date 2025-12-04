/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Masajista extends SeleccionFutbol{
    private String titulacion;
    private int exp;

    public Masajista(int id, String titulacion, int exp,  String nombre, String apellidos, int edad) {
        super(id, nombre, apellidos, edad);
        this.titulacion = titulacion;
        this.exp = exp;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    
    //polimorfismo
    @Override
    public String trabajar(){
        return getNombreCompleto() + " Esta dando un masaje";
    }
    
    @Override
    public String getDetallesEspecificos(){
        return "{Masagista} Titulacion "+ titulacion+ " Años exp "+ exp;
    }
}
