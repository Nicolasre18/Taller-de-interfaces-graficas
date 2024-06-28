//Aqui hicimos esta parte con ayuda de chatgpt porque tambien nos ayudo a hacer el bloque try-catch

package com.mycompany.taller1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;


public class GestionJugadores extends JFrame {

    private DefaultTableModel tableModel; // Modelo de la tabla
    private JTable table; // Tabla para mostrar los jugadores
    private ArrayList<Jugador> jugadores; // Lista de jugadores

    public GestionJugadores() {
        jugadores = new ArrayList<>();

        //Configuramos la tabla
        tableModel = new DefaultTableModel(new Object[]{"Nombre", "Número", "PJ", "Calificación", "Tipo"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        //Configuramos el panel de pestañas
        JTabbedPane tabbedPane = new JTabbedPane();

        //Hacemos las pestañas para cada tipo de jugador
        tabbedPane.add("Arquero", crearPanelArquero());
        tabbedPane.add("Defensa", crearPanelDefensa());
        tabbedPane.add("Delantero", crearPanelDelantero());

        //Configuramos el BorderLayout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER); // Tabla en el centro
        add(tabbedPane, BorderLayout.SOUTH); // Pestañas en el sur

        setTitle("Gestión de Jugadores");
        setSize(600, 400); //Para que se vea mas bonito como un rectangulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel crearPanelArquero() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField nombreField = new JTextField();
        JTextField numeroField = new JTextField();
        JTextField pjField = new JTextField();
        JTextField atajadasField = new JTextField();

        JButton addButton = new JButton("Agregar");

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Número:"));
        panel.add(numeroField);
        panel.add(new JLabel("PJ:"));
        panel.add(pjField);
        panel.add(new JLabel("Total Atajadas:"));
        panel.add(atajadasField);
        panel.add(addButton);

        //Acción del botón para agregar un nuevo arquero
        /* Usamos addActionListener, el cual es un método que asigna un listener(un objeto que está diseñado para 
        manejar eventos que ocurren en un programa) al botón addButton 
        el cual captura el evento cuando se hace clic en el botón.*/
        //Usamos el try catch para manejar las exepciones
        addButton.addActionListener(e -> {
            try {
                String nombre = nombreField.getText();
                if (!nombre.matches("[a-zA-Z\\s]+")) {
                    throw new IllegalArgumentException("El nombre solo debe contener letras y espacios.");
                }
                int numero = Integer.parseInt(numeroField.getText());
                int pj = Integer.parseInt(pjField.getText());
                int atajadas = Integer.parseInt(atajadasField.getText());

                if (pj <= 0) {
                    throw new IllegalArgumentException("Partidos Jugados debe ser mayor que 0");
                }

                jugadores.add(new Arquero(nombre, numero, pj, atajadas));
                actualizarTabla();
            } catch (NumberFormatException ex) {
                mostrarError("Por favor ingrese valores numéricos válidos.");
            } catch (IllegalArgumentException ex) {
                mostrarError(ex.getMessage());
            } 
        });

        return panel;
    }

    private JPanel crearPanelDefensa() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField nombreField = new JTextField();
        JTextField numeroField = new JTextField();
        JTextField pjField = new JTextField();
        JTextField despejesField = new JTextField();

        JButton addButton = new JButton("Agregar");

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Número:"));
        panel.add(numeroField);
        panel.add(new JLabel("PJ:"));
        panel.add(pjField);
        panel.add(new JLabel("Total Despejes:"));
        panel.add(despejesField);
        panel.add(addButton);

        // Acción del botón para agregar un nuevo defensa
        //Acción del botón para agregar un nuevo arquero
        /* Usamos addActionListener, el cual es un método que asigna un listener(un objeto que está diseñado para 
        manejar eventos que ocurren en un programa) al botón addButton 
        el cual captura el evento cuando se hace clic en el botón.*/
        //Usamos el try catch para manejar las exepciones
        addButton.addActionListener(e -> {
            try {
                String nombre = nombreField.getText();
                if (!nombre.matches("[a-zA-Z\\s]+")) {
                    throw new IllegalArgumentException("El nombre solo debe contener letras");
                }
                int numero = Integer.parseInt(numeroField.getText());
                int pj = Integer.parseInt(pjField.getText());
                int despejes = Integer.parseInt(despejesField.getText());

                if (pj <= 0) {
                    throw new IllegalArgumentException("Partidos Jugados debe ser mayor que 0");
                }

                jugadores.add(new Defensa(nombre, numero, pj, despejes));
                actualizarTabla();
            } catch (NumberFormatException ex) {
                mostrarError("Por favor ingrese valores numéricos válidos.");
            } catch (IllegalArgumentException ex) {
                mostrarError(ex.getMessage());
            } 
        });

        return panel;
    }

    private JPanel crearPanelDelantero() {
        JPanel panel = new JPanel(new GridLayout(6, 2));

        JTextField nombreField = new JTextField();
        JTextField numeroField = new JTextField();
        JTextField pjField = new JTextField();
        JTextField golesField = new JTextField();
        JTextField asistenciasField = new JTextField();

        JButton addButton = new JButton("Agregar");

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Número:"));
        panel.add(numeroField);
        panel.add(new JLabel("PJ:"));
        panel.add(pjField);
        panel.add(new JLabel("Total Goles:"));
        panel.add(golesField);
        panel.add(new JLabel("Total Asistencias:"));
        panel.add(asistenciasField);
        panel.add(addButton);

        // Acción del botón para agregar un nuevo delantero
        //Acción del botón para agregar un nuevo arquero
        /* Usamos addActionListener, el cual es un método que asigna un listener(un objeto que está diseñado para 
        manejar eventos que ocurren en un programa) al botón addButton 
        el cual captura el evento cuando se hace clic en el botón.*/
        //Usamos el try catch para manejar las exepciones
        addButton.addActionListener(e -> {
            try {
                String nombre = nombreField.getText();
                if (!nombre.matches("[a-zA-Z\\s]+")) {
                    throw new IllegalArgumentException("El nombre solo debe contener letras y espacios.");
                }
                int numero = Integer.parseInt(numeroField.getText());
                int pj = Integer.parseInt(pjField.getText());
                int goles = Integer.parseInt(golesField.getText());
                int asistencias = Integer.parseInt(asistenciasField.getText());

                if (pj <= 0) {
                    throw new IllegalArgumentException("Partidos Jugados debe ser mayor que 0");
                }

                jugadores.add(new Delantero(nombre, numero, pj, goles, asistencias));
                actualizarTabla();
            } catch (NumberFormatException ex) {
                mostrarError("Por favor ingrese valores numéricos válidos.");
            } catch (IllegalArgumentException ex) {
                mostrarError(ex.getMessage());
            } 
        });

        return panel;
    }

    private void actualizarTabla() {
        // Limpiar la tabla
        tableModel.setRowCount(0);

        // Ordenar los jugadores por calificación
        jugadores.sort(Comparator.comparingDouble(Jugador::calcularCalificacion).reversed());

        // Agregar los jugadores a la tabla
        for (Jugador jugador : jugadores) {
            tableModel.addRow(new Object[]{
                jugador.getPosicion(),
                jugador.getNombre(),
                jugador.getNumero(),
                jugador.getPartidosJugados(),
                String.format("%.2f", jugador.calcularCalificacion())
            });
        }
    }
    
    //Se hace un metodo nuvo para poder mostrar el error 
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}