/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.Cliente;
import controlador.FileController;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcelo Esperguel
 */
public class Home extends JFrame {

    private JButton buscar;
    private JTextField campoBuscar; 
    private JButton nuevoCliente;
    private JPanel superior;
    private JTable clientes;
    private ArrayList<Cliente> clientesLista = new ArrayList<>();
            
    public Home() {
        super("Inicio");
        this.setSize(750, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        
        buscar= new JButton("Buscar");
        
        nuevoCliente= new JButton("Nuevo");
        nuevoCliente.addActionListener( (e) -> {
            
            desplegarVentanaNuevoCliente(e);
            
        });
        
        
               
        campoBuscar= new JTextField(20);
        
        
        
        superior= new JPanel();
        superior.setLayout(new FlowLayout());
        
        superior.add(nuevoCliente);
        superior.add(campoBuscar);
        superior.add(buscar);
        
        this.add(superior,BorderLayout.NORTH);
        
        String columnas[] = {"Rut","Nombres","Apellidos","Fecha Nacimiento"};
        DefaultTableModel dtm = new DefaultTableModel(columnas,0);
        
        clientes = new JTable(dtm);
        JScrollPane scroll = new JScrollPane(clientes);
        
        this.add(scroll,BorderLayout.CENTER);
        
        //Cargar aqui el archivo de clientes y lo cargan en la lista clientes, usando el controlador creen un nuevo metodo
        
            //luego actualizan tabla con la nueva lista
            this.actualizarTabla();
        ////
        
    }
    
    
    public void desplegarVentanaNuevoCliente(ActionEvent e){
        
        NuevoCliente vNuevoCliente = new NuevoCliente(this);
        vNuevoCliente.setLocationRelativeTo(this);
        vNuevoCliente.setVisible(true);
        
        
    }
    
    public void agregarClienteTabla(Cliente c){
        
        clientesLista.add(c);
        
        // Vamos a guardar automaticamente el archivo aquí.     
        FileController fCont = new FileController();  // Clase que creé para separar un poco el codigo de lectura/escritura de archivos.
        
        fCont.guardarClientes(clientesLista);
        
        actualizarTabla();
        
    }
    
    public void actualizarTabla(){
        
        String columnas[] = {"Rut","Nombres","Apellidos","Fecha Nacimiento"};
        DefaultTableModel dtm = new DefaultTableModel(columnas,0);
      
        for (int i = 0; i < clientesLista.size(); i++) {
            Cliente c = clientesLista.get(i);
            
             String[] fila= {c.getRut(), c.getNombres(), c.getApellidos(), c.getFecha()};

            dtm.addRow(fila);
        }
        
        clientes.setModel(dtm);
        
    }
}
