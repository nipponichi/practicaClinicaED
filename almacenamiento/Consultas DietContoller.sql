CREATE DATABASE IF NOT EXISTS bd_dietcontroller DEFAULT CHAR SET utf8mb4;
use bd_dietcontroller;

CREATE TABLE IF NOT EXISTS personal(
codigo INTEGER NOT NULL,
nombre VARCHAR (255) NOT NULL,
apellidos VARCHAR (255) NOT NULL,
dni VARCHAR (10) NOT NULL,
localidad VARCHAR (255),
telefono VARCHAR (255) NOT NULL,
especialidad VARCHAR (255) NOT NULL,
PRIMARY KEY (codigo));

CREATE TABLE IF NOT EXISTS paciente (
nombre VARCHAR (255) NOT NULL,
edad INTEGER NOT NULL,
calle VARCHAR (255),
localidad VARCHAR (255),
codpostal VARCHAR (10),
dni VARCHAR (10) NOT NULL,
sexo VARCHAR (10) NOT NULL,
peso double NOT NULL,
altura double NOT NULL,
PRIMARY KEY (dni));

CREATE TABLE IF NOT EXISTS visita (
fecha VARCHAR (255) NOT NULL,
hora VARCHAR (255) NOT NULL,
dnipersonal VARCHAR (10) NOT NULL,
dnipaciente VARCHAR (10) NOT NULL,
resultado VARCHAR (50) NOT NULL,
PRIMARY KEY (fecha,dnipaciente));


INSERT INTO paciente (nombre,edad,calle,localidad,codpostal,dni,sexo,peso,altura)
VALUES ('John', '48', 'Los Angeles 33','Benferri', '60606', '48556729Q', 'Hombre', 78.8, 1.78);

INSERT INTO personal (codigo,nombre,apellidos,dni,localidad,telefono,especialidad)
VALUES 	(10,'Marcos', 'Garcia', '48556729A', 'Almoradi', '649023981', 'Medicina General'),
		(11,'Juan', 'Santos', '48556729Z', 'Rojales', '649023982', 'Medicina General'),
		(12,'Francisco', 'Gomez', '48556729W', 'Dolores', '649023983', 'Otorrinolaringologia'),
        (13,'Ramon', 'Minguez', '48556729S', 'Catral', '649023984', 'Nefrologia'),
        (14,'Antonio', 'Perez', '48556729X', 'Arneva', '649023985', 'Pediatria');
        
        DROP TABLE visita;
        
        
        
        SELECT * FROM PERSONAL;

SELECT * FROM paciente;

SELECT * FROM visita;

DELETE FROM personal
WHERE codigo = 22;
