/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial3;

import java.util.Stack;

/**
 *
 * @author Personal
 */
public class parcial3 {
    
    
    /**
     * @param args the command line arguments
     */

    
    public void mostrarMatriz(int[][]matriz){
        String cadena="";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cadena=cadena+matriz[i][j]+"  ";
            }
            cadena=cadena+"\n";
        }
        System.out.println(cadena);
    }
    
    public void llenarMatriz(int[][]matriz){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j]=0;
            }
        }
        matriz[0][1]=1;
        matriz[0][4]=1;
        matriz[1][0]=1;
        matriz[1][7]=1;
        matriz[2][3]=1;
        matriz[2][7]=1;
        matriz[2][9]=1;
        matriz[3][2]=1;
        matriz[3][7]=1;
        matriz[4][0]=1;
        matriz[4][5]=1;
        matriz[5][4]=1;
        matriz[6][7]=1;
        matriz[7][1]=1;
        matriz[7][2]=1;
        matriz[7][3]=1;
        matriz[7][6]=1;
        matriz[7][9]=1;
        matriz[8][9]=1;       
        matriz[9][2]=1;
        matriz[9][7]=1;
        matriz[9][8]=1;
    }
    
    public void llenarEstaciones(int[]estaciones){
        estaciones[0]=0;
        estaciones[1]=300;
        estaciones[2]=150;
        estaciones[3]=200;
        estaciones[4]=100;
        estaciones[5]=200;
        estaciones[6]=100;
        estaciones[7]=50;
        estaciones[8]=50;
        estaciones[9]=500;
    }
    
    public String recorridoCamion(int[][]matriz,int valorInicialX, int[]necesidadEstaciones){
        String Salida="Desde 0";
        int a;
        int posicion=0;
        int necesidadmayor=0;
        int material=valorInicialX;
        Stack<Integer> stac=new Stack();
        stac.add(0);  
        boolean[] seRecorrio=new boolean[necesidadEstaciones.length];
        seRecorrio[0]=true;
        for (int i = 1; i <necesidadEstaciones.length; i++) {
            seRecorrio[i]=false;
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j]==1) {
                    if (seRecorrio[j] != true) {
                        if (necesidadEstaciones[j] <= material) {
                            if (necesidadEstaciones[j] > necesidadmayor) {
                                if (necesidadmayor!=0) {
                                    stac.pop();
                                    seRecorrio[posicion]=false;
                                }
                                necesidadmayor = necesidadEstaciones[j];
                                if (seRecorrio[j] == false) {
                                    stac.add(j);          
                                    seRecorrio[j] = true;
                                    posicion = j;
                                }
                            }
                        }
                    }
                }
            }
            if(necesidadmayor!=0){
                Salida=Salida+", luego "+posicion;
                material=material-necesidadmayor;
                necesidadmayor=0;
                if (material==0) {
                    i=matriz.length;
                }else{
                    i=posicion-1;
                }
            }else{
                if (!stac.empty()) {
                    a=stac.pop();
                    i=a-1;
                }else{
                    i=matriz.length;
                }
            } 
        }
 
        System.out.println(Salida);
        return Salida;
    }
    
    public static void main(String[] args) {
        int [][]MatrizAdy=new int[10][10];
        int []necesidadEstaciones=new int[10];
        parcial3 obj=new parcial3();
        obj.llenarMatriz(MatrizAdy);
        obj.llenarEstaciones(necesidadEstaciones);
        obj.recorridoCamion(MatrizAdy, 1650, necesidadEstaciones);
    }
    
}
