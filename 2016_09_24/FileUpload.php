<?php
	$file_path = "uploads/";
	$file_path = $file_path . base_name($_FILES["uploaded_file"]["name"]);
	if(move_uploaded_file($_FILES["uploaded_file"]["temp_name"], $file_path)){
		echo "Success";
	}else{
		echo "Failed";
	}
?>