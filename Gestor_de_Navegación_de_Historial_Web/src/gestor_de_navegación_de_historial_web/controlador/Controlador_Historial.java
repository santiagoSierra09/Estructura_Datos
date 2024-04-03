package gestor_de_navegación_de_historial_web.controlador;

import gestor_de_navegación_de_historial_web.modelo.Historial_Navegacion;
import gestor_de_navegación_de_historial_web.vista.Vista_Historial;

/*
  David santiago Sierra Benavides
  Estrctura De Datos 
  03/04/2024
*/
public class Controlador_Historial {

  public void Controlador_Historial() {
     Historial_Navegacion historial = new Historial_Navegacion();
    Vista_Historial vista = new Vista_Historial(historial);
    vista.setVisible(true);
  }
  
  

}
