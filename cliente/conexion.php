<?php
    function conectarBD(){
        $host = "localhost";
        $port= "3306";
        $dbname = "pruebatecnica";
        $user = "root";
        $password=""; 

        try {
            $bd = new PDO("pgsql:host=$host;port=$port;dbname=$dbname", $user, $password);
            $bd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            return $bd;
        }catch (Exception $e) {
            echo "Ocurrió un error con la base de datos: " . $e->getMessage();
        }
    }
?>