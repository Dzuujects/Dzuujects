<?php

$name=$_POST['name'];
$number=$_POST['number'];
$email=$_POST['email'];
$tiers=$_POST['tiers'];
$noseat=$_POST['noseat'];

$db = new PDO('sqlite:gala.db');

$query = "INSERT INTO gala (name, number, email, tier, noseat) VALUES ('$name', '$number', '$email', '$tiers', '$noseat')";
$statement = $db->prepare($query);

$result = $statement->execute();


if ($result) {
    header("Location: homepage.html");
} else {
    echo 'Error submitting form.';
}

$db = null;
?>