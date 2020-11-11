/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesoro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Semipresencial 1º
 */
public class Tesoro {

    /**
     * @param args the command line arguments
     */
    
    static Random ran=new Random();
    static Scanner entrada=new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int contador=1;                         //variable que establece el número de intentos
        int i=-1;                                //i y j representan la elección del usuario, las coordenadas
        int j=-1;
        boolean estallido=false;                //si estallido se torna true, el usuario ha encontrado la mina y el juego termina
        boolean encontrado=false;               //si encontrado se torna true, el usuario ha hallado el tesoro y el juego termina
        String[][] tab=new String[5][4];        // este es el tablero
        
        System.out.println("Bienvenido a la búsqueda del tesoro. Escriba dos números,"
                           + " que serán las coordenadas para hallar el tesoro.");
        
        System.out.print("   0   1   2  3\n");              //impirmimos el tablero 
        System.out.print("  _ _ _ _ _ _ _ _ ");
            for(int f=0; f<tab.length; f++){
                System.out.println();
                
                 for(int c=0; c<tab[f].length; c++){
                     System.out.print(c==0? f+"|_ _": "|_ _");
                        tab[f][c]=null;                     //asignamos null a todas las casillas
                 
                 }
                 System.out.print("|");
            }
            System.out.println();
            System.out.println();                                       
            
        tab[ran.nextInt(4)][ran.nextInt(3)]="$";            //asignamos el símbolo del dolar a una casilla aleatoria. Representa tesoro
        tab[ran.nextInt(4)][ran.nextInt(3)]="*";            //asignamos el símbolo de asterisco a una casilla aleatoria. representa mina
        
        
        
        do{                                                 //. El primer Do persiste mientras el contador sea menor de 4(le damos 3 intentos) y 
          do{                                               //se incrementa con cada intento. El siguiente Do ejecuta cada intento.        
            do{                                             //El tercer y cuarto Do sirven para validar la entrada de las coordenadas
                System.out.println(" Intento "+contador+". Escriba el primer número, entre 0 y 4\n-->");
                try{
                i=entrada.nextInt();
                }catch(InputMismatchException e){ System.err.println("Debe ser un entero");
                entrada.nextLine();}
            } while((i<0)||(i>4));
        
            do{
                System.out.println("Escriba el segundo, entre 0 y 3");
                try{
                j=entrada.nextInt();
                }catch(InputMismatchException e){ System.err.println("Debe ser un entero");
                entrada.nextLine();}
            } while((j<0)||(j>3));
                if(tab[i][j]=="X")System.out.println("Ya eligió eso antes");{   //si el usuario repite una coordenada se le avisa de la 
                                                                                // y se imprime el tablero para que se fije en lo que ya ha elegido
                  System.out.print("   0   1   2  3\n");
                         System.out.print("  _ _ _ _ _ _ _ _ ");
                            for(int f=0; f<tab.length; f++){
                                System.out.println();
                
                                for(int c=0; c<tab[f].length; c++){
                                      if((tab[f][c]==tab[i][j])&&(tab[i][j]=="$"))
                                       System.out.print(c==0? f+"|_$_": "|_$_");
                                      else if(tab[f][c]=="X")
                                        System.out.print(c==0? f+"|_X_": "|_X_");
                                      else if((tab[f][c]==tab[i][j])&&(tab[i][j]=="*"))
                                           System.out.print(c==0? f+"|_*_": "|_*_");
                                      else    System.out.print(c==0? f+"|_ _": "|_ _");
                                      
                                }
                                System.out.print("|");
                            }
                                System.out.println();
                                System.out.println();
               }
                
           }while(tab[i][j]=="X");
              
               
        contador++;
       
              
        System.out.print("Coordenada "+ i +"\n"
                        +"Coordenada "+ j+ "\n"
                        + " y el resultado es....");
        
                
                        if(tab[i][j]=="$"){
                            System.out.println("tesoro encontrado!!!!!" );
                            encontrado=true;
                        }
                        else if(tab[i][j]=="*"){ 
                            System.out.println("La mina ha estallado!!!!");
                            estallido=true;
                        }
                        else {System.out.println("que ha fallado!!!!!" );
                        tab[i][j]="X";
                        }
                      
                         System.out.print("   0   1   2  3\n");
                         System.out.print("  _ _ _ _ _ _ _ _ ");
                            for(int f=0; f<tab.length; f++){
                                System.out.println();
                
                                for(int c=0; c<tab[f].length; c++){
                                      if((tab[f][c]==tab[i][j])&&(tab[i][j]=="$"))
                                       System.out.print(c==0? f+"|_$_": "|_$_");
                                      else if(tab[f][c]=="X")
                                        System.out.print(c==0? f+"|_X_": "|_X_");
                                      else if((tab[f][c]==tab[i][j])&&(tab[i][j]=="*"))
                                           System.out.print(c==0? f+"|_*_": "|_*_");
                                      else    System.out.print(c==0? f+"|_ _": "|_ _");
                                      
                 }
                 System.out.print("|");
            }
            System.out.println();
            System.out.println();
                 
        }while(contador<4&&!estallido&&!encontrado);
            
            
   
    }
}

        
