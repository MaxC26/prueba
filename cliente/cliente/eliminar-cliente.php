<script>
    fetch('http://localhost:8080/cliente/<?php echo $_GET["id"]; ?>', {
        method : 'DELETE'
    })
    .then(data => {
        window.location.replace("http://localhost/cliente/");
    });
</script>