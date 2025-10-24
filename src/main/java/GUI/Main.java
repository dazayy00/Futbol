/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GUI;

import Model.Entrenador;
import Model.Futbolista;
import Model.Masagista;
import Model.SeleccionFutbol;
import java.util.ArrayList;

/**
 *
 * @author johan
 */
public class Main {

    public static ArrayList<SeleccionFutbol> integrantes = new ArrayList<SeleccionFutbol>();
    
    public static void main(String[] args) {
        Entrenador pep = new Entrenador("53", 60, "Pep ", " guardiola", 60);
        Futbolista xavi = new Futbolista(12, 23, "Delantero", "Xavio", "Mesinaldo", 23);
        Masagista raul = new Masagista(12, "Huesero", 12, "Raul ", "Gutierrez", 23);
        
        integrantes.add(pep);
        integrantes.add(xavi);
        integrantes.add(raul);
        
        System.out.println();
    }
    
}
