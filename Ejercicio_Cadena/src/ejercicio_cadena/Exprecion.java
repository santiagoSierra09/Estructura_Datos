package ejercicio_cadena;

import java.util.Deque;
import java.util.LinkedList;

/*
  David santiago Sierra Benavides
  Estrctura De Datos 
  02/04/2024
 */
public class Exprecion {

  public static boolean estanParentesisBalanceados(String expresion) {
    // Crear una pila para mantener un seguimiento de los paréntesis de apertura
    Deque<Character> pila = new LinkedList<Character>();

    // Iterar sobre cada carácter en la expresión
    for (int i = 0; i < expresion.length(); i++)
    {
      char c = expresion.charAt(i);

      // Si el carácter es un paréntesis de apertura, empujarlo en la pila
      if (c == '(')
      {
        pila.push(c);
      } // Si el carácter es un paréntesis de cierre, verificar si la pila está vacía o si el elemento superior no es un paréntesis de apertura
      else if (c == ')')
      {
        if (pila.isEmpty() || pila.peek() != '(')
        {
          return false;
        }
        // Si la pila no está vacía y el elemento superior es un paréntesis de apertura, eliminarlo de la pila
        pila.pop();
      }
    }

    // Si la pila está vacía, los paréntesis están balanceados
    return pila.isEmpty();
  }

}
