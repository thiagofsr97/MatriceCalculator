/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;



/**
 *
 * @author Thiago Filipe Soares da Rocha
 */
public class Main {   
     
    public static void main(String[] args) {
        
        /* Creating matrices and populating randomly*/
        
        Matriz matrice = new Matriz(1000,1000,1000,1000);
        
       /*Calculating sequentially*/
       
        long startTime = System.currentTimeMillis();
        matrice.doMathSequential();       
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        double totalTimeSeq = (totalTime/1000.0);
        System.out.println("Tempo necessário para calcular sequencialmente: " + totalTimeSeq + " segundos.");
        
        /*Calculating with Threads*/
        startTime = System.currentTimeMillis();
        matrice.doMathThreads();       
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        double totalTimeCon = (totalTime/1000.0);
        System.out.println("Tempo necessário para calcular concorrentemente: " + totalTimeCon + " segundos.");
        
        /*Printing matrice to console*/
        
        matrice.PrintResult();
        
        
         
        //matrice.PrintResult();
        System.out.println("Code by Thiago Filipe Soares da Rocha");
        
    }
    
}
