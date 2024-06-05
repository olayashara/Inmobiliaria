<!DOCTYPE html>
<html>
<head>
	<title>Realizar Oferta</title>
	<body>
		<form action="oferta" method="post">
			<div class="container">
			<h1>Realizar Oferta</h1>
			<div class="info">
				<p>Residencia RH1<br>REFERENCIA: RC1</p>
			</div>
			<div>
				<label for="oferta">Oferta:</label>
				<input type="number" id="oferta" name="oferta">
			</div>
			<div class="button">
				<button type="submit">Enviar Oferta</button>
			</div>
		</div>
	</form>
	</body>
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
		
		div + div {
			margin-top: 1em;
		}
		
		label {
			display: block;
			margin-bottom: 0.5em;
		}
		
		input[type="text"], input[type="email"], input[type="password"], input[type="number"] {
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
		.info {
			font-family: 'Poppins', sans-serif;
			font-weight: bold;
		}
		
		/* Nueva clase CSS para el label con id "oferta" */
		label[for="oferta"] {
			font-family: 'Poppins', sans-serif;
			font-weight: normal;
		}
	</style>
</head>
</html>