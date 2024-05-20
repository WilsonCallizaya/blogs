package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
        static String driver ="com.mysql.cj.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3308/bd_blog";
    static String user="root";
    static String password="";
    
    protected Connection conn= null;
    
    public ConexionBD(){
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el driver");
        } catch (SQLException ex) {
            System.out.println("Error al conectar");
        }
        
    }    
    
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion");
        }
    }
}
