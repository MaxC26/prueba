<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="StyleSheet" href="css/bootstrap.min.css">

    <title>Inicio</title>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Clientes</h1>
        <a href="cliente/nuevo-cliente.php"class="btn btn-primary mt-3 mb-2">Ingresar un nuevo cliente</a>
        <?php 
            $data = json_decode(file_get_contents("http://localhost:8080/cliente"), true);
            if(count($data) > 0){
                echo "<table class='table mt-4'>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Correo</th>
                            <th>Direcciones</th>
                            <th>Documentos</th>
                            <th>Editar</th>
                            <th>Eliminar</th>
                        </tr>
                    <thead>
                    <tbody>";
                
                    for($i = 0; $i < count($data); $i++){
                        echo "<tr><td>" . $data[$i]["nombres"] . "</td>";
                        echo "<td>" . $data[$i]["apellidos"] . "</td>";
                        echo "<td>" . $data[$i]["correo"] . "</td>";
                        echo "<td><a href='http://localhost/cliente/cliente/direcciones.php?id=". $data[$i]['id'] ."'>Direcciones</a></td>";
                        echo "<td><a href='http://localhost/cliente/cliente/documentos.php?id=". $data[$i]['id'] ."'>Documentos</a></td>";
                        echo "<td><a href='http://localhost/cliente/cliente/editar-cliente.php?id=". $data[$i]['id'] ."'>Editar</td>";
                        echo "<td><a href='http://localhost/cliente/cliente/eliminar-cliente.php?id=". $data[$i]["id"] ."'>Eliminar</td></tr>";
                    }
                echo "</tbody>
                   </table>";
            }
            else{
                echo "
                    <div class='alert alert-warning mt-2' role='alert'>
                        No se encontraron clientes.
                    </div>";
            }
        ?>
    </div>
</body>
</html>