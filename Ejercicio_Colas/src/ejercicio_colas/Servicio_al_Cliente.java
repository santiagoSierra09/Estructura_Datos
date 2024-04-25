package ejercicio_colas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
  David santiago Sierra Benavides
  Estrctura De Datos 
  25/04/2024
 */
public class Servicio_al_Cliente {

  private Queue<Cliente> coladecliente;
  private int siguienteNúmeroDeBoleto;
  private Scanner scanner;

  public Servicio_al_Cliente() {
    coladecliente = new LinkedList<>();
    siguienteNúmeroDeBoleto = 1;
    scanner = new Scanner(System.in);
  }

  public void atenderCliente() {
    if (coladecliente.isEmpty())
    {
      System.out.println("No hay clientes en espera.");
    } else
    {
      Cliente cliente = coladecliente.poll();
      System.out.println("Atendiendo al cliente " + cliente.nombre + " con ticket numero " + cliente.NumeroTicket);
    }
  }

  public void agregarCliente() {
    System.out.print("Ingrese el nombre del cliente: ");
    String nombre = scanner.nextLine();

    Cliente cliente = new Cliente(nombre, siguienteNúmeroDeBoleto);
    coladecliente.add(cliente);

    System.out.println("Se ha agregado al cliente " + nombre + " con ticket numero " + cliente.NumeroTicket);
    siguienteNúmeroDeBoleto++;
  }

}
