/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import conexion.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static servlets.servletRegistro.getMD5;

/**
 *
 * @author Jose Fernando G2
 */
@WebServlet(name = "servletIngresoServicioUsuario", urlPatterns = {"/ingresoserviciousuario"})
//http://localhost:8080/Multitareapps/ingresoserviciousuario?id_user=&id_servicio=
public class servletIngresoServicioUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=UTF-8");
        String parametros = request.getQueryString();
        System.out.println(parametros);
        String[] variables = parametros.split("&");

        String[] datos_1 = variables[0].split("=");
        String[] datos_2 = variables[1].split("=");

        String usuario_ingreso = "";
        String servicio_ingreso = "";
        if (datos_1[0].equals("id_user")) {
            usuario_ingreso = datos_1[1];
        }
        if (datos_2[0].equals("id_servicio")) {
            servicio_ingreso = datos_2[1];
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (!usuario_ingreso.equals("") && !servicio_ingreso.equals("")) {
                Gson g = new Gson();
                String usuario = ingresarUsuarioServicio(usuario_ingreso, servicio_ingreso);
                if (usuario.equals("ok")) {
                    out.print("[" + g.toJson(usuario) + "]");

                } else {
                    out.print("NOT FOUND");
                }
            } else {
                out.print("NOT FOUND");
            }
        }
    }

    //Estado (1: activo, 2: inactivo)
    public String ingresarUsuarioServicio(String usuario_ingreso, String servicio_ingreso) {
        String retorno = "";

        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //hourdateFormat.format(date) 
        DBConnect db = new DBConnect();
        //db.Conexion();
        try {
            db.s = db.conn.createStatement();
            String SQL = "INSERT INTO public.\"ServicioUsuario\"(\n"
                    + "            fk_usuario, fk_servicio, fecha_creacion, fecha_modificacion, estado)\n"
                    + "    VALUES (" + usuario_ingreso + ", " + servicio_ingreso + ", '" + hourdateFormat.format(date) + "', '" + hourdateFormat.format(date) + "',2);";
            System.out.println(SQL);
            int z = db.s.executeUpdate(SQL);
            System.out.println(z);
            if (z == 1) {
                System.out.println("ingresado la asitencia");
                retorno = "ok";
            } else {
                System.out.println("Ocurrio un problema al ingresar la asistencia");
            }
        } catch (Exception e) {
            System.out.println("Error de conexion");
        }
        return retorno;

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
