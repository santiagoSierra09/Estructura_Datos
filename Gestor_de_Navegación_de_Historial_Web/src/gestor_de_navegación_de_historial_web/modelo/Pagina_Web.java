package gestor_de_navegación_de_historial_web.modelo;

/*
  David santiago Sierra Benavides
  Estrctura De Datos 
  03/04/2024
 */
public class Pagina_Web {

  private String url;
  private String title;

  public Pagina_Web(String url, String title) {
    this.url = url;
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return title;
  }
}
