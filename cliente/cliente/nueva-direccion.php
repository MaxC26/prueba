<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nueva direccion</title>

    <link rel="StyleSheet" href="../css/bootstrap.min.css">

</head>
<body>
    <div class="container mt-5">
        <h4>Agregar direcciones</h4>
        <hr>
        <form method="post" onsubmit="submitForm(event)">
            <div class="form-row">
                <div class="form-group col-md-12">
                    <div class="col-md-5">
                        <label for="inputEmail4">Direccion<span class="requerido"> *</span></label>
                        <input type="text" id="direccion" class="form-control" required>
                    <div>
                </div>
                <br>
                <div>
                    <div>
                        <button class="btn btn-primary" type="submit">Guardar cliente nuevo</button>
                        <a href="http://localhost/cliente/cliente/direcciones.php?id=<?php echo $_GET['id']?>" class="submit btn btn-dark ml-1"><i class="fa fa-chevron-left regresar" aria-hidden="true"></i>Regresar</a>
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
            const direccion = document.getElementById("direccion").value;
            event.preventDefault();

            fetch('http://localhost:8080/direccion',{
                method: 'POST',
                headers:{
                    'Content-Type' : 'application/json'
                },
                body: JSON.stringify({
                    "direccion" : direccion,
                    "cd_fk" : <?php echo $_GET['id']; ?>
                })
            })
            .then((response) => response.json())
            .then(data => {
                window.location.href = window.location.href;
            });
        }
    </script>
</html>