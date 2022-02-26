/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author david
 */
public class Administrador {
    private int id;
    private String contraseña;
    private String nombre;
   
    private String user;
  

    public Administrador() {
    }

    public  Administrador(int id, String contra, String nombre, String user) {
        this.id = id;
        this.contraseña = contra;
        this.nombre = nombre;
        
        this.user = user;
        
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String dni) {
        this.contraseña = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
