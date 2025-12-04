/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Model.Futbolista;

/**
 *
 * @author johan
 */
public class FutbolistaService {
    public Futbolista registrarFutbolista(int id, int dorsal, String demarcacion, String nombre, String apellidos, int edad){
        return new Futbolista(id, dorsal, demarcacion, nombre, apellidos, edad);
    }
    
    public String obtenerFichaTecnica(Futbolista futbolista){
        return "JUGADOR: " + futbolista.getNombreCompleto() + 
               "\n  - Posición: " + futbolista.getDemarcacion() +
               "\n  - Dorsal: " + futbolista.getDorsal();
    }
}
