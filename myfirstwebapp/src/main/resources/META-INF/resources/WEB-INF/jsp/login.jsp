<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
	<div class="container">
	<h1> Login In </h1>
	<pre> ${error}</pre>
	<form method="post">
	Name: <input type="text" name="name">
	password: <input type="password" name="password">
	<input type="submit">
	</form>
	</div>
</body>
</html>