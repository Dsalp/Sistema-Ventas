<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            @media print{
                .parte1,.btn,.accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4 parte1">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex" >
                                    <input type="text" name="codcliente"  value="${c.getDocumento()}" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accion" value="Buscar" class="btn btn-primary"  >
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" value="${c.getNombre()}" class="form-control" placeholder="Datos Cliente">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos del Empleado</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex" >
                                    <input type="text" name="codemp"  value="${e.getDocumento()}" class="form-control" placeholder="Codigo">

                                    <button type="submit" name="accion" value="BuscarEmpleado" class="btn btn-primary">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nomemp" value="${e.getNombre()}" class="form-control" placeholder="Datos Empleado">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex" >
                                    <input type="text" name="codproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-primary">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreproducto" value="${producto.getNombre()}" class="form-control" placeholder="Datos Producto">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-4 d-flex">
                                    <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="$/0.0">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="cant" value="1" class="form-control" >
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock"  value="${producto.getStock()}"class="form-control" placeholder="Stock">
                                </div>
                            </div>

                            <div class="form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">Agregar</button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-12 ">
                            
                                <label>NumeroSerie: </label>
                           
                            <input type="text" name="NroSerie" value="${nserie}"class="form-control">
                            <br>
                            
                               <label>NombreCliente: </label>
                            
                            <input type="text" name="Nomb" value="${c.getNombre()}"class="form-control ">
                            
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getId()}</td>
                                        <td>${list.getDescripcion()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td>

                                            <a class="btn btn-outline-danger" href="Controlador?menu=NuevaVenta&accion=Delete&idp=${list.getItem()}"  >eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="card-footer d-flex">
                            <div class="col-sm-6">
                                <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>


                            </div>
                            <div class="col-sm-1 ml-auto">
                                <label>Total:</label>
                            </div>
                            <div class="col-sm-4">
                                <input type="text" name="txtTotal" value="$/. ${total}0" class="form-control">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
