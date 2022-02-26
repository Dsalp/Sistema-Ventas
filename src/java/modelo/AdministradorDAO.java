/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import conexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david- 
 */
public class AdministradorDAO {

    private ConexionMySQL cn = new ConexionMySQL();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int res;

    public Administrador validar(String user, String contraseña) {
        Administrador adm = new Administrador();
        String sql = "select * from administrador where usuario=? and contraseña=?";
        try {
            con = cn.ConexionMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            while (rs.next()) {
                adm.setId(rs.getInt("id_admin"));
                adm.setUser(rs.getString("usuario"));
                adm.setContraseña(rs.getString("Contraseña"));
                adm.setNombre(rs.getString("nombre"));

            }
        } catch (Exception e) {
            System.out.println("Error al validar" + e.getMessage());
        }
        return adm;
    }

}
