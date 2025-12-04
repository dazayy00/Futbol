package GUI;

import Logic.EntrenadorService;
import Logic.FutbolistaService;
import Logic.MasajistaService;
import Logic.SeleccionService;
import Model.SeleccionFutbol;
import javax.swing.*;
import java.awt.*;

public class VentanaSeleccion extends JFrame{
    
    private final SeleccionService seleccionService;
    private final FutbolistaService futbolistaService;
    private final EntrenadorService entrenadorService;
    private final MasajistaService masajistaService;

    private JTextArea areaLog;
    private JComboBox<String> comboTipo;
    private JTextField txtId, txtNombre, txtApellidos, txtEdad;
    private JLabel lblEsp1, lblEsp2;
    private JTextField txtEsp1, txtEsp2;
    
    public VentanaSeleccion() {
        this.seleccionService = new SeleccionService();
        this.futbolistaService = new FutbolistaService();
        this.entrenadorService = new EntrenadorService();
        this.masajistaService = new MasajistaService();

        setTitle("Gestión Selección de Fútbol (Servicios Separados)");
        setSize(700, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
        
        actualizarLog(seleccionService.obtenerNominaCompleta()); 
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        JPanel panelAcciones = new JPanel(new FlowLayout());
        JButton btnConcentrar = new JButton("Concentrarse");
        JButton btnViajar = new JButton("Viajar");
        JButton btnTrabajar = new JButton("Trabajar (Polimorfismo)");
        JButton btnVerNomina = new JButton("Ver Nómina");
        
        panelAcciones.add(btnConcentrar);
        panelAcciones.add(btnViajar);
        panelAcciones.add(btnTrabajar);
        panelAcciones.add(btnVerNomina);
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

        JButton btnAgregar = new JButton("Agregar Integrante");
        panelForm.add(btnAgregar, BorderLayout.SOUTH);
        
        add(panelForm, BorderLayout.NORTH);


        comboTipo.addActionListener(e -> actualizarFormularioEspecifico());
        
        btnConcentrar.addActionListener(e -> accionConcentrar());
        btnViajar.addActionListener(e -> accionViajar());
        btnTrabajar.addActionListener(e -> accionTrabajar());
        btnVerNomina.addActionListener(e -> accionVerNomina());
        btnAgregar.addActionListener(e -> accionAgregar());
        
        actualizarFormularioEspecifico();
    }
    
    private void actualizarFormularioEspecifico() {
        String tipo = (String) comboTipo.getSelectedItem();
        if (tipo == null) return;
        
        switch (tipo) {
            case "Futbolista":
                lblEsp1.setText("Dorsal (num):");
                lblEsp2.setText("Demarcación (str):");
                txtEsp2.setVisible(true);
                lblEsp2.setVisible(true);
                break;
            case "Entrenador":
                lblEsp1.setText("ID Federación (str):");
                lblEsp2.setText("(N/A)");
                txtEsp2.setVisible(false);
                lblEsp2.setVisible(false);
                break;
            case "Masajista":
                lblEsp1.setText("Titulación (str):");
                lblEsp2.setText("Años Exp (num):");
                txtEsp2.setVisible(true);
                lblEsp2.setVisible(true);
                break;
        }
        limpiarCamposEspeciales();
    }
    
    private void accionAgregar() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            
            if (nombre.isEmpty() || apellidos.isEmpty()) {
                throw new IllegalArgumentException("Nombre y Apellidos no pueden estar vacíos.");
            }
            
            String tipo = (String) comboTipo.getSelectedItem();
            String val1 = txtEsp1.getText();
            String val2 = txtEsp2.getText();

            SeleccionFutbol nuevoIntegrante = null;
            
            switch(tipo){
                case "Futbolista":
                    int dorsal = Integer.parseInt(val1);
                    String demarcacion = val2;
                    nuevoIntegrante = futbolistaService.registrarFutbolista(id, dorsal, demarcacion, nombre, apellidos, edad);
                    break;
                
                case "Entrenador":
                    String idFederacion = val1;
                    nuevoIntegrante = entrenadorService.registrarEntrenador(idFederacion, id, nombre, apellidos, edad);
                    break;
                
                case "Masajista":
                    String titulacion = val1;
                    int exp = Integer.parseInt(val2); 
                    nuevoIntegrante = masajistaService.registrarMasajista(id, titulacion, exp, nombre, apellidos, edad);
                    break;
            }
            
            if (nuevoIntegrante != null) {
                seleccionService.agregarIntegrante(nuevoIntegrante);
                actualizarLog("¡NUEVO INTEGRANTE AGREGADO!: " + nuevoIntegrante.getNombreCompleto() + "\n" + seleccionService.obtenerNominaCompleta());
                limpiarFormulario();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en el formato de número (ID, Edad, Dorsal, Exp).", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Error de Validación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error desconocido: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void accionConcentrar() {
        String resultado = seleccionService.planificarConcentracion();
        actualizarLog(resultado);
    }
    
    private void accionViajar() {
        String resultado = seleccionService.gestionarViaje();
        actualizarLog(resultado);
    }
    
    private void accionTrabajar() {
        String resultado = seleccionService.iniciarEntrenamiento();
        actualizarLog(resultado);
    }

    private void accionVerNomina() {
        actualizarLog(seleccionService.obtenerNominaCompleta());
    }
 
    private void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtEdad.setText("");
        limpiarCamposEspeciales();
    }
    
    private void limpiarCamposEspeciales() {
        txtEsp1.setText("");
        txtEsp2.setText("");
    }
    
    private void actualizarLog(String texto) {
        areaLog.setText(texto);
        areaLog.setCaretPosition(0); 
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            VentanaSeleccion ventana = new VentanaSeleccion();
            ventana.setVisible(true);
        });
    }
}