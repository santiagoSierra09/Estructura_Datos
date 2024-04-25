package ejercicio_colas;

import java.util.Scanner;

/*
  David santiago Sierra Benavides
  Estrctura De Datos 
  25/04/2024
 */
public class Ejercicio_Colas {

  public static void main(String[] args) {

    Servicio_al_Cliente sistema = new Servicio_al_Cliente();

    while (true)
    {
      System.out.println("\nSeleccione una opcion:");
      System.out.println("1. Agregar un nuevo cliente a la cola.");
      System.out.println("2. Atender al siguiente cliente en la cola.");
      System.out.println("3. Salir.");

      Scanner scanner = new Scanner(System.in);
      int opcion = scanner.nextInt();

      switch (opcion)
      {
        case 1:
          sistema.agregarCliente();
          break;
        case 2:
          sistema.atenderCliente();
          break;
        case 3:
          System.out.println("Vemos :)");
          scanner.close();
          return;
        default:
          System.out.println("Opcion invalida. Intente nuevamente.");
      }
    }
  }
}
