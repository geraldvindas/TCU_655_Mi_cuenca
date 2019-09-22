# TCU_655_Mi_cuenca

Este archivo ha sido confeccionado con el objetivo de que los próximos estudiantes que trabajen en esta aplicación tengan una mejor noción del funcionamiento de la misma, su código, así como algunas ideas que se pueden tomar en cuenta para implementarlas en la aplicación en algún futuro.

## Aplicación
El app Mi_Cuenca fue pensada con el objetivo de ser un repositorio de datos útil y accesible para  para los habitantes de la subcuenca del río Coto
a partir del diagnóstico y plan de manejo. Sin embargo se espera que esta app crezca con información de otras cuencas del territorio nacional.
Mi_cuenca fue desarrollada utilizando el IDE Android Studio. A continuación se enumeran aspectos importantes de la app:


* Pantalla de menú:
Esta es la pantalla principal de la aplicación. La misma consta con botones que llevan a las respectivas pantallas de los demás menús así como a las secciones de los enlaces de interés y soporte. Todas las demás pantallas del app tienen un botón que nos lleva de vuelta al menú principal.

* Menú ASADAs:
Este despliega una lista que nos permite acceder a información de cada una las diferentes ASADAs vinculadas a la subcuenca.

* Menú Conceptos:
Este menú nos permite ver información sobre conceptos importantes para entender mejor el diagnóstico y el plan de manejo de la subcuenca del río Coto.

* Menú Leyes:
Tiene un listado de leyes relacionadas con el agua, su cuidado y usos, junto con los respectivos artículos vinculados a esta materia. 

* Menú Datos curiosos:
Datos curiosos que se muestran de forma aleatoria al presionar un botón.

* Menú Zonificación:
Muestra información acerca de los diferentes tipos de zona que se encuentran en la subcuenca así como sus usos.

* Menú Mapa:
Este muestra el mapa de la subcuenca y distintas capas con información acerca de la misma.

* Enlaces de interés:
Página con distintos enlaces hacia páginas de interes como las redes sociales de este proyecto, entre otros.

## Código fuente
El código se encuentra organizado de la siguiente manera:

En la ruta:
```bash
    /TCU_655_Mi_cuenca/app/src/main/java/com/ucr/micuenca
```
se encuentran los archivos .java que conforman la funcionalidad de las diferentes pantallas de la aplicación. 

Además también se encuentra la carpeta **BaseDeDatos**
```bash
    /TCU_655_Mi_cuenca/app/src/main/java/com/ucr/micuenca/BaseDeDatos
```
están las clases que se encargan de hacer el mapeo con la base de datos en la que se encuentra toda la información mostrada en la aplicación.
El link a los datos es el siguiente:
```
	https://docs.google.com/spreadsheets/d/1XedMQT5t5i0xiBPOLt7NdX1-xzxp_3Q3QRYH_0SyEOU/edit?usp=sharing
```

El directorio de las vistas(activities) las pantallas es el siguiente:
```
	/TCU_655_Mi_cuenca/app/src/main/res/layout
```

Y las imágenes utilizadas en la aplicación:
```
	/TCU_655_Mi_cuenca/app/src/main/res/drawable
```
## Sugerencias a futuro
Durante el desarrollo de esta aplicación se hicieron diversas encuestas en las diferentes comunidades de la subcuenca para conocer a detalle lo que las personas sienten que hace falta dentro de la apliacación, destacando lo siguiente:

* Mayor interacción con el mapa, poder hacer más acciones, ver información de zonas, comunidades y demás a partir del mismo.

* Un juego relacionado con la temática de la aplicación, dirigido a niños, en el cual estos puedan aprender más sobre la cuenca y la labor de este TCU.

