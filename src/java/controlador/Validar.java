/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Administrador;
import modelo.Empleado;
import modelo.AdministradorDAO;
import modelo.Cliente;
import modelo.ClienteDAO;

/**
 *
 * @author david
 */
public class Validar extends HttpServlet {

    private AdministradorDAO edao = new AdministradorDAO();
    private Administrador adm = new Administrador();
    private ClienteDAO cdao = new ClienteDAO();
    private Cliente cli = new Cliente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

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
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Ingresar")) {
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            adm = edao.validar(user, pass);
            cli = cdao.validar(user, pass);
            if (adm.getUser() != null) {
                request.setAttribute("usuario", adm);
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);

            }if (cli.getUsuario()!= null) {
                request.setAttribute("usuarioCli", cli);
                request.getRequestDispatcher("ControladorCli?accion=Vista").forward(request, response);

            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if (accion.equalsIgnoreCase("Salir")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        {

        }
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
