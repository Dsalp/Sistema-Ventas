<%-- 
    Document   : Empleado
    Created on : 6/02/2022, 6:04:35 p.m.
    Author     : david
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card container mt-4 col-lg-3">
                <div class="card-body ">
                    <form action="Controlador?menu=Producto" method="POST">

                        <div class="form-group">
                            <label>Nombre</label> 
                            <input type="text" value="${producto.getNombre()}" name="txtNom" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Precio</label> 
                            <input type="text"  value="${producto.getPrecio()}" name="txtPre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Stock</label> 
                            <input type="text" value="${producto.getStock()}" name="txtStock" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label> 
                            <input type="text"  value="${producto.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Descripcion</label> 
                            <input type="text"  value="${producto.getDescripcion()}" name="txtDescrip" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Archivo</label> 
                            <input type="file"  value="${producto.getFoto()}"name="file" >
                        </div>
                       
                        <input type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-outline-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>FOTO</th>
                            <th>PRECIO</th>
                            <th>STOCK</th>
                            <th>ESTADO</th>
                            <th>DESCRIPCION</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead> 
                    <tbody>
                        <c:forEach var="pro" items="${productos}">
                            <tr>
                                <td>${pro.getId()}</td>
                                <td>${pro.getNombre()}</td>
                                <td>${pro.getFoto()}</td>
                                <td>$ ${pro.getPrecio()}</td>
                                <td>${pro.getStock()}</td>
                                <td>${pro.getEstado()}</td>
                                <td>${pro.getDescripcion()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${pro.getId()}">Editar</a>
                                    <a class="btn btn-danger"  href="Controlador?menu=Producto&accion=Delete&id=${pro.getId()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>

</html>
