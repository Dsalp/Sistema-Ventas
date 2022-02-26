/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author david
 */
public class ConexionMySQL {
    
    private Connection con;
    private String url="jdbc:mysql://localhost:3306/";
    private String nom_bd="bd_ventas2";
    private String user="root";
    private String pss="";
    
    public Connection ConexionMySQL(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url+nom_bd,user,pss);
        }catch(Exception ex){
            System.out.println("ERROR de conexion"+ex.getMessage());
        }
        return con;
    }
}
