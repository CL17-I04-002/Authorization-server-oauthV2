# Resource Server

Este es un proyecto desarrollado por ing. Daniel Larín el cual consiste en un authorization server para proteger
al resource server, este proyecto opera con OAuth2

## Descripción

Este proyecto que se integra con aplicaciones clientes y así el server le brinde un authorization code
al cliente para posterior intercambiarlo por un JWT

## Instalación

A continuación se detalla cómo instalar y configurar el proyecto.

### Prerrequisitos

- Java 17
- Maven
- Git

### Pasos de instalación

1. Clona el repositorio: https://github.com/CL17-I04-002/Authorization-server-oauthV2.git
2. Realice un Reload project para que se descarguen todas las dependencias
3. Compile la solución y listo

### NOTA
Para ejecutar correctamente este proyecto usando OAuth2 recuerde usar una app cliente, para fines practicos puede
configurar los parámetros necesarios en el siguiente sitio: https://oauthdebugger.com puede configurar como Authorize URI:
http://localhost:9595/authorization-server/oauth2/authorize una vez tenga el
authorization code debe apuntar el siguiente endpoint: http://localhost:9595/authorization-server/oauth2/token con las siguientes configuraciones:

Cuando envie la petición POST configure en Authorization su client_id y secret, en el body deje
x-www-form-urlencoded y los siguientes parametros:

grant_type: authorization_code
client_id: su client id
redirect_uri: https://oauthdebugger.com/debug
code: su authorization code

Y como campo opcional si se hace una autenticación usando PKCE, agregue el siguiente parámetro:

code_verifier: su code verifier