/*Integrantes: Orlando Alexis Rengifo Mejia (2223878)
               Johan David Pitto Calambás (1932739)
*/


package logica;

import modelo.Jugador;

public class Juego {
    private Jugador jugador;
    private Ronda mejorRonda;
    private Ronda ronda;
    
    public Juego(Jugador jugador){
        this.jugador = jugador;              
    }
    
    public void iniciarRonda(){
        ronda = new Ronda();
        if (ronda.getNumeroRonda() == 1){
            mejorRonda = ronda;
        }
    }
    
    
    public String getJugador(){
        return jugador.getNombre();
    }
    
    public int getNumeroRonda(){
        return ronda.getNumeroRonda();
    }
     
     public int getIntentosRonda(){
        return ronda.getIntentosRonda();
    }
        
     public Ronda getMejorRonda(){
         return mejorRonda;
     }
     
     public void compararRondas(){
         if(ronda.getIntentosRonda() < mejorRonda.getIntentosRonda()){
             mejorRonda = ronda;
         }
     }
}