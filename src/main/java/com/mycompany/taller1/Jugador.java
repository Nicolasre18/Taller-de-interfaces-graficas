package com.mycompany.taller1;

abstract class Jugador implements Calificable {
    //Atributos
    protected String nombre;
    protected int numero;
    protected int partidosJugados;
       
    //Getters y por si acaso los Setters 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }
    
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }
   
    
    //Constructor por parametros
    public Jugador(String nombre, int numero, int partidosJugados) {
        this.nombre = nombre;
        this.numero = numero;
        this.partidosJugados = partidosJugados;
    }

    //Implementamos el metodo de la interfaz Calificable
    @Override
    public abstract double calcularCalificacion();
    
    //Metodo para ver que posicion pertenecen 
    public abstract String getPosicion();
    
}
