/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Carrito;
import modelo.Producto;
import modelo.ProductoDAO;


/**
 *
 * @author david
 */
public class ControladorCli extends HttpServlet {

    ProductoDAO pdao = new ProductoDAO();
    Producto p = new Producto();
    List<Producto> productos = new ArrayList<>();
    List<Carrito> listaCarrito = new ArrayList<>();
    int item = 0;
    int idp;
    double totalpagar = 0.0;
    int cantidad = 1;

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
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        productos = pdao.listar();

        switch (accion) {
            case "Vista":
                request.getRequestDispatcher("Vista.jsp").forward(request, response);
                break;
            case "AgregarCarrito":
                cantidad = 1;
                idp = Integer.parseInt(request.getParameter("id"));
                p = pdao.listarID(idp);
                boolean centinela = true;
                if (listaCarrito.size() > 0) {
                    for (int i = 0; i < listaCarrito.size() && centinela == true; i++) {
                        if (idp == listaCarrito.get(i).getIdProducto()) {
                            centinela = false;
                            cantidad += listaCarrito.get(i).getCantidad();
                            double subtotal = listaCarrito.get(i).getPrecioCompra() * cantidad;
                            listaCarrito.get(i).setCantidad(cantidad);
                            listaCarrito.get(i).setSubTotal(subtotal);
                        }
                    }
                    if (centinela == true) {
                        item = item + 1;
                        Carrito car = new Carrito();
                        car.setItem(item);
                        car.setIdProducto(p.getId());
                        car.setNombres(p.getNombre());
                        car.setDescripcion(p.getDescripcion());
                        car.setPrecioCompra(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad * p.getPrecio());
                        listaCarrito.add(car);
                    }

                } else {
                    item = item + 1;
                    Carrito car = new Carrito();
                    car.setItem(item);
                    car.setIdProducto(p.getId());
                    car.setNombres(p.getNombre());
                    car.setDescripcion(p.getDescripcion());
                    car.setPrecioCompra(p.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad * p.getPrecio());
                    listaCarrito.add(car);

                }
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("ControladorCli?accion=home").forward(request, response);

                break;
            case "Delete":
                int idproducto = Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getItem() == idproducto) {
                        listaCarrito.remove(i);
                    }
                }

                request.getRequestDispatcher("ControladorCli?accion=Carrito").forward(request, response);

                break;
            case "Carrito":
                totalpagar = 0;
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalpagar = totalpagar + listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("totalpagar", totalpagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;

            default:

                request.setAttribute("produc", productos);
                request.getRequestDispatcher("Vista.jsp").forward(request, response);
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
