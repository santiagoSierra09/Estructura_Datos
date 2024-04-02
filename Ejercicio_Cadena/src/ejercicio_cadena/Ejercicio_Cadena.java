package ejercicio_cadena;

import static ejercicio_cadena.Exprecion.estanParentesisBalanceados;
import java.util.Scanner;


/*
  David santiago Sierra Benavides
  Estrctura De Datos 
  02/04/2024
 */
public class Ejercicio_Cadena {

  public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);
    String expresion1 = "((a+b)^c)";
    String expresion2 = "(a+b))";
System.out.println("ingrese la expresion:");
        String dato=leer.nextLine();
    System.out.println(estanParentesisBalanceados(dato)+dato); // Verdadero
    System.out.println(estanParentesisBalanceados(expresion2)+expresion2); // Falso
    
}
}

