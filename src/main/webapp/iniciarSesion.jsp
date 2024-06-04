<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesion</title>
</head>

<body>
    <div class="login-container">
        <h1>Iniciar sesion</h1>
        <form action="sesion" method="get">
            <input name="id" type="number" placeholder="Identificacion" style="margin-bottom: 10px;">
            <br>
            <input name="contra" type="password" placeholder="Contrasena" style="margin-bottom: 20px;">
            <button type="submit">Iniciar Sesion</button>
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
   .login-container {
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
        margin-bottom: 1em;
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

</html>