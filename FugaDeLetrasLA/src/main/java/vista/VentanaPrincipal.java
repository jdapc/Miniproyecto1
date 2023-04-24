/*Integrantes: Orlando Alexis Rengifo Mejia (2223878)
               Johan David Pitto Calambás (1932739)
*/


package vista;

import modelo.Jugador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public final class VentanaPrincipal extends JFrame {
    
    private JLabel jlMensaje;
    private JLabel jlMensajeB;
    private JPanel jpContenido;
    private JLabel jlNombre;
    private JTextField txtNombre;
    private JButton btnIngresar; 
    private JButton btnInstrucciones;
    
    public VentanaPrincipal(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        //Configuración de la ventana
        setTitle("Fuga de letras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(519,530);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
        setLayout(null);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        
        //Configuración del Encabezado
         
        jpContenido = new JPanel();
        
        jlMensaje = new JLabel("Una vocal se ha fugado de la palabra,",SwingConstants.CENTER);
        jlMensajeB = new JLabel("¿nos ayudas a encontrarla?",SwingConstants.CENTER);
        jlNombre = new JLabel("Ingresa tu nombre",SwingConstants.CENTER );
        
        
        
        
        jpContenido.setSize(519,500);        
        jpContenido.setBounds(0,110, 519, 500);
        jpContenido.setLayout(null);
        
       
        add(jpContenido);
        
        jlMensaje.setBounds(0,20, 519,60);
        jlMensaje.setForeground(Color.RED);
        jlMensaje.setFont(new Font("arial", Font.BOLD, 20));
        
        jlMensajeB.setBounds(0,42, 519,60);
        jlMensajeB.setForeground(Color.RED);
        jlMensajeB.setFont(new Font("arial", Font.BOLD, 20)); 
        
        
        jlNombre.setBounds(0,130, 519,35);
        jlNombre.setForeground(Color.RED);
        jlNombre.setFont(new Font("arial", Font.BOLD, 20)); 
                
        btnIngresar = new JButton("Jugar");
        btnIngresar.setBounds(180,250, 150,35);
        btnInstrucciones = new JButton("Instrucciones");
        btnInstrucciones.setBounds(180, 300, 150, 35);
        
        jpContenido.add(jlMensajeB);
        jpContenido.add(jlMensaje);
        jpContenido.add(jlNombre);
        jpContenido.add(btnIngresar);
        jpContenido.add(btnInstrucciones);
                
        txtNombre = new JTextField("");
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setForeground(Color.GRAY);
        txtNombre.setFont(new Font("arial", Font.BOLD, 20)); 
        
        jpContenido.add(txtNombre);
        
        txtNombre.setBounds(50,190,410, 40);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnIngresar.addActionListener(manejadorEventos);
        btnInstrucciones.addActionListener(manejadorEventos);
        txtNombre.addKeyListener(manejadorEventos);
        
        txtNombre.requestFocusInWindow();
        
        Image miIcono = miPantalla.getImage("src/imagenes/icono.png");
	setIconImage(miIcono);
               
    }
    
    private void iniciarJuego(){
        String nombre =txtNombre.getText();
        if(!nombre.trim().isEmpty() || nombre.trim().length() > 0){
            Jugador jugador = new Jugador(nombre);        
            dispose(); 
            VentanaJuego ventanaJuego = new VentanaJuego(jugador);              
        } else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese su nombre", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocusInWindow();
        }
    }
    private void mostrarInstrucciones(){
        JOptionPane.showMessageDialog(null, "El juego consiste en rellenar la vocal indicada en la palabra que se muestre en pantalla");  
    }
    
    class ManejadorDeEventos implements ActionListener, KeyListener{
        
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnIngresar){                
                iniciarJuego();
            } else if (evento.getSource() == btnInstrucciones) {
                mostrarInstrucciones();
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
           /* System.out.println("Se liberó la tecla " + e.getKeyChar() +
                    " Con codigo " + e.getKeyCode());*/
            if(e.getKeyCode() == e.VK_ENTER){
                btnIngresar.doClick();
            }
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            /*System.out.println("Se presionó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
            
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            /*System.out.println("Se digitó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
            
            
        }
        
    }
    
}