package com.mycompany.taller1;

class Defensa extends Jugador {
    private int totalDespejes;

    public Defensa(String nombre, int numero, int partidosJugados, int totalDespejes) {
        //llamamos al constructor de la clase Jugador
        super(nombre, numero, partidosJugados);
        this.totalDespejes = totalDespejes;
    }
    
    //Getter y Setter especificos de la clase defensa
    public int getTotalDespejes() {
        return totalDespejes;
    }
    
    public void setTotalDespejes(int totalDespejes) {
        this.totalDespejes = totalDespejes;
    }
    
    //Heredamos y sobrescribimos el metodo calcularCalificacion
    @Override
    public double calcularCalificacion() {
        return (double) totalDespejes / partidosJugados * 100;
    }
    
    //Heredamos y sobrescribimos el metodo getPosicion
    @Override
    public String getPosicion() {
        return "Defensa";
    }

}