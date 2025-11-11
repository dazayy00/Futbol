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

    public Entrenador(String idFederacion, int id, String nombre, String apellidos, int edad) {
        super(id, nombre, apellidos, edad);
        this.idFederacion = idFederacion;
    }

    public String getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(String idFederacion) {
        this.idFederacion = idFederacion;
    }
    
    @Override
    public void entrenar(){
        System.out.println("Dirigiendo entrenamiento...");
    }
    
    @Override
    public void jugarPartido(){
        System.out.println("Dirigiendo un partido...");
    }
    
    /*
    //polimorfismo
    @Override
    public String trabajar(){
        return getNombreCompleto() +" Esta dirigiendo el partido y el entrenamiento";
    }
    
    @Override
    public String getDetallesEspecificos(){
        return "{Entrenador } ID FEDERACION"+ idFederacion;
    }
    */
}
