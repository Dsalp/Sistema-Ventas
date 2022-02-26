/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.GenerarSerie;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;
import modelo.AdministradorDAO;
import modelo.Carrito;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.EmpleadoDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Venta;
import modelo.VentaDAO;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author david
 */
public class Controlador extends HttpServlet {

    private Date hora = new Date();
    private SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
    private Empleado em = new Empleado();
    private EmpleadoDAO emdao = new EmpleadoDAO();
   
    private Cliente c = new Cliente();
    private ClienteDAO cdao = new ClienteDAO();
    private Producto pro = new Producto();
    private ProductoDAO pdao = new ProductoDAO();
    private List<Producto> productos2 = new ArrayList<>();
    private int ide, idc, idp;

    private Venta v = new Venta();
    private List<Venta> listaVenta = new ArrayList<>();
    private int item = 0;
    private int cod;
    private int cant;
    private String descripcion;
    private double precio;
    private double subtotal;
    private double total;
    private String numeroserie;
    private VentaDAO vdao = new VentaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        productos2 = pdao.listar();
        if (menu.equals("VistaPro")) {
            switch (accion) {
                case "A":
                default:
                    request.setAttribute("produc2", productos2);
                    request.getRequestDispatcher("VistaPro.jsp").forward(request, response);
            }
            request.getRequestDispatcher("VistaPro.jsp").forward(request, response);
        }
        if (menu.equals("Registrar")) {
            switch (accion) {
                case "Registrarse":
                    String nom = request.getParameter("txtNom");
                    String Usuario = request.getParameter("txtUser");

                    String doc = request.getParameter("txtDoc");
                    String dire = request.getParameter("txtDire");
                    String contra = request.getParameter("txtContra");
                    c.setDocumento(doc);
                    c.setNombre(nom);
                    c.setDireccion(dire);
                    c.setEstado("1");
                    c.setUsuario(Usuario);
                    c.setContraseña(contra);
                    cdao.agregar(c);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = emdao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String doc = request.getParameter("txtDoc");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTelefono");
                    String estado = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");
                    em.setDocumento(doc);
                    em.setNombre(nom);
                    em.setTel(tel);
                    em.setEstado(estado);
                    em.setUser(user);
                    emdao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = emdao.listarID(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    emdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String doc1 = request.getParameter("txtDoc");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTelefono");
                    String estado1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUsuario");
                    em.setDocumento(doc1);
                    em.setNombre(nom1);
                    em.setTel(tel1);
                    em.setEstado(estado1);
                    em.setUser(user1);
                    em.setId(ide);
                    emdao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Delete":
                    idc = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNom");
                    double pre = Double.parseDouble(request.getParameter("txtPre"));
                    int stoc = Integer.parseInt(request.getParameter("txtStock"));
                    String est = request.getParameter("txtEstado");
                    String desc = request.getParameter("txtDescrip");

                    pro.setNombre(nom);
                    pro.setPrecio(pre);
                    pro.setStock(stoc);
                    pro.setEstado(est);
                    pro.setDescripcion(desc);
                    pdao.agregar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Producto pa = pdao.listarID(idp);
                    request.setAttribute("producto", pa);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nom1 = request.getParameter("txtNom");
                    double pre1 = Double.parseDouble(request.getParameter("txtPre"));
                    int stoc1 = Integer.parseInt(request.getParameter("txtStock"));
                    String est1 = request.getParameter("txtEstado");
                    String desc1 = request.getParameter("txtDescrip");

                    pro.setNombre(nom1);
                    pro.setPrecio(pre1);
                    pro.setStock(stoc1);
                    pro.setEstado(est1);
                    pro.setDescripcion(desc1);
                    pro.setId(idp);
                    pdao.actualizar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "Buscar":

                    String doc = request.getParameter("codcliente");
                    c.setDocumento(doc);
                    c = cdao.buscar(doc);
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("total", total);
                    request.setAttribute("e", em);
                    break;
                case "BuscarEmpleado":

                    String doc2 = request.getParameter("codemp");
                    em.setDocumento(doc2);
                    em = emdao.buscar(doc2);
                    request.setAttribute("e", em);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("total", total);
                    request.setAttribute("c", c);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codproducto"));
                    pro = pdao.listarID(id);
                    request.setAttribute("e", em);
                    request.setAttribute("c", c);
                    request.setAttribute("total", total);
                    request.setAttribute("producto", pro);
                    request.setAttribute("lista", listaVenta);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "Agregar":
                    total = 0.0;
                    request.setAttribute("e", em);
                    request.setAttribute("c", c);
                    item = item + 1;
                    cod = pro.getId();
                    descripcion = request.getParameter("nombreproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = cant * precio;
                    v = new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcion(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    listaVenta.add(v);
                    for (int i = 0; i < listaVenta.size(); i++) {
                        total = total + listaVenta.get(i).getSubtotal();
                    }
                    request.setAttribute("total", total);
                    request.setAttribute("lista", listaVenta);
                    request.setAttribute("nserie", numeroserie);
                    break;

                case "GenerarVenta":
                    for (int i = 0; i < listaVenta.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad = listaVenta.get(i).getCantidad();
                        int idproducto = listaVenta.get(i).getIdproducto();
                        ProductoDAO Ao = new ProductoDAO();
                        pr = Ao.buscar(idproducto);
                        int soc = pr.getStock() - cantidad;
                        Ao.ActualizarStock(idproducto, soc);
                    }
                    v.setIdcliente(c.getId());
                    v.setIdempleado(em.getId());
                    v.setNumserie(numeroserie);
                    v.setFecha(formateador.format(hora));
                    v.setMonto(total);
                    v.setEstado("1");
                    vdao.guardarVenta(v);

                    int idv = Integer.parseInt(vdao.IdVentas());

                    for (int i = 0; i < listaVenta.size(); i++) {

                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(listaVenta.get(i).getIdproducto());
                        v.setCantidad(listaVenta.get(i).getCantidad());
                        v.setPrecio(listaVenta.get(i).getPrecio());

                        vdao.guardarDetalleVentas(v);
                    }
                    break;
                case "Delete":
                    int idproducto = Integer.parseInt(request.getParameter("idp"));
                    for (int i = 0; i < listaVenta.size(); i++) {
                        if (listaVenta.get(i).getItem() == idproducto) {
                            total = total - listaVenta.get(i).getSubtotal();
                            listaVenta.remove(i);
                        }
                    }
                    request.setAttribute("e", em);
                    request.setAttribute("c", c);
                    request.setAttribute("total", total);
                    request.setAttribute("lista", listaVenta);
                    request.setAttribute("nserie", numeroserie);

                    break;
                default:
                    em = new Empleado();
                    v = new Venta();
                    listaVenta = new ArrayList<>();
                    item = 0;
                    total = 0.0;
                    numeroserie = vdao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int cont = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(cont);
                        request.setAttribute("nserie", numeroserie);
                    }

                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }

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
