/*Integrantes: Orlando Alexis Rengifo Mejia (2223878)
               Johan David Pitto Calambás (1932739)
*/


package modelo;

public class Jugador {
    private String nombre;
    
    public Jugador(){
        nombre = "Jugador 1";
    }
    
    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
