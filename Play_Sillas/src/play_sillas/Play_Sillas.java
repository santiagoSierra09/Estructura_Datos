package play_sillas;

import java.util.Scanner;

/*
  David santiago Sierra Benavides
  Estrctura De Datos 
  20/03/2024
 */
public class Play_Sillas {

  public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese la cantidad de jugadores: ");
    int numJugadores = scanner.nextInt();
    Lista_Circular game = new Lista_Circular(numJugadores);
    game.playGame();
  }

}
