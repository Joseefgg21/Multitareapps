/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clases.*;
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
@WebServlet(name = "servletRecomendado", urlPatterns = {"/recomendado"})
//http://localhost:8080/Multitareapps/recomendado?all
//http://localhost:8080/Multitareapps/recomendado?id_empresarecomendado=
public class servletRecomendado extends HttpServlet {

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
        String ingreso = "";
        String dato_1 = parametros;
        if (dato_1.equals("all")) {
            ingreso = "all";
        } else {
            String dato_2[] = parametros.split("=");
            if (dato_2[0].equals("id_empresarecomendado")) {
                ingreso = dato_2[1];
            }
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (ingreso.equals("all")) {
                System.out.println("Hola papi");
                Gson g = new Gson();
                LinkedList<Object> Retorno = Recomendados();

                if (!Retorno.isEmpty()) {
                    out.print(g.toJson(Retorno));
                } else {
                    out.print("NOT FOUND");
                }
            } else {
                if (!ingreso.equals("")) {
                    System.out.println("Hola papi");
                    Gson g = new Gson();
                    LinkedList<Object> Retorno = RecomendadoSolo(ingreso);

                    if (!Retorno.isEmpty()) {
                        out.print(g.toJson(Retorno));
                    } else {
                        out.print("NOT FOUND");
                    }
                }
            }
        }
    }

    public LinkedList<Object> Recomendados() throws IOException {
        LinkedList<Object> retorno = new LinkedList<>();
        DBConnect db = new DBConnect();
        ResultSet resl;
        String SQL = "SELECT id_empresarecomendado, fk_empresa, public.\"Empresa\".nombre, public.\"Empresa\".descripcion, public.\"Empresa\".foto     \n"
                + "  FROM public.\"EmpresaRecomendado\" JOIN public.\"Empresa\" ON public.\"EmpresaRecomendado\".fk_empresa = public.\"Empresa\".id_empresa";

        System.out.println(SQL);
        resl = db.executeQuery(SQL);
        try {
            while (resl.next()) {
                retorno.add(new Recomendado(resl.getString(1), resl.getString(2), resl.getString(3), resl.getString(4), resl.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(servletIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(retorno.size());
        return retorno;
    }

    public LinkedList<Object> RecomendadoSolo(String ingreso) throws IOException {
        LinkedList<Object> retorno = new LinkedList<>();
        DBConnect db = new DBConnect();
        ResultSet resl;
        String SQL = "SELECT id_empresarecomendado, fk_empresa, public.\"Empresa\".nombre, public.\"Empresa\".descripcion, public.\"Empresa\".foto \n"
                + "     FROM public.\"EmpresaRecomendado\" JOIN public.\"Empresa\" ON public.\"EmpresaRecomendado\".fk_empresa = public.\"Empresa\".id_empresa \n"
                + "     WHERE id_empresarecomendado = " + ingreso;

        System.out.println(SQL);
        resl = db.executeQuery(SQL);
        try {
            while (resl.next()) {
                retorno.add(new Recomendado(resl.getString(1), resl.getString(2), resl.getString(3), resl.getString(4), resl.getString(5)));
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
