
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logica.Juego;
import modelo.Jugador;

public class VentanaJuego extends JFrame{
    
    private JLabel jlJugador;
    private JLabel jlNombreJugador;
    private JLabel jlNumeroRonda;
    private JLabel jlRonda;
    private JLabel jlIntento;
    private JLabel jlNumero;
    private JLabel jlNumeroIntento;
    private JPanel jpContenido;
    private JTextField txtNumero;
    
    
    private Juego juego;
    
    public VentanaJuego(Jugador jugador){
        juego = new Juego(jugador);
        juego.iniciarRonda();
        iniciarComponentes();
        setSize(519,530);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Jugando a Adivinar");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    private void iniciarComponentes(){
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        //Configuración del Encabezado
      
        jpContenido = new JPanel();
        
        jlJugador = new JLabel("Jugador : ");
        jlJugador.setBounds(5,110, 519,35);
        jlJugador.setForeground(new Color(0,87,193));
        jlJugador.setFont(new Font("arial", Font.BOLD, 20));
               
        String nombre = juego.getJugador();
        nombre =    nombre.substring(0,1).toUpperCase() + 
                    nombre.substring(1).toLowerCase();
        jlNombreJugador = new JLabel(nombre);
        jlNombreJugador.setBounds(100,110, 519,35);
        jlNombreJugador.setForeground(Color.GRAY);
        jlNombreJugador.setFont(new Font("arial", Font.BOLD, 20));
        
        jlRonda = new JLabel("Ronda # : ");
        jlRonda.setBounds(230,110, 519,35);
        jlRonda.setForeground(new Color(0,87,193));
        jlRonda.setFont(new Font("arial", Font.BOLD, 20));
                
        jlNumeroRonda = new JLabel(
                String.valueOf(juego.getNumeroRonda()));
        jlNumeroRonda.setBounds(330,110, 519,35);
        jlNumeroRonda.setForeground(Color.GRAY);
        jlNumeroRonda.setFont(new Font("arial", Font.BOLD, 20));
        
        jlIntento = new JLabel("Intento # : ");
        jlIntento.setBounds(375,110, 519,35);
        jlIntento.setForeground(new Color(0,87,193));
        jlIntento.setFont(new Font("arial", Font.BOLD, 20));
        
        jlNumeroIntento = new JLabel(
                String.valueOf(juego.getIntentosRonda()));
        jlNumeroIntento.setBounds(475,110, 519,35);
        jlNumeroIntento.setForeground(Color.GRAY);
        jlNumeroIntento.setFont(new Font("arial", Font.BOLD, 20));
        
        jlNumero = new JLabel("¿Cuál es la vocal?",SwingConstants.CENTER );
        jlNumero.setBounds(0,180, 519,35);
        jlNumero.setForeground(new Color(0,87,193));
        jlNumero.setFont(new Font("arial", Font.BOLD, 20));
        
        jpContenido.add(jlJugador);
        jpContenido.add(jlNombreJugador);
        jpContenido.add(jlRonda);
        jpContenido.add(jlNumeroRonda);
        jpContenido.add(jlIntento);
        jpContenido.add(jlNumeroIntento);
        jpContenido.add(jlNumero);
        
       
     
        
        
        jpContenido.setSize(519,500);        
        jpContenido.setBounds(0,110, 519, 500);
        jpContenido.setLayout(null);
        

        add(jpContenido);
        
        txtNumero = new JTextField("");
        txtNumero.setHorizontalAlignment(JTextField.CENTER);
        txtNumero.setForeground(Color.GRAY);
        txtNumero.setFont(new Font("arial", Font.BOLD, 20)); 
       
        jpContenido.add(txtNumero);

        
        txtNumero.setBounds(50,230,410, 40);    
        
 
                        
   
        txtNumero.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
               
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        addWindowListener(new WindowAdapter() {
             @Override
            public void windowClosing(WindowEvent evt) {
                cerrarVentana();
            }
        });
               
    }
    
    private void cerrarVentana(){
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(
                    null,"¿Realmente dese abandonar el juego?", "Advertencia",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    public void jugarOtraVez(){
        int respuesta;
        
        respuesta = JOptionPane.showConfirmDialog(
                null,"¿Desea jugar otra vez?", "Información",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(respuesta == JOptionPane.YES_OPTION){
            juego.iniciarRonda();
            jlNumeroRonda.setText(
                    String.valueOf(juego.getNumeroRonda()));
            
            jlNumeroIntento.setText(
                        String.valueOf(juego.getIntentosRonda()));
            txtNumero.setText("");
        } else {
            dispose();
            JOptionPane.showMessageDialog(null,
            "ESTADÍSTICAS DEL JUEGO\n\n" + 
            "Total Rondas : " + juego.getNumeroRonda() +
            "\nLa mejor Ronda fue la # " + 
            juego.getMejorRonda().getNumeroRonda() + " con " +
                    juego.getMejorRonda().getIntentosRonda() +
                    " Intentos", 
            "Hasta la vista Baby!!!",
            JOptionPane.INFORMATION_MESSAGE);            
        }
    }
}

