<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Documento</title>

    <link rel="StyleSheet" href="../css/bootstrap.min.css">

</head>
<body>
    <div class="container mt-5">
        <h4>Editar Documentos</h4>
        <hr>
        <form method="post" onsubmit="submitForm(event)">
        <?php
            if (isset($_GET["id"])){
                $id = $_GET["id"];
                $data = json_decode(file_get_contents("http://localhost:8080/documento/" . $id), true);
            }
        ?>
            <div class="form-row">
                <div class="form-group col-md-3">
                        <label for="inputEmail4">Tipo documento<span class="requerido"> *</span></label>
                        <input type="text" id="documento" class="form-control" required value = "<?php echo $data['tipo']; ?>">
                </div>
                <div class="form-group col-md-6">
                        <label for="inputEmail4">Numero documento<span class="requerido"> *</span></label>
                        <input type="text" id="numero" class="form-control" required value = "<?php echo $data['numero']; ?>">
                </div>
                <br>
                <div>
                    <div>
                        <button class="btn btn-primary" type="submit">Actualizar documento</button>
                        <a href="http://localhost/cliente/cliente/documentos.php?id=<?php echo $_GET['id']?>" class="submit btn btn-dark ml-1"><i class="fa fa-chevron-left regresar" aria-hidden="true"></i>Regresar</a>
                    </div>
                </div>
                <div>
                    <div class="col-md-4">
                        
                    <div>
                </div>
            </div>
        </form>
    </div>
</body>
<script type="text/javascript">
        function submitForm(event){
            const documento = document.getElementById("documento").value;
            const numero = document.getElementById("numero").value;
            event.preventDefault();

            fetch('http://localhost:8080/documento',{
                method: 'POST',
                headers:{
                    'Content-Type' : 'application/json'
                },
                body: JSON.stringify({
                    "nid" : <?php echo $_GET['id']?>,
                    "tipo" : documento,
                    "numero" : numero,
                    "cn_fk" : <?php echo $_GET['user']; ?>
                })
            })
            .then((response) => response.json())
            .then(data => {
                window.location.href = "http://localhost/cliente/cliente/documentos.php?id=" + <?php echo $_GET['user']?>;
            });
        }
    </script>
</html>