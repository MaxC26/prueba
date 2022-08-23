<?php
    require 'conexion.php';
    require 'vendor/autoload.php';

    use PhpOffice\PhpSpreadsheet\Spreadsheet;
    use PhpOffice\PhpSpreadsheet\IOFactory;
    try{
        $comando = "SELECT * FROM cliente";
        $result = $mysqli->query($comando);
        $estatus = $result;
    }catch(Exception $e){
        $estatus = "false";
    }

    $exel = new Spreadsheet();
    $hojaActiva = $exel->getActiveSheet();
    $hojaActiva->setTitle("Clientes");

    $hojaActiva->setCellValue('A1', 'ID');

    $fila = 2;
    while($rows = $result->fetc_assoc()){
        $hojaActiva->setCellValue('A' .$fila, $rows['id']);
        $fila++;
    }

    header('Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');
    header('Content-Disposition: attachment;filename="Clientes.xlsx"');
    header('Cache-Control: max-age=0');

    $writer = IOFactory::createWriter($exel, 'Xlsx');
    $writer->save('php://output');
    exit;