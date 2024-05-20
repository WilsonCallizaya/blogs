
package com.emergentes.dao;

import com.emergentes.modelo.Aviso;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class avisoDAOimpl extends ConexionBD implements avisoDAO{

    @Override
    public void insert(Aviso aviso) throws Exception {
            
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("insert into post (fecha,titulo,contenido) values (?,?,?);");
            ps.setString(1,aviso.getFecha());
            ps.setString(2, aviso.getTitulo());
            ps.setString(3,aviso.getContenido());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        }

    @Override
    public void update(Aviso aviso) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("update post set titulo=?,fecha=?,contenido=? where id=?");
            ps.setString(1,aviso.getTitulo());
            ps.setString(2, aviso.getFecha());
            ps.setString(3,aviso.getContenido());
            ps.setInt(4,aviso.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
       }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareCall("delete from post where id=?;");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }finally{
            this.desconectar();
        }
        }
    @Override
    public List<Aviso> getAll() throws Exception {
        List<Aviso> lista = new ArrayList<Aviso>();
        
        try {
            String sql = "select * from post ORDER BY fecha DESC;";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Aviso avi = new Aviso();
                avi.setId(rs.getInt("id"));
                avi.setFecha(rs.getString("fecha"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setContenido(rs.getString("contenido"));
                lista.add(avi);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    @Override
    public Aviso getById(int id) throws Exception {
        Aviso avi= new Aviso();

            this.conectar();
            PreparedStatement ps=this.conn.prepareCall("select * from post where id=? limit 1;");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                avi.setId(rs.getInt("id"));
                avi.setFecha(rs.getString("fecha"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setContenido(rs.getString("contenido"));
            }
            this.desconectar();
            return avi;
        }

    
}
