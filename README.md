# Automatización www.travelocity.com - prueba_tyba

### Descripción y contexto

Este repositorio contiene la automatización del escenario de búsqueda de vuelos para la página www.travelocity.com
+ Acceso a www.travelocity.com por medio del google Chrome
+ Búsqueda de vuelo ida y vuelta con datos  de origen y destino
---
### Herramientas para la automatización
+ Java version 1.8.0_271
+ Chromedriver versión 100.0.4896.60
+ IntelliJ IDEA Community Edition versión 2020.3.1
+ Sistema Operativo Windows 10
+ Git versión 2.35.1

---
## Framework

### Serenity BDD
Se utiliza como framework para la automatización de escenarios de prueba, se construyen pruebas que verifiquen si el comportamiento de la aplicación es acorde a necesidades del negocio, partiendo de historias de usuario que tengan el siguiente modelo “Como [rol ] quiero [ característica ] para [los beneficios]”

---
## Gherkin 
Se utiliza Gherkin como lenguaje de desarrollo de las funcionalidades dado que es un lenguaje simple que permite ser comprendido por humanos y por ordenadores, con este vamos a definir los comportamientos de la página que vamos a automatizar. Utilizar Gherkin nos va a permitir crear una documentación mas clara y entendible a la hora de automatizar nuestros tests de cara al negocio.

Gherkin es un lenguaje fácil de leer, entender y escribir. 
Para hacer uso de Gherkin es necesario conocer 5 palabras (Feature, Scenario, Given, When, Then)

- Feature: Indica el nombre de la funcionalidad que se probará. Debe ser un título claro. Se incluye aquí una descripción en forma de historia de usuario: “Como [rol] quiero [característica] para que [los beneficios]”. Sobre esta descripción ese empiezan a construir los escenarios de prueba.

- Scenario: Describe cada escenario que vamos a probar.
-	Given: Indica los prerequisitos que necesitamos para ejecutar la prueba.
-	When: Especifica el conjunto de acciones accionan las funcionalidades que deseamos testear.
-	Then: Especifica el resultado esperado en el test.

---
## Cucumber
Se utiliza cucumber el cual nos permite ejecutar descripciones funcionales en texto plano como pruebas de software automatizadas. Totalmente compatible con el lenguaje Gherkin.

---
## Patrón de diseño: Screenplay

Screenplay trata acerca de escribir nuestras pruebas automatizadas basado en los principios de ingeniería de software tal como son el principio de responsabilidad única (SRP) y en el principio de abierto/cerrado (Open-Closed).

Screenplay promueve los bueno hábitos de testing y suites de pruebas bien organizadas las cuales son fáciles de seguir, fácil de mantener y fácil de extender; habilitando a los equipos a escribir pruebas automatizadas robustas y entendibles. Todo buen patrónn debe tener buenos hábitos de pruebas, pero en realidad, debemos poner atención en la implementación correcta.

### Capas principales 

#### Features
En esta capa se escriben los archivos .feature, estos describen las características y escenarios a probar haciendo uso del lenguaje Gherkin, además se pueden entender como las historias de usuario a desarrollar.

#### Runners
Contiene los archivos runner encargados de ejecutar los escenarios de los feature. Se usan las anotaciones @RunWhit() @CucumberOptions() para especificar qué ejecutar y cómo hacerlo.

#### Step Definitions
Gestiona los fragmentos de código definidos en el Given, Then, When de los escenarios de los archivos .feature. Los fragmentos de código son conocidos como Code Snippets los cuales son métodos que mapean las instrucciones de los escenarios.

#### Tasks
Esta clase contiene las clases que son el corazón del patrón de screenplay=Las tareas. Las tareas son acciones de alto nivel que definen un conjunto de interacciones en el lenguaje de negocio.

#### Interactions
Se encargan de las interacciones con la interfaz de usuario. Muchas interacciones ya fueron desarrolladas y se encuentran disponibles gracias a las librerías de screenplay y de serenity BDD. Ejemplo: Open, Click, Enter, Hit, SelectFromOptions.

#### Questions
Esta capa gestiona los Asserts o verificaciones de las pruebas las cuales son el fin último de las mismas, ya que con estas capturamos la información de la interfaz que puede ser usada. Text,Value, Visibility.

#### User interfaces
Almacena las clases en las cuales se mapean los elementos de la interfaz de usuario, inputs o botones.
NOTA: Únicamente se mapean los elementos, las interacciones con los mismos se llevan a cabo por las interacciones en la capa de interactions.

### Capas transversales

#### Models
Los objetos de negocio son una abstracción de un ente real o virtual, modelado mediante atributos y métodos.

#### Utils
Contiene clases con los métodos unitarios que pueden ser utilizados libremente por otras clases del proyecto como: Conversores, Waits, verificadores, formateo de fechas, etc.

#### Exceptions
Esta es una capa muy importante que tiene como objetivo dar manejo a los errores que pueden presentarse en la aplicación. Es una capa sensible al negocio y particular a cada proyecto.
