<!DOCTYPE html>
<html>
<head>
	<title>Pago Virtual</title>
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
			box-sizing: border-box;
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
        <h1>Realiza tu Pago</h1>
        <form action="compra" method="post">
            <div>
                <input type="text" name="nombre" placeholder="Nombre">
            </div>
            <div>
                <input type="text" name="apellido" placeholder="Apellido">
            </div>
			<div>
                <input type="password" name="contrasena" placeholder="Contrasena">
            </div>
            <div>
                <input type="text" name="referencia" placeholder="RH1">
            </div>
            <div>
                <input type="number" name="identificacion" placeholder="Identificacion">
            </div>
            
            <div class="button">
                <button type="submit">Pagar</button>
            </div>
        </form>
    </div>
</body>
</html>