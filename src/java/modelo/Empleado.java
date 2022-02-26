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
public class Empleado {
    private int id;
    private String documento;
    private String nombre;
    private String estado;
    private String user;
    private String tel;
    

    public Empleado() {
    }

    public Empleado(int id, String documento, String nombre,String tel, String estado, String user) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.tel=tel;
        this.estado = estado;
        this.user = user;
        
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    
    
}
