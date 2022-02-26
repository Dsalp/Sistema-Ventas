-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-02-2022 a las 19:51:26
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ventas2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id_admin` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `contraseña` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id_admin`, `nombre`, `usuario`, `contraseña`) VALUES
(1, 'David Aldana', 'Divad234', 'hola234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `Documento` varchar(8) DEFAULT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Direccion` varchar(244) DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL,
  `Usuario` varchar(80) NOT NULL,
  `Contraseña` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `Documento`, `Nombres`, `Direccion`, `Estado`, `Usuario`, `Contraseña`) VALUES
(23, '1', 'Jolene Parton', 'Norte', '1', 'JoPa', '456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `IdDetalleVentas` int(11) UNSIGNED NOT NULL,
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Cantidad` int(11) UNSIGNED DEFAULT NULL,
  `PrecioVenta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_ventas`
--

INSERT INTO `detalle_ventas` (`IdDetalleVentas`, `IdVentas`, `IdProducto`, `Cantidad`, `PrecioVenta`) VALUES
(155, 116, 1, 1, 1250000),
(156, 116, 3, 1, 600000),
(157, 117, 33, 1, 15000),
(158, 117, 37, 1, 5000000),
(159, 118, 2, 1, 100000),
(160, 118, 1, 5, 1250000),
(161, 119, 3, 1, 600000),
(162, 119, 4, 1, 950000),
(163, 120, 1, 1, 1250000),
(164, 121, 2, 1, 100000),
(165, 122, 3, 1, 600000),
(166, 123, 3, 2, 600000),
(167, 124, 3, 1, 600000),
(168, 125, 3, 1, 600000),
(169, 126, 3, 1, 600000),
(170, 128, 3, 2, 600000),
(171, 128, 4, 5, 950000),
(172, 128, 33, 1, 15000),
(173, 129, 3, 2, 600000),
(174, 129, 4, 5, 950000),
(175, 129, 33, 1, 15000),
(176, 130, 33, 2, 15000),
(177, 130, 3, 2, 600000),
(178, 136, 1, 2, 1250000),
(179, 136, 2, 1, 100000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IdEmpleado` int(10) UNSIGNED NOT NULL,
  `documento` varchar(40) NOT NULL,
  `Nombres` varchar(255) DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL,
  `User` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IdEmpleado`, `documento`, `Nombres`, `Telefono`, `Estado`, `User`) VALUES
(1, '2', 'Pedro Hernandez', '988252459', '1', 'emp01'),
(11, '3', 'Camila Garcia', '123456', '1', 'Peta'),
(12, '4', 'Chiscuico', '7541457', '1', 'Chicui'),
(15, '5', 'Marcela Gacho', '12585', '1', 'GachaMa'),
(16, '6', 'Pablo Martinez', '78546', '1', 'PaMa'),
(18, '7', 'Paula', '44587', '1', 'palsur');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Nombre` varchar(244) NOT NULL,
  `Foto` varchar(200) NOT NULL,
  `Precio` double NOT NULL,
  `Stock` int(11) UNSIGNED NOT NULL,
  `Estado` varchar(1) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`IdProducto`, `Nombre`, `Foto`, `Precio`, `Stock`, `Estado`, `descripcion`) VALUES
(1, 'Colchon King', 'x', 1250000, 47, '1', 'Tamano 200x200cms'),
(2, 'Colchoneta', 'x', 100000, 48, '1', 'Tamano 80x170cms'),
(3, 'Colchon Sencillo', 'x', 600000, 37, '1', 'Tamano 100x190cms'),
(4, 'Colchon Queen ', 'x', 950000, 39, '1', 'Tamano 160x190cms'),
(5, 'Colchon Doble', 'x', 850000, 50, '1', 'Tamano 140x190cms'),
(6, 'Colchon Electrico ', 'x', 3000000, 3, '1', 'Es tactico '),
(33, 'Colchon de juguete', 'x', 15000, 6, '1', 'Es de juguete'),
(37, 'Colchon termico', 'x', 5000000, 3, '1', 'Es caliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `IdEmpleado` int(10) UNSIGNED NOT NULL,
  `NumeroSerie` varchar(244) DEFAULT NULL,
  `FechaVentas` date DEFAULT NULL,
  `Monto` double DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`IdVentas`, `IdCliente`, `IdEmpleado`, `NumeroSerie`, `FechaVentas`, `Monto`, `Estado`) VALUES
(110, 23, 1, '00000001', '2022-02-24', 2600000, '1'),
(111, 23, 1, '00000002', '2022-02-24', 1350000, '1'),
(112, 23, 1, '00000003', '2022-02-24', 1350000, '1'),
(114, 23, 1, '00000004', '2022-02-24', 1350000, '1'),
(115, 23, 1, '00000005', '2022-02-24', 1350000, '1'),
(116, 23, 1, '00000006', '2022-02-24', 1850000, '1'),
(117, 23, 1, '00000007', '2022-02-24', 5015000, '1'),
(118, 23, 1, '00000008', '2022-02-24', 6350000, '1'),
(119, 23, 1, '00000009', '2022-02-24', 1550000, '1'),
(120, 23, 12, '00000010', '2022-02-24', 1250000, '1'),
(121, 23, 1, '00000011', '2022-02-24', 100000, '1'),
(122, 23, 15, '00000012', '2022-02-24', 600000, '1'),
(123, 23, 1, '00000013', '2022-02-25', 1200000, '1'),
(124, 23, 1, '00000014', '2022-02-25', 600000, '1'),
(125, 23, 1, '00000015', '2022-02-25', 600000, '1'),
(126, 23, 1, '00000015', '2022-02-25', 600000, '1'),
(128, 23, 1, '00000016', '2022-02-25', 5965000, '1'),
(129, 23, 1, '00000016', '2022-02-25', 5965000, '1'),
(130, 23, 12, '00000017', '2022-02-26', 1230000, '1'),
(136, 23, 1, '00000018', '2022-02-26', 2600000, '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`IdDetalleVentas`,`IdVentas`,`IdProducto`),
  ADD KEY `Ventas_has_Producto_FKIndex1` (`IdVentas`),
  ADD KEY `Ventas_has_Producto_FKIndex2` (`IdProducto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IdEmpleado`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IdProducto`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IdVentas`),
  ADD KEY `Ventas_FKIndex1` (`IdEmpleado`),
  ADD KEY `Ventas_FKIndex2` (`IdCliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `IdDetalleVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=180;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `IdEmpleado` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `IdProducto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `IdVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=137;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `detalle_ventas_ibfk_1` FOREIGN KEY (`IdVentas`) REFERENCES `ventas` (`IdVentas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detalle_ventas_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
