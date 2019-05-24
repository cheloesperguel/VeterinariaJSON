/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import Modelo.Cliente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Marcelo Esperguel
 */
public class FileController {

    public FileController() {
    }
    
    
    
    public void guardarClientes(ArrayList<Cliente> clientes){
        
        Gson gson = new GsonBuilder().create();
        FileWriter writer;
        
        try {
            writer = new FileWriter("data/clientes.json"); //debe existir la carpeta data
                                                           //Vayan a la carpeta del proyecto  ../VeterinariaJSON/data/                 
            gson.toJson(clientes, writer);
            writer.close();
        }catch (IOException ex) {
            System.out.println("Error al crear el archivo");
            ex.printStackTrace();
        }
    }
    
}
