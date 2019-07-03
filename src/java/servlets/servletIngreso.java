/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clases.Login;
import com.google.gson.Gson;
import conexion.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
@WebServlet(name = "servletIngreso", urlPatterns = {"/ingreso"})
//http://localhost:8080/Multitareapps/ingreso?usuario=&contrasena=
public class servletIngreso extends HttpServlet {

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

        String[] datos_1 = variables[0].split("="); //nombre
        String[] datos_2 = variables[1].split("="); //apellido

        String usuario = "";
        String contrasena = "";

        if (datos_1[0].equals("usuario")) {
            usuario = datos_1[1];
        }
        if (datos_2[0].equals("contrasena")) {
            contrasena = datos_2[1];
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (!usuario.equals("") && !contrasena.equals("")) {
                Gson g = new Gson();
                LinkedList<Object> retorno = Login(usuario, contrasena);
                if (!retorno.isEmpty()) {
                    out.print(g.toJson(retorno));
                } else {
                    out.print("NOT FOUND");
                }
            } else {
                out.print("NOT FOUND");
            }
        }
    }

    public LinkedList<Object> Login(String usuario, String contraseña) {
        String contrasenaMd5 = getMD5(contraseña);
        LinkedList<Object> retorno = new LinkedList<>();
        DBConnect db = new DBConnect();
        ResultSet resl;
        String SQL = "SELECT correo, contrasena\n"
                + "  FROM public.\"Usuario\"\n"
                + "  WHERE correo = '" + usuario + "'"
                + "  AND contrasena = '"+contrasenaMd5+"';";

        System.out.println(SQL);
        resl = db.executeQuery(SQL);
        try {
            while (resl.next()) {
                retorno.add(new Login(resl.getString(1), resl.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(servletIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(retorno.size());
        return retorno;
    }
    
       public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
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
