package GUI;

import Logic.SeleccionLogica;
import javax.swing.*;
import java.awt.*;

public class VentanaSeleccion extends JFrame{
    
    private final SeleccionLogica logica;

    private JTextArea areaLog;
    private JComboBox<String> comboTipo;
    private JTextField txtId, txtNombre, txtApellidos, txtEdad;
    private JLabel lblEsp1, lblEsp2;
    private JTextField txtEsp1, txtEsp2;
    
    public VentanaSeleccion() {
        this.logica = new SeleccionLogica();

        setTitle("Gestión Selección de Fútbol");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
        actualizarLog(logica.obtenerListaIntegrantes());
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        JPanel panelAcciones = new JPanel(new FlowLayout());
        JButton btnConcentrar = new JButton("Concentrarse");
        JButton btnViajar = new JButton("Viajar");
        JButton btnTrabajar = new JButton("Trabajar (Polimorfismo)");
        
        panelAcciones.add(btnConcentrar);
        panelAcciones.add(btnViajar);
        panelAcciones.add(btnTrabajar);
        add(panelAcciones, BorderLayout.SOUTH);

        areaLog = new JTextArea();
        areaLog.setEditable(false);
        areaLog.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollLog = new JScrollPane(areaLog);
        add(scrollLog, BorderLayout.CENTER);

        JPanel panelForm = new JPanel(new BorderLayout(5, 5));
        panelForm.setBorder(BorderFactory.createTitledBorder("Agregar Integrante"));
        
        JPanel formBase = new JPanel(new GridLayout(0, 2, 5, 5));
        formBase.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[]{"Futbolista", "Entrenador", "Masajista"});
        formBase.add(comboTipo);
        
        formBase.add(new JLabel("ID:"));
        txtId = new JTextField();
        formBase.add(txtId);
        
        formBase.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        formBase.add(txtNombre);
        
        formBase.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        formBase.add(txtApellidos);
        
        formBase.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        formBase.add(txtEdad);

        lblEsp1 = new JLabel("Dorsal:");
        txtEsp1 = new JTextField();
        lblEsp2 = new JLabel("Demarcación:");
        txtEsp2 = new JTextField();
        
        formBase.add(lblEsp1);
        formBase.add(txtEsp1);
        formBase.add(lblEsp2);
        formBase.add(txtEsp2);
        
        panelForm.add(formBase, BorderLayout.CENTER);

        JButton btnAgregar = new JButton("Agregar");
        panelForm.add(btnAgregar, BorderLayout.SOUTH);
        
        add(panelForm, BorderLayout.NORTH);


        comboTipo.addActionListener(e -> actualizarFormularioEspecifico());
        
        btnConcentrar.addActionListener(e -> accionConcentrar());
        btnViajar.addActionListener(e -> accionViajar());
        btnTrabajar.addActionListener(e -> accionTrabajar());
        btnAgregar.addActionListener(e -> accionAgregar());
        
        actualizarFormularioEspecifico();
    }
    
    private void actualizarFormularioEspecifico() {
        String tipo = (String) comboTipo.getSelectedItem();
        if (tipo == null) return;
        
        switch (tipo) {
            case "Futbolista":
                lblEsp1.setText("Dorsal:");
                lblEsp2.setText("Demarcación:");
                break;
            case "Entrenador":
                lblEsp1.setText("ID Federación:");
                lblEsp2.setText("(N/A)");
                break;
            case "Masajista":
                lblEsp1.setText("Titulación:");
                lblEsp2.setText("Años Exp:");
                break;
        }
        txtEsp1.setText("");
        txtEsp2.setText("");
    }
    
    private void accionAgregar() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            
            if (nombre.isEmpty() || apellidos.isEmpty()) {
                throw new Exception("Nombre y Apellidos no pueden estar vacíos.");
            }
            
            String tipo = (String) comboTipo.getSelectedItem();
            
            String val1 = txtEsp1.getText();
            String val2 = txtEsp2.getText();

            switch(tipo){
                case "Futbolista":
                    int dorsal = Integer.parseInt(val1);
                    String demarcacion = val2;
        
                logica.agregarFutbolista(id, dorsal, demarcacion, nombre, apellidos, edad);
                break;
                
                case "Entrenador":
                    String idFederacion = val1;
        
                    logica.agregarEntrenador(idFederacion, id, nombre, apellidos, edad);
                    break;
        
                case "Masajista":
                    String titulacion = val1;
                    int exp = Integer.parseInt(val2);
        
                    logica.agregarMasagista(id, titulacion, exp, nombre, apellidos, edad);
                    break;
                
            }
            
            actualizarLog("¡NUEVO INTEGRANTE AGREGADO!\n" + logica.obtenerListaIntegrantes());
            limpiarFormulario();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en el formato de número (ID, Edad, Dorsal, Exp).", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void accionConcentrar() {
        String resultado = logica.ejecutarConcentracion();
        actualizarLog(resultado);
    }
    
    private void accionViajar() {
        String resultado = logica.ejecutarViaje();
        actualizarLog(resultado);
    }
    
    private void accionTrabajar() {
        String resultado = logica.ejecutarTrabajoPolimorfico();
        actualizarLog(resultado);
    }
    
    private void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtEdad.setText("");
        txtEsp1.setText("");
        txtEsp2.setText("");
    }
    
    private void actualizarLog(String texto) {
        areaLog.setText(texto);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaSeleccion ventana = new VentanaSeleccion();
            ventana.setVisible(true);
        });
    }
}
