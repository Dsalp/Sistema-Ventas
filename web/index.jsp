<%-- 
    Document   : index
    Created on : 5/02/2022, 2:23:56 p.m.
    Author     : david
--%>

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
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                <a class="navbar-brand">Empresa colchon</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="btn btn-outline-light" style="margin-left: 12px; border: none"href="Controlador?menu=VistaPro&accion=default"  target="myFrame">Inicio <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="btn btn-outline-light" style="margin-left: 12px; border: none" href="login.jsp">Ingresar <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="btn btn-outline-light" style="margin-left: 12px; border: none" href="Registrar.jsp">Registrar <span class="sr-only">(current)</span></a>
                        </li>

                    </ul>

                </div>
            </nav>
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

        </div> 

        <div class="m-4" style="height: 850px;">
            <iframe h name="myFrame" style=" height: 100%; width: 100%; border: none" href="Controlador?menu=Prueba" ></iframe>

        </div>  
        <div>

        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
