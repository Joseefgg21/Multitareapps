/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import conexion.DBConnect;

/**
 *
 * @author Jose Fernando G2
 */
@WebServlet(name = "servletRegistro", urlPatterns = {"/registro"})
//http://localhost:8080/Multitareapps/registro?nombre=&apellido=&direccion=&cumpleanos=&correo=&contrasena=&ciudad=
public class servletRegistro extends HttpServlet {

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
        for (int i = 0; i < variables.length; i++) {
            System.out.println("Hola" + variables[i]);
        }
        System.out.println(variables.length);
        
        String[] datos_1 = variables[0].split("="); //nombre
        String[] datos_2 = variables[1].split("="); //apellido
        String[] datos_3 = variables[2].split("="); //direccion
        String[] datos_4 = variables[3].split("="); //cunpleanos
        String[] datos_5 = variables[4].split("="); //correo
        String[] datos_6 = variables[5].split("="); //contrasena
        String[] datos_7 = variables[6].split("="); //ciudad

        String nombre_ingreso = "";
        String apellido_ingreso = "";
        String direccion_ingreso = "";
        String cumpleanos_ingreso = "";
        String correo_ingreso = "";
        String contrasena_ingreso = "";
        String departamento_ingreso = "";
        String ciudad_ingreso = "";

        if (datos_1[0].equals("nombre")) {
            nombre_ingreso = datos_1[1];
        }
        if (datos_2[0].equals("apellido")) {
            apellido_ingreso = datos_2[1];
        }
        if (datos_3[0].equals("direccion")) {
            direccion_ingreso = datos_3[1];
        }
        if (datos_4[0].equals("cumpleanos")) {
            cumpleanos_ingreso = datos_4[1];
        }
        if (datos_5[0].equals("correo")) {
            correo_ingreso = datos_5[1];
        }
        if (datos_6[0].equals("contrasena")) {
            contrasena_ingreso = datos_6[1];
        }
        if (datos_7[0].equals("ciudad")) {
            ciudad_ingreso = datos_7[1];
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            System.out.println("");
            Gson g = new Gson();
            String usuario = ingresarUsuario(nombre_ingreso, apellido_ingreso, direccion_ingreso, cumpleanos_ingreso, correo_ingreso, contrasena_ingreso, departamento_ingreso, ciudad_ingreso);
            if (usuario.equals("ok")) {
                out.print("[" + g.toJson(usuario) + "]");
                
            } else {
                out.print("NOT FOUND");
            }

        }
    }

        //Rol: 3 para que sea un rol de usuario con registro
    //Experto : (0: no experto) (1: experto)
    //Estado : 1 activo
    //Creacion : 1 app
    public String ingresarUsuario(String nombre_ingreso, String apellido_ingreso, String direccion_ingreso,
            String cumpleanos_ingreso, String correo_ingreso, String contrasena_ingreso, String departamento_ingreso,
            String ciudad_ingreso) {
        String retorno = "";
        String contrasenaMd5 = getMD5(contrasena_ingreso);
        String cumpleanos = modificarCumple(cumpleanos_ingreso);

        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //hourdateFormat.format(date) 
        DBConnect db = new DBConnect();
        //db.Conexion();
        try {
            db.s = db.conn.createStatement();
            String SQL = "INSERT INTO public.\"Usuario\"(\n"
                    + "	    fk_rol, fk_ciudad, correo, contrasena, nombres, apellidos, \n"
                    + "            experto, foto, direccion, fecha_nacimiento, telefono, fecha_creacion, \n"
                    + "            fecha_modificacion, estado, creacion)\n"
                    + "    VALUES (3, " + ciudad_ingreso + ", '" + correo_ingreso + "','" + contrasenaMd5 + "',"
                    + "            '" + nombre_ingreso + "', '" + apellido_ingreso + "',\n"
                    + "            0, '', '" + direccion_ingreso + "', '" + cumpleanos + "',0 , '" + hourdateFormat.format(date) + "', \n"
                    + "            '" + hourdateFormat.format(date) + "', 1,1);";
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

    public String modificarCumple(String cumpleanos_ingreso) {
        String retorno = "";
        String fecha[] = cumpleanos_ingreso.split("-");
        String ultimo[] = fecha[2].split("T");
        retorno = fecha[0] + "-" + fecha[1] + "-" + ultimo[0];
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
