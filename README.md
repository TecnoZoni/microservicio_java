# Microservicio de Gestión de Turnos

## Descripción

API para gestión de turnos médicos que se integra con el servicio de pacientes para obtener información de los mismos. Utiliza una base de datos H2 en memoria, por lo que no requiere configuración adicional.

## Documentación API

📚 [Documentación Swagger - Turnos](http://localhost:9002/swagger-ui.html)  
📚 [Documentación Swagger - Pacientes](http://localhost:9001/swagger-ui.html)

## Características clave

- **Base de datos H2 en memoria**: No requiere instalación ni configuración externa
- **Acceso a consola H2**: Disponible en `http://localhost:9002/h2-console` (JDBC URL: `jdbc:h2:mem:servicio_turnos`)
- **Integración automática** con servicio de pacientes
> **Nota**: Todos los datos se pierden al reiniciar la aplicación debido al uso de H2 en memoria. Para persistencia de datos, configurar una base de datos externa.

## Integración entre servicios

El servicio de Turnos consume los siguientes endpoints del servicio de Pacientes:

- `GET /pacientes/traerdni/{dni}` - Para obtener datos del paciente al crear/actualizar turnos

## Ejemplo de Uso

1. Verificar que el paciente exista en el servicio de Pacientes
2. Crear turno enviando el DNI del paciente:

```bash
POST /turnos/crear
{
  "fecha": "2023-12-15",
  "tratamiento": "Consulta general",
  "dniPaciente": "12345678"
}
```

## Requisitos

- Servicio de Pacientes corriendo en `http://localhost:9001`
- Servicio de Turnos corriendo en `http://localhost:9002`
- Java 17+
- Maven
