/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clases.Ciudad;
import clases.OnliId;
import clases.Usuario;
import com.google.gson.Gson;
import conexion.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jose Fernando G2
 */
@WebServlet(name = "servletObtenerUsuario", urlPatterns = {"/obtenerusuario"})
//http://localhost:8080/Multitareapps/obtenerusuario?correo=&tipo=
public class servletObtenerUsuario extends HttpServlet {

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

        String correo_ingreso = "";
        String tipo = "";
        if (datos_1[0].equals("correo")) {
            correo_ingreso = datos_1[1];
        }
        if (datos_2[0].equals("tipo")) {
            tipo = datos_2[1];
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (!correo_ingreso.equals("")) {
                Gson g = new Gson();
                if (tipo.equals("1")) {
                    LinkedList<Object> retorno = getUsusario(correo_ingreso);
                    if (!retorno.isEmpty()) {
                        out.print(g.toJson(retorno));
                    } else {
                        out.print("NOT FOUND");
                    }
                } else if (tipo.equals("2")) {
                    LinkedList<Object> retorno = getId_usuario(correo_ingreso);
                    if (!retorno.isEmpty()) {
                        out.print(g.toJson(retorno));
                    } else {
                        out.print("NOT FOUND");
                    }
                }

            } else {
                out.print("NOT FOUND");
            }
        }
    }

    public LinkedList<Object> getUsusario(String correo_ingreso) {
        LinkedList<Object> retorno = new LinkedList<>();
        DBConnect db = new DBConnect();
        ResultSet resl;
        String SQL = "SELECT id_usuario, fk_rol, fk_ciudad, correo, contrasena, nombres, apellidos, \n"
                + "       experto, foto, direccion, fecha_nacimiento, telefono, fecha_creacion, \n"
                + "       fecha_modificacion, estado, creacion\n"
                + "  FROM public.\"Usuario\"\n"
                + "  WHERE correo = '" + correo_ingreso + "';";

        System.out.println(SQL);
        resl = db.executeQuery(SQL);
        try {
            while (resl.next()) {
                retorno.add(new Usuario(resl.getString(1), resl.getString(2), resl.getString(3), resl.getString(4), resl.getString(5),
                        resl.getString(6), resl.getString(7), resl.getString(8), resl.getString(9), resl.getString(10), resl.getString(11),
                        resl.getString(12), resl.getString(13), resl.getString(14), resl.getString(15), resl.getString(16)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(servletIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(retorno.size());
        return retorno;
    }

    public LinkedList<Object> getId_usuario(String correo_ingreso) {
        LinkedList<Object> retorno = new LinkedList<>();
        DBConnect db = new DBConnect();
        ResultSet resl;
        String SQL = "SELECT id_usuario\n"
                + "  FROM public.\"Usuario\"\n"
                + "  WHERE correo = '" + correo_ingreso + "';";

        System.out.println(SQL);
        resl = db.executeQuery(SQL);
        try {
            while (resl.next()) {
                retorno.add(new OnliId(resl.getString(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(servletIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(retorno.size());
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
