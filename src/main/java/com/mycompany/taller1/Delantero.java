package com.mycompany.taller1;

class Delantero extends Jugador {
    private int totalGoles;
    private int totalAsistencias;

    public Delantero(String nombre, int numero, int partidosJugados, int totalGoles, int totalAsistencias) {
        //llamamos al constructor de la clase Jugador
        super(nombre, numero, partidosJugados);
        this.totalGoles = totalGoles;
        this.totalAsistencias = totalAsistencias;
    }
    
    //Getter y Setter especificos de la clase delantero
    public int getTotalGoles() {
        return totalGoles;
    }
    
    public void setTotalGoles(int totalGoles) {
        this.totalGoles = totalGoles;
    }

    public int getTotalAsistencias() {
        return totalAsistencias;
    }
    
    public void setTotalAsistencias(int totalAsistencias) {
        this.totalAsistencias = totalAsistencias;
    }
    
    //Heredamos y sobrescribimos el metodo calcularCalificacion
    @Override
    public double calcularCalificacion() {
        return (double) (totalGoles + totalAsistencias) / partidosJugados * 100;
    }
    
    //Heredamos y sobrescribimos el metodo getPosicion
    @Override
    public String getPosicion() {
        return "Delantero";
    }
}