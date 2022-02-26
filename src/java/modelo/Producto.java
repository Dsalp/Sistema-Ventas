/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.InputStream;

/**
 *
 * @author david
 */
public class Producto {
    private int id,stock;
    private String nombre,estado,descripcion;
    private double precio;
    private String foto;

    public Producto() {
    }

    public Producto(int id, int stock, String nombre, String estado, String descripcion, double precio,  String foto) {
        this.id = id;
        this.stock = stock;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
    }

    public  String getFoto() {
        return foto;
    }

    public void setFoto( String foto) {
        this.foto = foto;
    }
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
