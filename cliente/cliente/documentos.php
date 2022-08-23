<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="StyleSheet" href="../css/bootstrap.min.css">

    <title>Documentos</title>
</head>
<?php
    $id = $_GET["id"];
?>
<body>
    <div class="container">
        <h1 class="mt-5">Documentos</h1>
        <a href="http://localhost/cliente/cliente/nuevo-documento.php?id=<?php echo $id; ?>"class="btn btn-primary mt-3 mb-2">Ingresar un nuevo documento</a>
        <a href="http://localhost/cliente/" class="btn btn-dark mt-3 mb-2">Regresar</a>
        <?php 
            $data = json_decode(file_get_contents("http://localhost:8080/documento/user/$id"), true);
            if(count($data) > 0){
                echo "
                <table class='table mt-4'>
                    <thead>
                        <tr>
                            <th>N.</th>
                            <th>Tipo documento</th>
                            <th>Numero documento</th>
                            <th>Editar</th>
                            <th>Eliminar</th>
                        </tr>
                    <thead>
                    <tbody>
                ";    
                for($i = 0; $i < count($data); $i++){
                    echo "<tr><td>" . $i+1 . "</td>";
                    echo "<td>" . $data[$i]["tipo"] . "</td>";
                    echo "<td>" . $data[$i]["numero"] . "</td>";
                    echo "<td><a href='http://localhost/cliente/cliente/editar-documento.php?id=". $data[$i]['nid'] ."&user=". $id ."'>Editar</td>";
                    echo "<td><a href='http://localhost/cliente/cliente/eliminar-documento.php?id=". $data[$i]["nid"] ."&user=". $id ."'>Eliminar</td></tr>";
                }
                echo "
                    </tbody>
                </table>
                ";
            }
            else{
                echo "
                    <div class='alert alert-warning mt-2' role='alert'>
                        No tienes documentos asignadas.
                    </div>";
            }
        ?>
    </div>
</body>
</html>