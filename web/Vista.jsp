<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Productos</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand">Empresa colchon</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="btn btn-outline-light" style="margin-left: 12px; border: none" href="ControladorCli?accion=home" ><i class="bi bi-basket"></i>Productos</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light" style="margin-left: 12px;border: none"  href="ControladorCli?accion=Carrito" t><i class="fas fa-cart-plus">(<label style="color: orange">${contador}</label>)</i>Carrito</a>
                    </li>

                </ul>
            </div>
            <div class="dropdown">
                <button style=" border: none "class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${usuarioCli.getNombre()}
                </button>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" >
                        <img src="img/user.png" alt="user" higth="60" width="60"/>
                    </a>
                    <a class="dropdown-item">  ${usuarioCli.getUsuario()}</a>
                    <a>Cliente</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">
                        <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>   
                    </form>

                </div>
            </div>
        </nav>
        <div class="container mt-4">
            <div class="row mt-4 ">
                <div class="col-xs-12 col-lg-2 text-center">
                    <img src="img/colchon.jpg" width="150px" />
                </div>
                <div class="col-xs-12 col-lg-8 text-center">
                    <h1>PRUEBAS1</h1>
                </div>
                <div class="col-xs-12 col-lg-2 text-center">
                    <img src="img/colchon.jpg" width="150px" />
                </div>
            </div>
            <br>
            <div class="row">
                <c:forEach var="p" items="${produc}">

                    <div class="col-sm-4 form-group">
                        <div class="card">
                            <div class="card-header text-center">
                                <label>${p.getNombre()}</label>
                            </div>
                            <div class="card-body text-center">
                                <img src="img/colchones-de-luxe-naturals-home.jpg" width="200" height="180">    
                            </div>
                            <div class="card-body text-center">
                                <i>Precio $.${p.getPrecio()}</i>

                            </div>

                            <div class="card-footer text-center">
                                <label>${p.getDescripcion()}</label>
                                <div class="text-center">

                                    <a  href="ControladorCli?accion=AgregarCarrito&id=${p.getId()}"class="btn btn-outline-primary">Agregar a carrito</a>
                                </div>
                            </div> 
                        </div>
                    </div> 


                </c:forEach>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
