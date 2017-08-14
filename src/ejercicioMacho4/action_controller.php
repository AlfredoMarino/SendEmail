<?php
	require_once 'dbController.php';
	require_once 'conexion.php';

	$rut = $_POST['rut'];
	$nombre = $_POST['nombre'];
	$email = $_POST['email'];
	$telefono = $_POST['telefono'];
	//$pais = $_POST['pais'];
	//$ciudad = $_POST['ciudad'];

	$consulta = "insert into personas(rut, nombre, email, telefono, id_pais, id_ciudad) values (".$rut.", '".$nombre."', 'correo', 123324, 2, 1);";

	$consulta = "update personas set nombre = 'marco', email = 'marcolino@hotmail.com', telefono = 79359287, id_pais = 3, id_ciudad = 1 where rut = ".$rut;

	$consulta = "delete from personas where rut = ".$rut;

	$consulta = "insert into personas(rut, nombre, email, telefono, id_pais, id_ciudad) values (".$rut.", '".$nombre."', 'correo', 123324, 2, 1);";

	//INSTANCIO LA CONEXION
	$con = conexion::getInstance();
	$dbConection = $con->getConexion();

	$dbControl = new dbController($dbConection);
	$dbControl->insertPersonas($consulta);
?>