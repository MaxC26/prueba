<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nuevo cliente</title>

    <link rel="StyleSheet" href="../css/bootstrap.min.css">

</head>
<body>
    <div class="container mt-5">
        <h4>Nuevo cliente</h4>
        <hr>
        <form method="post" onsubmit="submitForm(event)">
        <?php
            if (isset($_GET["id"])){
                $id = $_GET["id"];
                $data = json_decode(file_get_contents("http://localhost:8080/cliente/" . $id), true);
            }
        ?>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="inputEmail4">Nombres<span class="requerido"> *</span></label>
                    <input type="text" id="nombres" class="form-control" required value = "<?php echo $data['nombres']; ?>">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputEmail4">Apellidos<span class="requerido"> *</span></label>
                    <input type="text" id="apellidos" class="form-control" required value = "<?php echo $data['apellidos']; ?>">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputEmail4">Correo<span class="requerido"> *</span></label>
                    <input type="text" id="correo" class="form-control" required value = "<?php echo $data['correo']; ?>">
                </div>
                <div class="contenedor-submit col-md-8">
                    <div class="contenedor-submit">
                        <a href="http://localhost/cliente/" class="submit"><i class="fa fa-chevron-left regresar" aria-hidden="true"></i>CANCELAR</a>
                    <div>
                    <div class="mt-2">
                        <button class="btn btn-primary" type="submit">Actualizar Cliente</button>
                    </div>
            </div>
            </div>
        </form>
    </div>
</body>
    <script type="text/javascript">
        function submitForm(event){
            const nombres = document.getElementById("nombres").value;
            const apellidos = document.getElementById("apellidos").value;
            const correo = document.getElementById("correo").value;
            event.preventDefault();

            fetch('http://localhost:8080/cliente',{
                method: 'POST',
                headers:{
                    'Content-Type' : 'application/json'
                },
                body: JSON.stringify({
                    "id" : <?php echo $_GET["id"]; ?>,
                    "nombres" : nombres,
                    "apellidos" : apellidos,
                    "correo" : correo
                })
            })
            .then(data => {
                window.location.replace("http://localhost/cliente/");
            });
        }
    </script>
</html>