drop database if exists cooperativa;
create database cooperativa;
use cooperativa;

create table clientes (
    id int primary key auto_increment,
    legajo int not null unique,
    cuil varchar(25) not null,
    socioNro varchar(25) not null,
    apellido varchar(25) not null,
    nombre varchar(25) not null,
    lugar  enum('Alcorta','Administracion','Monte_Grande','Monte_Grande_Dreyer'
,'San_Justo','Pilar','Mega','Parral','CIM','Barracas','Coca_Cola_Argentina'
,'Confidenciales','Loma_Hermosa','Servet','Roca') not null,
    cbu varchar(25),
    email varchar(25),
    telefono varchar(25)
);

create table cuentas(
	id int primary key auto_increment,
    idCliente int,
    saldo double not null,
    activa boolean not null
);
alter table cuentas
	add constraint fk_cuentasClientes
	foreign key(idCliente)
    references clientes(id)
    on delete cascade;

create table movimientos(
    id int primary key auto_increment,
    idCuenta int not null,
    tipo enum('Aporte','Reintegro','Diferencial') not null,
    monto double not null,
    fecha date not null
);
alter table movimientos
	add constraint fk_movimientosCuentas
	foreign key(idcuenta)
    references cuentas(id)
    on delete cascade;

create table prestamos(
    id int primary key,
    idCuenta int not null,
    montoTotal double not null,
    cuotaTotal int not null,
    cancelado boolean not null,
    tasa double not null,
    fecha date not null
);
alter table prestamos
	add constraint fk_prestamosCuentas
	foreign key(idCuenta)
    references cuentas(id)
    on delete cascade;

create table cuotas(
    id int primary key auto_increment,
    idPrestamo int not null,
    cuotaNro int not null,
    valor double not null,
    pagado boolean not null,
    fecha date not null
);
alter table cuotas
	add constraint fk_cuotasPrestamos
	foreign key(idPrestamo)
    references prestamos(id)
    on delete cascade;
