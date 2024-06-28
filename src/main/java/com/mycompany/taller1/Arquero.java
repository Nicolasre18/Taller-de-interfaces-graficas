package com.mycompany.taller1;

class Arquero extends Jugador {
    private int totalAtajadas;
    
    public Arquero(String nombre, int numero, int partidosJugados, int totalAtajadas) {
        //llamamos al constructor de la clase Jugador
        super(nombre, numero, partidosJugados);
        this.totalAtajadas = totalAtajadas;
    }

    //Getter y Setter especificos de la clase arquero 
    public int getTotalAtajadas() {
        return totalAtajadas;
    }
    
    public void setTotalAtajadas(int totalAtajadas) {
        this.totalAtajadas = totalAtajadas;
    }
    
    //Heredamos y sobrescribimos el metodo calcularCalificacion
    @Override
    public double calcularCalificacion() {
        return (double) totalAtajadas / partidosJugados * 100;
    }

    
    //Heredamos y sobrescribimos el metodo getPosicion
    @Override
    public String getPosicion() {
        return "Arquero";
    }
}