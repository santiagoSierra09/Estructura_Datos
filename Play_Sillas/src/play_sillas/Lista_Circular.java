package play_sillas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
  David santiago Sierra Benavides
  Estrctura De Datos 
  20/03/2024
 */
public class Lista_Circular {
  
  private Node cabeza;
  private int numeroJugadores;
  private final ArrayList<Node> players;
  private final Random random;
  Scanner scanner = new Scanner(System.in);

  public Lista_Circular(int numeroJugadores) {
    this.numeroJugadores = numeroJugadores;
    this.random = new Random();
    this.players = new ArrayList<>();

    // Crear la lista circular de sillas y jugadores
    Node lastNode = null;
    for (int i = 0; i < numeroJugadores; i++)
    {
      Node newNode = new Node(false);
      if (i == 0)
      {
        cabeza = newNode;
      } else
      {
        lastNode.next = newNode;
      }
      lastNode = newNode;
      players.add(newNode);
    }
    cabeza.next = cabeza; // Cerrar la lista circular
  }
  
  public void playGame() throws InterruptedException {
    while (numeroJugadores > 1)
    {
      System.out.println("Numero de jugadores: " + numeroJugadores);
      visualizeGameState();

      // Simular la música
      int numSteps = random.nextInt(numeroJugadores) + 1;
      Thread.sleep(3000);
      Node currentPlayer = cabeza;
      
      for (int i = 0; i < numSteps; i++)
      {
        currentPlayer = currentPlayer.next;
      }

      // Ocupar silla
      currentPlayer.value = true;
      players.remove(currentPlayer);
      numeroJugadores--;

      // Eliminar el nodo de la lista circular
      currentPlayer.next = currentPlayer.next.next;
      cabeza = currentPlayer.next;
    }
    
    System.out.println("Ganador: " + (cabeza.value ? "ocupado" : "desocupado"));
    visualizeGameState();
  }
  
  private void visualizeGameState() {
    Node currentPlayer = cabeza;
    do
    {
      System.out.printf("Silla", currentPlayer.hashCode(), currentPlayer.value);
      currentPlayer = currentPlayer.next;
    } while (currentPlayer != cabeza);
    System.out.println("-------------");
  }
}
