use cooperativa;
#describe clientes;
insert into clientes (legajo, cuil, socioNro, apellido, nombre, lugar ) values 	
(27088,'23-25361409-9','5692','Aballay','Cristian David','Alcorta'),
(25247,'20-17586539-0','5471','Abbattista','Alejandro Antonio','Alcorta'),
(24099,'20-17739262-7','5043','Aimbreger Molina','Marcelo Felipe','San_Justo'),
(23706,'20-17367826-7','5325','Alfonso','Mario Roberto','San_Justo'),
(1492268,'20-33576690-4','6422','Zabala','Nicolas','Monte_Grande'),
(1459751,'20-28929943-3','6640','Zwolinski','Federico Gaston','Monte_Grande');
select * from clientes;

#describe cuentas;
insert into cuentas (idCliente, saldo, activa) values
(1,0,false),
(2,1800.00,true),
(3,1750.00,true),
(4,5000.00,true),
(5,631.92,true),
(6,1550.00,true);
select * from cuentas;

#describe movimientos;
insert into movimientos (idCuenta, tipo, monto, fecha) values
(1,'Aporte',100,'2019-03-03'),
(2,'Aporte',100,'2019-04-04'),
(3,'Aporte',250,'2019-03-05'),
(4,'Aporte',1000,'2019-04-08'),
(5,'Reintegro',18000,'2019-04-08'),
(6,'Aporte',50,'2019-04-23');
select * from movimientos;

#describe prestamos;
insert into prestamos (id, idCuenta, montoTotal, cuotaTotal, cancelado, tasa, fecha) values 
(9983,2,6000, 3,true,0,'2019-03-03'),
(9639,4,5000, 6,false,1.5,'2019-02-02'),
(9159,6,10000, 3, false,1.24,'2019-05-02');
select * from prestamos;

#describe cuotas;
insert into cuotas (idPrestamo, cuotaNro, valor, pagado, fecha) values 
(9639,1,1083.33, true,'2019-02-09'),
(9639,2,1083.33, true,'2019-03-03'),
(9639,3,1083.33, true,'2019-04-08'),
(9639,4,1083.33, true,'2019-05-06'),
(9639,5,1083.33, false,'2019-05-06'),
(9639,6,1083.33, false,'2019-05-06'),
(9983,1,2000, true,'2019-03-03'),
(9983,2,2000, true,'2019-04-02'),
(9983,3,2000, true,'2019-05-03'),
(9159,1,4133.33, true,'2019-06-02'),
(9159,2,4133.33, false,'2019-07-01'),
(9159,3,4133.33, false,'2019-08-01');
select * from cuotas;

#########################################
#listado de clientes con cuentas inactivas
select clientes.*, cuentas.* from clientes
inner join cuentas
on cuentas.idCliente=clientes.id
where cuentas.activa=false;

#listado de cliente con prestamos sin cancelar
select clientes.*, prestamos.* from prestamos
inner join cuentas
on cuentas.id=prestamos.idCuenta
inner join clientes
on clientes.id=cuentas.idCliente
where prestamos.cancelado=false;


#listado de cuotas no pagas por legajo con prestamo activo
select clientes.*, cuotas.* from cuotas
inner join prestamos
on prestamos.id=cuotas.idPrestamo
inner join cuentas
on cuentas.id=prestamos.idCuenta
inner join clientes
on clientes.id=cuentas.idCliente
where clientes.legajo=23706
and cuotas.pagado=false;

#total de saldo de todas las cuentas
select sum(cuentas.saldo) from cuentas
inner join clientes 
on clientes.id=cuentas.idCliente;

#saldo de cada cliente con cuenta activa
select clientes.legajo, clientes.apellido, clientes.nombre, cuentas.saldo from cuentas
inner join clientes 
on clientes.id=cuentas.idCliente
where cuentas.activa=true;

#portes de los ultimos 3 meses 
select clientes.legajo, clientes.apellido, clientes.nombre, movimientos.tipo, movimientos.monto, movimientos.fecha from movimientos
inner join cuentas 
on cuentas.id=movimientos.idCuenta
inner join clientes 
on clientes.id=cuentas.idCliente
where movimientos.tipo like 'aporte'
and movimientos.fecha between '2019-03-07'and now();

#listado cantidad cuotas pagadas por cliente con prestamo
select clientes.legajo, clientes.apellido, clientes.nombre, count(*) from cuotas
inner join prestamos
on prestamos.id= cuotas.idPrestamo
inner join cuentas
on cuentas.id=prestamos.idCuenta
inner join clientes
on clientes.id=cuentas.idCliente
where cuotas.pagado=true
group by legajo;