
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
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="btn btn-outline-light" style="margin-left: 12px; border: none" href="Controlador?menu=VistaPro&accion=default" target="myFrame">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light" style="margin-left: 12px;border: none"  href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light" style="margin-left: 12px;border: none" href="Controlador?menu=Empleado&accion=Listar"target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a  class="btn btn-outline-light" style="margin-left: 12px;border: none" href="Controlador?menu=Cliente&accion=Listar"target="myFrame">Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a  class="btn btn-outline-light" style="margin-left: 12px; border: none" href="Controlador?menu=NuevaVenta&accion=default"target="myFrame">Nueva Venta</a>
                    </li>

                </ul>
            </div>
            <div class="dropdown" >
                <button style=" border: none "class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${usuario.getNombre()}
                </button>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" >
                        <img src="img/user.png" alt="user" higth="60" width="60"/>
                    </a>
                    <a class="dropdown-divider"> ${usuario.getUser()}</a>
                    <a>Administrador</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">
                        <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>  
                    </form>

                </div>
            </div>
        </nav>
        <div class="m-4" style="height: 850px;">
            <iframe name="myFrame" style=" height: 100%; width: 100%; border: none"></iframe>
        </div>               
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
