# Proyecto Inmobiliaria Spring Boot + Java 11 + mySQL

La empresa inmobiliaria ABDC está implementando un sistema que le permita administrar sus propiedades, esta empresa ofrece servicios de venta y de alquiler de inmobiliaria residencial. Para lo cual se planten las siguientes condiciones.

##### 1. Existe una entidad que se llama propiedad, la cual tiene las siguientes características.

- Código int
- Color char
- Area double
- Piso int
- Precio por metro double
- Tipo int (puede ser de uno de los tipos disponibles, venta o alquiler)
- Clave catastral double
- Precio alquiler double
- Entidad Tipo:
- codigoTipo int
- descripcion string (venta, alquiler)

##### 2.  Existe la entidad claves Catastrales, las cuales tienen las siguientes características:
- claveCatastral int
- fechaInscripcion date
- departamento string
- La entidad dueños:
- codigoDuenio int
- nombre string
- apellido string
- teléfono string
- correo dirección

##### 2. La entidad cuotas (es para saber que cuotas pendientes tiene que pagar cada cliente)
- codigoCuota int
- codigoApartamento int
- fecha vencimiento date
- estatus char (‘A=pagada’ , ‘P = Pendiente’)
- monto double


### Las entidades anteriores se relacionan de la siguiente manera:
- Un inmueble deberá tener un tipo y un tipo podrá tener muchos inmuebles (relación uno a muchos)
- Cada inmueble deberá tener únicamente una clave y una clave catastrales solo podrá tener un inmueble (relación de uno a uno)
- Un inmbueble podrá pertenecer a más de un dueño y muchos dueños podrán tener muchos inmuebles (relación muchos a muchos)
- La entidad cuotas tendrá una relación en la que cada apartamento puede tener muchas cuotas y muchas  cuotas pueden pertenecer a un apartamento (relación de uno a muchos).



### Con base en lo anterior se creo una API Rest que tiene los siguientes métodos
1. Crear inmueble – creará un inmueble, cuando se cree el inmueble deberá crear doce registros en la tabla cuotas lo cual representa una cuota por cada mes, la fecha de vencimiento de cada cuota será el 20 de cada mes, el monto de la cuota será igual a 1.5 por cada metro del área

2. Obtener inmuebles por tipo – enviará un parámetro el cual devolverá todos los inmuebles segúnel tipo venta o alquiler.

3. Buscar inmueble por id

4. Eliminar inmueble por id

5. Actualizar inmueble – solo deberán poder cambiarse el codigo del dueño, precio por metro

6. Crear dueño – permite crear un nuevo dueño

7. Eliminar dueño

8. Obtener dueño por id

9. Obtener inmuebles por dueño – Obtendrá todos los inmuebles de un dueño en particular.

10. Obtener apartamentos con cuotas vencida