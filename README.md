# Proyecto TMC - Inditex .com

Este proyecto es una prueba técnica para la parte de Inditex .com de la empresa TMC.  
En este proyecto, se desarrollan endpoints REST que interactúan con una base de datos en memoria H2 para gestionar precios y tarifas aplicables a productos de Inditex.

---

## 📌 Pruebas de la API

### 🔹 Swagger UI

Una vez que el proyecto esté levantado, puedes probar la API a través de la interfaz gráfica de Swagger UI.

Para acceder a la documentación interactiva y probar los endpoints, abre la siguiente URL en tu navegador:

➡️ **[Swagger UI - API Documentation](http://localhost:8080/swagger-ui/index.html#/price-controller/getPrice)**

En esta interfaz, podrás ver los endpoints disponibles y probarlos directamente sin necesidad de herramientas externas.

---

### 🔹 Base de Datos H2

La base de datos H2 está configurada localmente para pruebas. Puedes acceder a la consola H2 a través de la siguiente URL cuando el servidor esté en funcionamiento:

➡️ **[H2 Console - Base de Datos Local](http://localhost:8080/h2-console/)**

---

## 🔐 Configuración de Usuario y Contraseña de H2

El acceso a la base de datos H2 está protegido por un usuario y contraseña, los cuales están configurados en el archivo `application.properties` del proyecto.

### 📄 **Credenciales por defecto**
- **Usuario**: `sa`
- **Contraseña**: *(vacío)*

Si deseas cambiar estas credenciales o cualquier otra configuración, puedes hacerlo editando las siguientes líneas en el archivo:  
📂 `src/main/resources/application.properties`

```properties
spring.datasource.username=sa
spring.datasource.password=

