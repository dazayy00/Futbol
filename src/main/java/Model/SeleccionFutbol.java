/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class SeleccionFutbol {
    protected int id;
    protected String nombre;
    protected String Apellidos;
    protected int Edad;

    public SeleccionFutbol(int id, String nombre, String Apellidos, int Edad) {
        this.id = id;
        this.nombre = nombre;
        this.Apellidos = Apellidos;
        this.Edad = Edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
    
    public void Concentrarse(){
        System.out.println(nombre + " Esta concentrandose");
    }
    
    public void Viajar(){
        System.out.println(nombre + " Esta Viajando");
    }
}
