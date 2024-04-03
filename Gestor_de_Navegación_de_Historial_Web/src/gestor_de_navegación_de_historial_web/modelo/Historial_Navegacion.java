package gestor_de_navegación_de_historial_web.modelo;

import java.util.Stack;

/*
  David santiago Sierra Benavides
  Estrctura De Datos 
  03/04/2024
 */
public class Historial_Navegacion {

  private Stack<Pagina_Web> paginaVistasRecientes;
  private Stack<Pagina_Web> paginaVistasAnteriores;
  private Pagina_Web paginaActual;

  public Historial_Navegacion() {
    this.paginaVistasRecientes = new Stack<>();
    this.paginaVistasAnteriores = new Stack<>();
    this.paginaActual = null;
  }

  public void visitarPagina(Pagina_Web pagina) {
    this.paginaVistasRecientes.push(pagina);
    this.paginaVistasAnteriores.clear();
    this.paginaActual = pagina;
  }

  public void retroceder() {
    if (!this.paginaVistasRecientes.isEmpty())
    {
      this.paginaVistasAnteriores.push(this.paginaActual);
      this.paginaActual = this.paginaVistasRecientes.pop();
    }
  }

  public Stack<Pagina_Web> getPaginaVistasRecientes() {
    return paginaVistasRecientes;
  }

  public void setPaginaVistasRecientes(Stack<Pagina_Web> paginaVistasRecientes) {
    this.paginaVistasRecientes = paginaVistasRecientes;
  }

  public Stack<Pagina_Web> getPaginaVistasAnteriores() {
    return paginaVistasAnteriores;
  }

  public void setPaginaVistasAnteriores(Stack<Pagina_Web> paginaVistasAnteriores) {
    this.paginaVistasAnteriores = paginaVistasAnteriores;
  }

  public Pagina_Web getPaginaActual() {
    return paginaActual;
  }

  public void setPaginaActual(Pagina_Web paginaActual) {
    this.paginaActual = paginaActual;
  }

  public void avanzar() {

    if (!this.paginaVistasAnteriores.isEmpty())
    {
      this.paginaVistasRecientes.push(this.paginaActual);
      this.paginaActual = this.paginaVistasAnteriores.pop();
    }
  }

}
