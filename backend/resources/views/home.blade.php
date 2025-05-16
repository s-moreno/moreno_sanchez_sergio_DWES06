<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DWES06</title>
    <link rel="stylesheet" href="{{ asset('css/styles.css') }}">
</head>

<body>
    <div class="container">
        <h1>API CRUD - PRODUCTOS y CATEGORÍAS</h1>
        <h2>DWES06 - Sergio Moreno | smoreno@birt.eus</h2>
        <hr>
        <h3>Descripción:</h3>
        <p>Tarea que desarrollar una arquitectura basada en microservicios, conectando una aplicación principal en
            Laravel (como Gateway) con un microservicio programado en Java (Spring Boot).</p>
        <img src="{{ asset('images/REST.png') }}" alt="diagrama flujo gateway + microservicio" />
        <hr>
        <h3>Endpoints de productos:</h3>
        <div>
            <div class="endpoint">
                <span class="method get">GET</span> /api/products
                <span class="message">Muestra todos los productos</span>
            </div>

            <div class="endpoint">
                <span class="method get">GET</span> /api/products/{id}
                <span class="message">Muestra un producto</span>
            </div>

            <div class="endpoint">
                <span class="method get">GET</span> /api/products/min
                <span class="message">Muestra todos los productos por debajo de su stock mínimo</span>
            </div>

            <div class="endpoint">
                <span class="method post">POST</span> /api/products
                <span class="message">Crea un nuevo producto</span>
            </div>

            <div class="endpoint">
                <span class="method put">PUT</span> /api/products/{id}
                <span class="message">Actualiza un producto</span>
            </div>

            <div class="endpoint">
                <span class="method delete">DELETE</span> /api/products/{id}
                <span class="message">Elimina un producto</span>
            </div>
        </div>

        <h3>Endpoints de categorías:</h3>
        <div>
            <div class="endpoint">
                <span class="method get">GET</span> /api/categories
                <span class="message">Muestra todas las categorías</span>
            </div>

            <div class="endpoint">
                <span class="method get">GET</span> /api/categories/{id}
                <span class="message">Muestra una categoría</span>
            </div>

            <div class="endpoint">
                <span class="method post">POST</span> /api/categories
                <span class="message">Crea una nueva categoría</span>
            </div>

            <div class="endpoint">
                <span class="method put">PUT</span> /api/categories/{id}
                <span class="message">Actualiza una categoría</span>
            </div>

            <div class="endpoint">
                <span class="method delete">DELETE</span> /api/categories/{id}
                <span class="message">Elimina una categoría</span>
            </div>
        </div>

    </div>

</body>

</html>
