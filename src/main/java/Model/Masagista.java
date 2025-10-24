/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Masagista extends SeleccionFutbol{
    private String titulacion;
    private int exp;

    public Masagista(int id, String titulacion, int exp,  String nombre, String Apellidos, int Edad) {
        super(id, nombre, Apellidos, Edad);
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
    
    public void darMasaje(){
        System.out.println(nombre + " Esta dando un masaje");
    }
}
