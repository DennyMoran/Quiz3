<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrito</title>
</head>
<body>
<h1 class="title"> Carrito <i class="fas fa-shopping-cart"></i></h1>
<#if titulo??>
	<h2>${titulo}</h2>
</#if>
<#list carrito as carrito>
	<div class="contenedor">
		<span>${carrito.nombre}, ${carrito.cantidad}, ${carrito.descripcion}, ${carrito.precio}</span>
	</div>
</#list>
</body>
</html>

