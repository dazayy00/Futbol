/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Entrenador extends SeleccionFutbol{
    private String idFederacion;

    public Entrenador(String idFederacion, int id, String nombre, String Apellidos, int Edad) {
        super(id, nombre, Apellidos, Edad);
        this.idFederacion = idFederacion;
    }

    public String getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(String idFederacion) {
        this.idFederacion = idFederacion;
    }
    
    public void dirigirPartido(){
        System.out.println(nombre + " Esta dirigiendo el partido");
    }
    
    public void dirigirEntrenamiento(){
        System.out.println(nombre + " Esta dirigiendo el entrenamiento");
    }
}
