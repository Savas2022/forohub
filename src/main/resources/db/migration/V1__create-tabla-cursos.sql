create table cursos(

    id bigint not null auto_increment,
    nombre varchar(100) not null unique,
    categoria varchar(100) not null,
    activo tinyint not null default 1,

    primary key(id)
);