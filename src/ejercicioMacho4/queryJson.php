<?php
	require_once 'conexion.php';

	//INSTANCIO LA CONEXION
	$con = conexion::getInstance();
	$dbConection = $con->getConexion();

	//DEPENDIENDO DE LA VARIABLE QRY TOMA DIFERENTE QUERY
	$opcion = $_GET['qry'];

	switch ($opcion) {

		//COMBO CIUDAD DEPENDE DEL PAIS
		case 1:
			$consulta = "SELECT * FROM ciudad a, pais b where a.id_pais = b.id_pais and b.id_pais = ".$_GET['c'].";";

		break;

		//COMBO PAIS
		case 2:
			$consulta = "SELECT * FROM pais";

		break;

		//BUSCA PERSONA
		case 3:
			$consulta = "SELECT * FROM personas a, pais b, ciudad c where a.id_pais = b.id_pais and b.id_pais = c.id_pais and a.id_ciudad = c.id_ciudad and rut = ".$_GET['c'].";";

		break;

		case 4:
			$consulta = "SELECT * FROM personas a, pais b, ciudad c where a.id_pais = b.id_pais and b.id_pais = c.id_pais and a.id_ciudad = c.id_ciudad";
			break;
		
		default:
			# code...
		break;
	}

	//EJECUTA CONSULTA
	$resultado = pg_query($dbConection,$consulta);

	//DEVUELVE CONSULTA COMO JSON
	$resultArray = pg_fetch_all($resultado);
	echo json_encode($resultArray);

	//CIERRA LA CONEXION
	pg_close($dbConection);


?>