# HitoGrupalSyPT1
Este HITO consiste en desarrollar una aplicación Java cliente/servidor donde el servidor pueda atender múltiples peticiones de clientes simultáneos.
La aplicación se desarrollará usando Sockets, hilos y streams (flujos de datos).
El servidor, para atender las peticiones tendrá que consultar un fichero de texto en formato csv con estructura libre. El servidor responderá enviando un objeto.
El cliente se comunica con el servidor para solicitar datos que se encuentran en el fichero de texto.

## La aplicación contará con tres capas:
<ul>
<li>Capa de acceso a datos: donde se realiza la lectura al archivo de texto para ayudar al servidor a atender las solicitudes de los clientes.</li>
<li>Capa servidor: que atenderá solicitudes de los clientes que desean obtener información. Ejemplo: el servidor podría atender la solicitud de un cliente que quiere información sobre libros de java, el servidor recibe dicha solicitud, hace uso de la capa de datos y envía al cliente la información solicitada.</li>
<li>Capa cliente: que se comunica con el servidor enviando una clave de búsqueda. Ejemplo: el cliente envía la palabra Java con el fin de obtener información sobre los libros de Java disponibles en la librería.</li>
</ul>
