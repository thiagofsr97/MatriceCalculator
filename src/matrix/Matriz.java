package matrix;

/**
 *
 * @author Thiago Filipe Soares da Rocha
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Matriz{

  public  int[][] matrixA;
  public  int[][] matrixB;
  public  int[][] matrixResult;
  List<Thread> threads;
 
  public Matriz(int Am, int An, int Bm, int Bn){
    matrixA = new int [Am][An];
    matrixB = new int [Bm][Bn];
    matrixResult = new int[Am][Bn];    
    Random rand = new Random();
      for (int[] matrixA1 : matrixA) {
          Arrays.fill(matrixA1, rand.nextInt(50));
      }
      for(int[] matrixB1:matrixB){
          Arrays.fill(matrixB1,rand.nextInt(20));
      }
  
  }

  public void doMathSequential(){
      System.out.println("Calculando sequencialmente...");
    if(matrixA[0].length!=matrixB.length){
      System.out.println("O número de colunas da matrix A deve ser igual ao número de linhas da Matrix B");
    }else{
        for (int i = 0; i < matrixA.length; i++) { // aRow
            for (int j = 0; j < matrixB[0].length; j++) { // bColumn
               for (int k = 0; k < matrixA[0].length; k++) { // aColumn
                   matrixResult[i][j] += matrixA[i][k] * matrixB[k][j];                  
               }
           }
       }
    }
  }

  public void PrintResult(){
    try{
        int rows = matrixResult.length;
        int columns = matrixResult[0].length;
        String str = "|\t";

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                str += matrixResult[i][j] + "\t";
            }

            System.out.println(str + "|");
            str = "|\t";
        }

    }catch(Exception e){
        System.out.println("Matrix is empty!!");
    }
}
  
  public void doMathThreads(){
      System.out.println("Calculando concorrentemente...");
      threads = new ArrayList<>(matrixA.length);
      if(matrixA[0].length!=matrixB.length){
      System.out.println("O número de colunas da matrix A deve ser igual ao número de linhas da Matrix B");
    }
      else{
      ExecutorService executor = Executors.newFixedThreadPool(4);
      for(int i = 0;i<matrixA.length;i++){
          executor.execute(new MultiplyThread(this,i));          
      }
      executor.shutdown();
      while (!executor.isTerminated()) {
      }
        System.out.println("Finished all threads");
      
    }
  }
  
  
}
