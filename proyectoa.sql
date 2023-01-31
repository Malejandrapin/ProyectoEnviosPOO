-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 24-05-2021 a las 00:59:12
-- Versión del servidor: 8.0.17
-- Versión de PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectoa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `idCiudad` varchar(10) NOT NULL,
  `nombreCiudad` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`idCiudad`, `nombreCiudad`) VALUES
('101', 'bogota'),
('102', 'Paipa'),
('103', 'Ibague'),
('104', 'Duitama'),
('105', 'Sogamoso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `identificacion` varchar(10) NOT NULL,
  `nombreCompleto` char(30) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `teléfono` varchar(10) DEFAULT NULL,
  `dirección` varchar(30) DEFAULT NULL,
  `Ciudad_idCiudad` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`identificacion`, `nombreCompleto`, `fechaNacimiento`, `teléfono`, `dirección`, `Ciudad_idCiudad`) VALUES
('109845678', 'Carlos Medina', '1978-04-25', '6441934', 'Cra 21 15-02', '102'),
('5423466', 'Laura', '1999-05-04', '8030678', 'Cra 51 128 45', '101');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `identificacion` varchar(10) NOT NULL,
  `nombreCompleto` char(30) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `teléfono` varchar(10) DEFAULT NULL,
  `Username` varchar(30) NOT NULL,
  `contraseña` varchar(10) DEFAULT NULL,
  `Rol_idRol` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`identificacion`, `nombreCompleto`, `fechaNacimiento`, `teléfono`, `Username`, `contraseña`, `Rol_idRol`) VALUES
('1019149939', 'Maira Alejandra Pinilla', '1999-07-09', '3118920136', 'mapinillap', 'mairapl', '2'),
('11111', 'Alexandra', '1999-05-01', '31111', 'Ale', '123', '2'),
('369874', 'Sebastián Cortes', '1985-10-05', '9857411', 'SebastiánC', 'P45678', '5'),
('526478', 'Pepita Mendieta', '1985-10-05', '5478921', 'PepitaM', 'N96512', '3'),
('635789', 'Jorge Pérez', '1982-02-01', '3685478', 'JorgeP', 'Q78430', '3'),
('9852471', 'Carlos Gómez', '1978-04-25', '2065874', 'CarlosG', 'Qr9075', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envio`
--

CREATE TABLE `envio` (
  `Id_envio` int(10) NOT NULL,
  `Id_Cliente` int(10) NOT NULL,
  `Id_Empleado` int(10) NOT NULL,
  `nombreD` varchar(30) NOT NULL,
  `Identificacion_D` int(10) NOT NULL,
  `Fecha` date NOT NULL,
  `Telefono` varchar(10) NOT NULL,
  `Direccion` varchar(30) NOT NULL,
  `Ciudad_origen` varchar(30) NOT NULL,
  `Ciudad_destino` varchar(30) NOT NULL,
  `Observaciones` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `envio`
--

INSERT INTO `envio` (`Id_envio`, `Id_Cliente`, `Id_Empleado`, `nombreD`, `Identificacion_D`, `Fecha`, `Telefono`, `Direccion`, `Ciudad_origen`, `Ciudad_destino`, `Observaciones`) VALUES
(1, 1027281237, 1027281237, 'Alejandra Saenz', 1027281237, '2021-05-18', '8030676', 'Cra 51 129 35', 'Paipa', 'Bogotá', 'Paquete delicado.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` varchar(10) NOT NULL,
  `nombreRol` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nombreRol`) VALUES
('1', 'Conductor'),
('2', 'Administrador'),
('3', 'Cajero'),
('4', 'Mensajero'),
('5', 'Bodeguero');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`idCiudad`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`identificacion`),
  ADD KEY `fk_Cliente_Ciudad1_idx` (`Ciudad_idCiudad`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`identificacion`),
  ADD KEY `fk_Empleado_Rol_idx` (`Rol_idRol`);

--
-- Indices de la tabla `envio`
--
ALTER TABLE `envio`
  ADD PRIMARY KEY (`Id_envio`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_Cliente_Ciudad1` FOREIGN KEY (`Ciudad_idCiudad`) REFERENCES `ciudad` (`idCiudad`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_Empleado_Rol` FOREIGN KEY (`Rol_idRol`) REFERENCES `rol` (`idRol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
