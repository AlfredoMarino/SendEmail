<!DOCTYPE html>
<html>
<head>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="JS/index.js"></script>
	

	<style type="text/css">
 
		input{
			margin: 0;
		}
		 
		label{
			display: inline-block;
			width: 100px;
			margin-right: 15px;
		}
		input[type="text"]{
			margin-bottom: 5px;
		}

		select{
			width: 173px;
			margin-bottom: 5px;
		}
		
	</style>

	<title>Ejercicio Macho</title>
</head>
<body>
	<form id="form1" method="POST">
		<label>RUT</label>
		<input type="text" name="rut" id="rut" ><br>

		<label>Nombre</label>
		<input type="text" name="nombre" id="name" ><br>

		<label>Email</label>
		<input type="text" name="email" id="email" ><br>

		<label>Telefono</label>
		<input type="text" name="telefono" id="phone_number" ><br>

		<label>Pais</label>
		<select name="pais" id="country">
		</select><br>

		<label>Ciudad</label>
		<select name="ciudad" id="cities">
		</select><br>

		<input type="submit" name="botonInsertar" id="button" value="Insertar">

	</form>

	<div>
		<table id="master_table">
			<tr>
				<th>rut</th>
				<th>nombre</th>
				<th>email</th>
				<th>telefono</th>
				<th>pais</th>
				<th>ciudad</th>
			</tr>
			
			

		</table>

	</div>
</body>
</html>