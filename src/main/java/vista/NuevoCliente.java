/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.Cliente;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Marcelo Esperguel
 */
public class NuevoCliente extends JFrame{
    
    private JPanel formulario;
    private JPanel info;
    private JPanel botonera;
    private JLabel rutLabel;
    private JLabel nombresLabel;
    private JLabel apellidosLabel;
    private JLabel fechaNacLabel;
    private JTextField rutTf;
    private JTextField nombresTf;
    private JTextField apellidosTf;
    private JTextField fechaNacTf;
    private JButton agregarMascota;
    private JButton guardar;
    private JButton cancelar;
    
    private Home ventanaTabla;
    
    public NuevoCliente(Home ventanaTabla) {
        super("Nuevo Cliente");
        
        
        this.ventanaTabla = ventanaTabla;
        
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 400);
        this.setLayout(new BorderLayout());
        
        rutLabel = new JLabel("Rut");
        nombresLabel= new JLabel("Nombres");
        apellidosLabel= new JLabel("Apellidos");
        fechaNacLabel= new JLabel("Fecha Nacimiento");
        rutTf = new JTextField();
        nombresTf= new JTextField();
        apellidosTf= new JTextField();
        fechaNacTf= new JTextField();
        agregarMascota = new JButton("Agregar Mascota");
        
        agregarMascota.addActionListener( (e) -> {
        
            desplegarVentanaMascostas(e);
        });
        
        guardar = new JButton("Guardar");
        
        guardar.addActionListener( (e) -> {
            guardarInformación(e);
        });
        
        cancelar = new JButton("Cancelar");
        
        cancelar.addActionListener( (e) -> {
            cancelarOperacion(e);
        
        });
        
        
        
    
        
        
        formulario= new JPanel(new GridLayout(5, 2));
        
        formulario.add(rutLabel);
        formulario.add(rutTf);
        formulario.add(nombresLabel);
        formulario.add(nombresTf);
        formulario.add(apellidosLabel);
        formulario.add(apellidosTf);
        formulario.add(fechaNacLabel);
        formulario.add(fechaNacTf);
        formulario.add(agregarMascota);
        
        this.add(formulario,BorderLayout.CENTER);
        
        
        botonera = new JPanel(new FlowLayout());
        botonera.add(cancelar);
        botonera.add(guardar);
        
        this.add(botonera,BorderLayout.SOUTH);
        
        
    }
    
    
    private void cancelarOperacion(ActionEvent e){
        this.dispose();
        
    }
    
    private void guardarInformación(ActionEvent e){
        
        String rut= rutTf.getText();
        String nombres = nombresTf.getText();
        String apellidos = apellidosTf.getText();
        String fechaNac = fechaNacTf.getText();
        
        Cliente c = new Cliente(rut, nombres, apellidos, fechaNac);
        
        ventanaTabla.agregarClienteTabla(c);
        this.dispose();
    } 
    
    private void desplegarVentanaMascostas(ActionEvent e){
        
        Mascotas vMascotas = new Mascotas();
        vMascotas.setVisible(true);
        vMascotas.setLocationRelativeTo(this);
    }
    
    
    
}
