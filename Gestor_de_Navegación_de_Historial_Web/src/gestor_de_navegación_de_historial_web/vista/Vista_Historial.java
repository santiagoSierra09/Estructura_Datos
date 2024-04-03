package gestor_de_navegación_de_historial_web.vista;

import gestor_de_navegación_de_historial_web.modelo.Historial_Navegacion;
import gestor_de_navegación_de_historial_web.modelo.Pagina_Web;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
  David santiago Sierra Benavides
  Estrctura De Datos 
  03/04/2024
 */
public class Vista_Historial extends JFrame {

  private JTextField urlField;
  private JButton visitarButton;
  private JButton retrocederButton;
  private JButton avanzarButton;
  private JTextArea pageDisplay;
  private Historial_Navegacion historial;

  public Vista_Historial(Historial_Navegacion historial) {
    this.historial = historial;
    this.inicializarComponentes();
    this.configurarComponentes();
    this.pack();
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    Pagina_Web initialPage = new Pagina_Web("https://www.google.com", "Google");
    this.historial.visitarPagina(initialPage);
    this.actualizarVista();
  }

  private void inicializarComponentes() {

    this.urlField = new JTextField();
    this.visitarButton = new JButton("Visitar Página");
    this.retrocederButton = new JButton("Retroceder");
    this.avanzarButton = new JButton("Avanzar");
    this.pageDisplay = new JTextArea();
    this.pageDisplay.setEditable(false);
  }

  private void configurarComponentes() {

    this.setLayout(new BorderLayout());
    this.add(new JScrollPane(this.pageDisplay), BorderLayout.CENTER);
    JPanel panelInput = new JPanel();
    panelInput.add(this.urlField);
    panelInput.add(this.visitarButton);
    this.add(panelInput, BorderLayout.NORTH);
    JPanel panelButtons = new JPanel();
    panelButtons.add(this.retrocederButton);
    panelButtons.add(this.avanzarButton);
    this.add(panelButtons, BorderLayout.SOUTH);

    this.visitarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String url = urlField.getText();
        Pagina_Web nuevaPagina = new Pagina_Web(url, " " + url);
        historial.visitarPagina(nuevaPagina);
        actualizarVista();
      }
    });
    this.retrocederButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        historial.retroceder();
        actualizarVista();
      }
    });
    this.avanzarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        historial.avanzar();
        actualizarVista();
      }
    });

    this.retrocederButton.setEnabled(false);
    this.avanzarButton.setEnabled(false);
  }

  private void actualizarVista() {

    Pagina_Web paginaActual = this.historial.getPaginaActual();
    this.urlField.setText(paginaActual.getUrl());
    this.pageDisplay.setText(paginaActual.getTitle());

    this.retrocederButton.setEnabled(!this.historial.getPaginaVistasRecientes().isEmpty());
    this.avanzarButton.setEnabled(!this.historial.getPaginaVistasAnteriores().isEmpty());
  }
}
