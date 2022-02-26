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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class EmpleadoDAO {

    private ConexionMySQL cn = new ConexionMySQL();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int res;

    public Empleado buscar(String doc) {
        Empleado e = new Empleado();
        String sql = "select * from empleado where documento=" + doc;
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                e.setId(rs.getInt(1));
                e.setDocumento(rs.getString(2));
                e.setNombre(rs.getString(3));
                e.setTel(rs.getString(4));
                e.setEstado(rs.getString(5));
                e.setUser(rs.getString(6));

            }
        } catch (Exception ex) {
            System.out.println("Error al buscar empleado" + ex.getMessage());
        }
        return e;
    }

    public List listar() {
        String sql = "select * from empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDocumento(rs.getString(2));
                em.setNombre(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR EMPLEADO" + e.getMessage());
        }
        return lista;
    }

    public int agregar(Empleado em) {
        String sql = "insert into empleado(documento, Nombres, Telefono,Estado,User ) values (?,?,?,?,?) ";
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDocumento());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR AL AGREGAR EMPLEADO" + e.getMessage());
        }
        return res;
    }

    public int actualizar(Empleado em) {
        String sql = "update empleado set documento=?, Nombres=?, Telefono=?,Estado=?, User=? where IdEmpleado=?";
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDocumento());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR AL ACTUALIZAR EMPLEADO" + e.getMessage());
        }
        return res;
    }

    public void delete(int id) {
        String sql = "delete from empleado where IdEmpleado=" + id;
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR AL ELIMINAR EMPLEADO" + e.getMessage());
        }
    }

    public Empleado listarID(int id) {
        Empleado emp = new Empleado();
        String sql = "select * from empleado where IdEmpleado=" + id;
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setDocumento(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR EMPLEADO" + e.getMessage());
        }
        return emp;
    }
}
