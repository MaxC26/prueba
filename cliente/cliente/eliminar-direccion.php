<script>
    fetch('http://localhost:8080/direccion/<?php echo $_GET["id"]; ?>', {
        method : 'DELETE'
    })
    .then(data => {
        window.location.href = "http://localhost/cliente/cliente/direcciones.php?id=" + <?php echo $_GET['user']?>;
    });
</script>