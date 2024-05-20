
package com.emergentes.control;

import com.emergentes.dao.avisoDAO;
import com.emergentes.dao.avisoDAOimpl;
import com.emergentes.modelo.Aviso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "inicio", urlPatterns = {"/inicio"})
public class inicio extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            avisoDAO dao= new avisoDAOimpl();
            int id;
            Aviso avi= new Aviso();
            String action =(request.getParameter("action")!=null)? request.getParameter("action"):"view";
            switch(action){
                case "add":
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("formulario.jsp").forward(request, response);
                   
                    break;
                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    avi=dao.getById(id);
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("formulario.jsp").forward(request, response);
                    
                    break;
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/inicio");
                   
                    break;
                case "view":
                    List<Aviso> lista = new ArrayList<Aviso>();
                
                        lista=dao.getAll();
                        System.out.println("lista de aviso "+ lista);
                    request.setAttribute("aviso", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                   
                    break;
                default:
                    break;
            }
            
        } catch (Exception e) {
        }
        }
    
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String fecha=request.getParameter("fecha");
        String titulo=request.getParameter("titulo");
        String contenido=request.getParameter("contenido");
        
        Aviso avi= new Aviso();
        avi.setId(id);
        avi.setFecha(fecha);
        avi.setTitulo(titulo);
        avi.setContenido(contenido);
        avisoDAO dao= new avisoDAOimpl();
        if(id==0){
            try {
                dao.insert(avi);
            } catch (Exception ex) {
                Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{
            try {   
                dao.update(avi);
            } catch (Exception ex) {
                Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                response.sendRedirect(request.getContextPath()+"/inicio");
        }
    }

