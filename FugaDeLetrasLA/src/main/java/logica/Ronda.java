/*Integrantes: Orlando Alexis Rengifo Mejia (2223878)
               Johan David Pitto Calambás (1932739)
*/



package logica;

public class Ronda {
    private static int totalRondas;
    private int intentosRonda;
    private int numeroRonda;
    
    public Ronda(){
        ++totalRondas;
        setNumeroRonda(totalRondas);
        intentosRonda = 0;
    }
    
    public int getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public int getIntentosRonda() {
        return intentosRonda;
    }

    public void setIntentosRonda(int intentosRonda) {
        this.intentosRonda = intentosRonda;
    }
    
    
}
