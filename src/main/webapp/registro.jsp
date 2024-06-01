<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
	<title>Registro de usuario</title>
	<style>
        body {
			margin: 0;
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
		}
		.container {
			width: 400px;
			margin: 40px auto;
			text-align: center;
		}
		form {
			margin: 0 auto;
			padding: 1em;
			border: 1px solid #ccc;
			border-radius: 1em;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		}
		
		div + div {
			margin-top: 1em;
		}
		
		label {
			display: block;
			margin-bottom: 0.5em;
		}
		
		input[type="text"], input[type="email"], input[type="password"] {
			width: 100%;
			padding: 0.5em 1em;
			border: 1px solid #ccc;
			border-radius: 0.5em;
			box-sizing: border-box; /* Agregué esto */
		}
		
		.button {
			margin-top: 2em;
		}
		
		button[type="submit"] {
			background-color: #F28123;
			color: #fff;
			padding: 0.5em 1em;
			border: none;
			border-radius: 0.5em;
			cursor: pointer;
		}
		
		button[type="submit"]:hover {
			background-color: #F28123;
		}
        h1 {
			color: #F28123;
			font-family: 'Poppins', sans-serif;
			margin-bottom: 20px;
		}
	</style>
</head>
<body>
    <div class="container">
        <h1>Crea tu Cuenta</h1>
        <form action="registro" method="post">
            <div>
                <input type="text" name="nombre" placeholder="Aqui Nombre">
            </div>
            <div>
                <input type="text" name="apellido" placeholder="Aqui Apellido">
            </div>
            <div>
                <input type="number" name="identificacion" placeholder="Aqui Identificacion">
            </div>
            <div class="button">
                <button type="submit">Registrarse</button>
            </div>
        </form>
    </div>
</body>
</html>