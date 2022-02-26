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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card container mt-4 col-lg-3">
                <div class="card-body ">
                    <form action="Controlador?menu=Empleado" method="POST">

                        <div class="form-group">
                            <label>Documento</label> 
                            <input type="text" value="${empleado.getDocumento()}" name="txtDoc" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label> 
                            <input type="text" value="${empleado.getNombre()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Teléfono</label> 
                            <input type="text" value="${empleado.getTel()}" name="txtTelefono" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label> 
                            <input type="text" value="${empleado.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label> 
                            <input type="text" value="${empleado.getUser()}" name="txtUsuario" class="form-control">
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
                            <th>DOCUMENTO</th>
                            <th>NOMBRE</th>
                            <th>TELEFONO</th>
                            <th>ESTADO</th>
                            <th>USER</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead> 
                    <tbody>
                        <c:forEach var="em" items="${empleados}">
                            <tr>
                                <td>${em.getId()}</td>
                                <td>${em.getDocumento()}</td>
                                <td>${em.getNombre()}</td>
                                <td>${em.getTel()}</td>
                                <td>${em.getEstado()}</td>
                                <td>${em.getUser()}</td>
                                <td>
                                    <a class="btn btn-outline-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}">Editar</a>
                                    <a class="btn btn-outline-danger"  href="Controlador?menu=Empleado&accion=Delete&id=${em.getId()}">Eliminar</a>
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
