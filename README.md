## Resolución de challenge backend para RedLink.

### Instrucciones para levantar el proyecto

Se desarrolló en Java con Springboot y poseé todas las dependencias para el funcionamiento local del mismo.

Se debe ejecutar la clase "ChallengeRedlinkApplication" e importar el archivo JSON en Postman.

### Explicación de las consultas HTTP de JSON:

- **usuario no empleado:** se ingresa con un usuario logeado en el sistema pero que no es de tipo empleado, por lo cual, no posee acceso a prestamos.
- **usuario empleado sin prestamos disponibles:** se ingresa con un usuario de tipo empleado pero que no posee prestamos disponibles.
- **usuario empleado con prestamos disponibles:** se ingresa con un usuario empleado que posee prestamos disponibles.
- **usuario no registrado:** se ingresa el dni de un usuario que no se encuentra registrado en el sistema.
- **lista de prestamos del dia:** endpoint que devuelve un JSON con los datos de los empleados que visualizaron los prestamos en el día de hoy.
- El resto de las consultas se utilizan para visualizar los prestamos con otros empleados y, posteriormente, poder visualizar los datos de los mismos en la consulta anterior: **lista de prestamos del dia**.

### Import para Postman:

```json
{
  "info": {
    "_postman_id": "4adf6b26-850c-4430-8bcf-750830074c49",
    "name": "RedLink Challenge",
    "schema": "https://schema.getpostman.com/json/collection/v2.0.0/collection.json",
    "_exporter_id": "41338799"
  },
  "item": [
    {
      "name": "usuario no empleado",
      "protocolProfileBehavior": {
        "disableBodyPruning": true
      },
      "request": {
        "auth": {
          "type": "noauth"
        },
        "method": "GET",
        "header": [],
        "body": {
          "mode": "raw",
          "raw": "",
          "options": {
            "raw": {
              "language": "json"
            }
          }
        },
        "url": "http://localhost:8080/prestamo/11111111"
      },
      "response": []
    },
    {
      "name": "usuario empleado sin prestamos disponibles",
      "request": {
        "auth": {
          "type": "noauth"
        },
        "method": "GET",
        "header": [],
        "url": "http://localhost:8080/prestamo/22222222"
      },
      "response": []
    },
    {
      "name": "usuario empleado con prestamos disponibles",
      "request": {
        "auth": {
          "type": "noauth"
        },
        "method": "GET",
        "header": [],
        "url": "http://localhost:8080/prestamo/33333333"
      },
      "response": []
    },
    {
      "name": "usuario no registrado",
      "request": {
        "auth": {
          "type": "noauth"
        },
        "method": "GET",
        "header": [],
        "url": "http://localhost:8080/prestamo/44444444"
      },
      "response": []
    },
    {
      "name": "lista de prestamos del dia",
      "request": {
        "auth": {
          "type": "noauth"
        },
        "method": "GET",
        "header": [],
        "url": "http://localhost:8080/prestamos/visualizados"
      },
      "response": []
    },
    {
      "name": "usuario empleado con prestamo disponible2",
      "request": {
        "auth": {
          "type": "noauth"
        },
        "method": "GET",
        "header": [],
        "url": "http://localhost:8080/prestamo/55555555"
      },
      "response": []
    },
    {
      "name": "usuario empleado con prestamo disponible3",
      "request": {
        "auth": {
          "type": "noauth"
        },
        "method": "GET",
        "header": [],
        "url": "http://localhost:8080/prestamo/66666666"
      },
      "response": []
    },
    {
      "name": "usuario empleado con prestamo disponible4",
      "request": {
        "auth": {
          "type": "noauth"
        },
        "method": "GET",
        "header": [],
        "url": "http://localhost:8080/prestamo/77777777"
      },
      "response": []
    },
    {
      "name": "usuario empleado con prestamo disponible5",
      "request": {
        "auth": {
          "type": "noauth"
        },
        "method": "GET",
        "header": [],
        "url": "http://localhost:8080/prestamo/88888888"
      },
      "response": []
    }
  ]
}
```
