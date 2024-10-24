<?php
    $con ="";
    try{
        $file_db = new PDO('sqlite:Gala.db');
        $file_db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    }catch(PDOException $e){
        echo "Connection Fail: "
         .$e->getMessage();
    }
?>