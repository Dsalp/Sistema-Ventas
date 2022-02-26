/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionMySQL;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
public class ProductoDAO {

    private ConexionMySQL cn = new ConexionMySQL();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int res;

    public Producto buscar(int id) {
        Producto p = new Producto();
        String sql = "select * from producto where IdProducto=" + id;
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setFoto(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setEstado(rs.getString(6));
                p.setDescripcion(rs.getString(7));

            }
        } catch (Exception e) {
            System.out.println("ERROR" + e.getMessage());
        }
        return p;

    }

    public int ActualizarStock(int id, int stock) {
        String sql = "update producto set Stock=? where IdProducto=?";
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
             System.out.println("ERROR" + e.getMessage());
        }
        return res;
    }

    public List listar() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setId(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setFoto(rs.getString(3));
                pro.setPrecio(Double.parseDouble(rs.getString(4)));
                pro.setStock(Integer.parseInt(rs.getString(5)));
                pro.setEstado(rs.getString(6));
                pro.setDescripcion(rs.getString(7));
                lista.add(pro);

            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR PRODUCTO" + e.getMessage());
        }
        return lista;
    }

    public int agregar(Producto pro) {
        String sql = "insert into producto(Nombre, Foto, Precio, Stock, Estado, descripcion ) values (?,?,?,?,?,?)";
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, "x");
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getStock());
            ps.setString(5, pro.getEstado());
            ps.setString(6, pro.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR AL AGREGAR PRODUCTO" + e.getMessage());
        }
        return res;
    }

    public int actualizar(Producto pro) {
        String sql = "update producto set Nombre=?, Foto=?, Precio=?, Stock=?,Estado=?, descripcion=? where IdProducto=?";
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, "x");
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getStock());
            ps.setString(5, pro.getEstado());
            ps.setString(6, pro.getDescripcion());
            ps.setInt(7, pro.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR AL ACTUALIZAR PRODUCTO" + e.getMessage());
        }
        return res;
    }

    public void delete(int id) {
        String sql = "delete from producto where IdProducto=" + id;
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR AL ELIMINAR PRODUCTO" + e.getMessage());
        }
    }

    public Producto listarID(int id) {
        Producto pro = new Producto();
        String sql = "select * from producto where IdProducto=" + id;
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setId(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setFoto(rs.getString(3));
                pro.setPrecio(rs.getDouble(4));
                pro.setStock(rs.getInt(5));
                pro.setEstado(rs.getString(6));
                pro.setDescripcion(rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR2 PRODUCTO" + e.getMessage());
        }
        return pro;
    }
}
