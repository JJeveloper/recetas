## Spring Boot, API Rest, MySQL, @ManytoMany

API REST para recetas de comida

![recetasbd](https://github.com/JJeveloper/recetas/assets/106100540/17a09c05-f1d3-4be7-a03b-a40cf9543df2)


### Cambiar el usuario y contraseña
+  Ubicacion `src/main/resources/application.properties`
+  cambiar `spring.datasource.username` y `spring.datasource.password`

La aplicacion se ejecuta en:

Metodos @GetMapping
- http://localhost:8080/receta/find-all
- http://localhost:8080/receta/findreceta/{id}
- http://localhost:8080/ingrediente/find-all
- http://localhost:8080/ingrediente/findingrediente/{id}

Metodos @PostMapping
- http://localhost:8080/receta/create
  
```json
{
  "nombrereceta": "seco de pollo",
  "preparacion": "hacer refrito...",
  "ingredientesEntities":
  [
      {
        "id":1
      },
      {
        "id":2
      },
      {
        "id":3
      }
  ]
}
```

- http://localhost:8080/ingrediente/create
  
```json
{
        
  "nombreingrediente": ",,,,"

}
```

Metodos @PutMapping
- http://localhost:8080/receta/update/{id}
- http://localhost:8080/ingrediente/update/{id}

Metodos @DeleteMapping
- http://localhost:8080/receta/delete/{id}
- http://localhost:8080/ingrediente/delete/{id}
