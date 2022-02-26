/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class ClienteDAO {

    private ConexionMySQL cn = new ConexionMySQL();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int res;

    public Cliente validar(String user, String contraseña) {
        Cliente cli = new Cliente();
        String sql = "select * from cliente where usuario=? and contraseña=?";
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setId(rs.getInt("IdCliente"));
                cli.setDocumento(rs.getString("Documento"));
                cli.setNombre(rs.getString("Nombres"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setEstado(rs.getString("Estado"));
                cli.setUsuario(rs.getString("Usuario"));
                cli.setContraseña(rs.getString("Contraseña"));

            }
        } catch (Exception e) {
            System.out.println("Error al validar cliente" + e.getMessage());
        }
        return cli;
    }

    public Cliente buscar(String doc) {
        Cliente c = new Cliente();
        String sql = "select * from cliente where Documento=" + doc;
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setDocumento(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
                c.setUsuario(rs.getString(6));
                c.setContraseña(rs.getString(7));
            }
        } catch (Exception ex) {
            System.out.println("Error al buscar cliente" + ex.getMessage());
        }
        return c;
    }

    public List listar() {
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt(1));
                cli.setDocumento(rs.getString(2));
                cli.setNombre(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
                cli.setUsuario(rs.getString(6));
                cli.setContraseña(rs.getString(7));
                lista.add(cli);
            }
        } catch (Exception e) {
            System.out.println("Error al listar cliente" + e.getMessage());
        }
        return lista;
    }

    public int agregar(Cliente cli) {
        String sql = "insert into cliente(Documento, Nombres, Direccion,Estado,Usuario,Contraseña) values (?,?,?,?,?,?)";
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDocumento());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.setString(5, cli.getUsuario());
            ps.setString(6, cli.getContraseña());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar cliente" + e.getMessage());
        }
        return res;
    }

    public int actualizar(Cliente cli) {
        String sql = "update cliente set Documento=?, Nombres=?, Direccion=?,Estado=? , Usuario=?, Contraseña=? where IdCliente=?";
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDocumento());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.setString(5, cli.getUsuario());
            ps.setString(6, cli.getContraseña());
            ps.setInt(7, cli.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente" + e.getMessage());
        }
        return res;
    }

    public void delete(int id) {
        String sql = "delete from cliente where IdCliente=" + id;
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente" + e.getMessage());
        }
    }

    public Cliente listarID(int id) {
        Cliente pro = new Cliente();
        String sql = "select * from cliente where IdCliente=" + id;
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setDocumento(rs.getString(2));
                pro.setNombre(rs.getString(3));
                pro.setDireccion(rs.getString(4));
                pro.setEstado(rs.getString(5));

            }
        } catch (Exception e) {
            System.out.println("Error al listar cliente" + e.getMessage());
        }
        return pro;
    }
}
