<?php 

	class dbController{	
		public $conexion;

		
		function __construct($con){
			$this->conexion = $con;
		}

		public function insertPersonas($query){

			//EJECUTA CONSULTA
			$resultado = pg_query($this->conexion,$query);
		}
	}

?>