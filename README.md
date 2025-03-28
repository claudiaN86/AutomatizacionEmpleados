### `Reto De Automatización De Pruebas orangehrmlive`

#### Descripción

Proyecto de Automatización de la plataforma orangehrmlive con SerenityBDD en Screenplay.

#### Feature: Add products to cart

> **As** administrator
> 
> **I** want manage employee data
> 
> **To** keep employee information up-to-date and organized

#

#### Características del Proyecto

En la construcción del proyecto de automatizacion web en la plataforma orangehrmlive se implementa:

- Patrón de diseño de Screemplay.
- Framework SerenityBDD.
- Gestor de paquetes Gradle.
- Desarrollado en java en su versión 11

#### Versionado

| Repository       | Version  |
|------------------|----------|
| Serenity         | 4.0.15   |
| SerenityCucumber | 4.0.15   |
| Slf4jSimple      | 2.0.7    |
| Junit            | 4.13.2   |

#### Precondiciones

- [x] 1: Instar Java en su versión 11.
- [x] 1.1: Configurar variable de entorno JAVA_HOME
- [x] 2: Instar Gradle en su versión 8.X
- [x] 2.1: Configurar variable de entorno GRADLE_HOME
 

#### Ejecución del proyecto

Para la ejecución del proyecto se debe implementar el siguiente comando en el terminal en el directorio raíz del
proyecto:


- si no tienes gradle o la version 8.x correspondiente ejecuta el siguiente comando:
- 

```sh
./gradlew clean test -Denvironment="stg,chrome"
```

- si tienes gradle instalado y configurado puedes ejecutar el siguiente comando:

```sh
gradle clean test -Denvironment="stg,chrome"
```
- El proyecto se ha probado y configurado en dos navegadores en Chrome y Firefox Si se desea ejecutar uno de los dos en especifico, cambiar el siguiente parametro en el comando de ejecución:
```sh
-Denvironment="stg,chrome"
```
```sh
-Denvironment="stg,firefox"
```