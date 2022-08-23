<script>
    fetch('http://localhost:8080/documento/<?php echo $_GET["id"]; ?>', {
        method : 'DELETE'
    })
    .then(data => {
        window.location.href = "http://localhost/cliente/cliente/documentos.php?id=" + <?php echo $_GET['user']?>;
    });
</script>