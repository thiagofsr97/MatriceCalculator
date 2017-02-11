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
public class MultiplyThread implements Runnable {
    
    private final int currentRow;
    private final Matriz matriz;
    
    public MultiplyThread(Matriz matriz,int currentRow){
        
        this.currentRow = currentRow;
        this.matriz = matriz;
        
    }
    private void Calculate(){  
        for (int j = 0; j < matriz.matrixB[0].length; j++) { // bColumn
               for (int k = 0; k < matriz.matrixA[0].length; k++) { // aColumn
                   matriz.matrixResult[currentRow][j] += matriz.matrixA[currentRow][k] * matriz.matrixB[k][j];                   
               }
        }
    }
    
    @Override
    public void run(){
        Calculate();
    }
}
