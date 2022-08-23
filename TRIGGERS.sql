CREATE TABLE CLIENTE_INSERT (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    correo VARCHAR(50),
    fecha DATETIME
);

CREATE TABLE CLIENTE_DELETE (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    correo VARCHAR(50),
    fecha DATETIME
);

CREATE TABLE CLIENTE_UPDATE (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    correo VARCHAR(50),
    fecha DATETIME
);


CREATE TABLE DIRECCION_INSERT(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    direccion varchar(100),
    cd_fk INT,
    fecha DATETIME
);

CREATE TABLE DIRECCION_UPDATE(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    direccion varchar(100),
    cd_fk INT,
    fecha DATETIME
);

CREATE TABLE DIRECCION_DELETE(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    direccion varchar(100),
    cd_fk INT,
    fecha DATETIME
);

CREATE TABLE DOCUMENTO_INSERT(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tipo varchar(30),
    numero varchar(50),
    cn_fk int,
    fecha DATETIME
);

CREATE TABLE DOCUMENTO_UPDATE(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tipo varchar(30),
    numero varchar(50),
    cn_fk int,
    fecha DATETIME
);

CREATE TABLE DOCUMENTO_DELETE(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tipo varchar(30),
    numero varchar(50),
    cn_fk int,
    fecha DATETIME
);

CREATE TRIGGER DOCUMENTOINSERT AFTER INSERT ON documento FOR EACH ROW INSERT INTO DOCUMENTO_INSERT (id, tipo, numero, cn_fk,
fecha) VALUES (NEW.nid, NEW.tipo, NEW.numero, NEW.cn_fk, NOW());

CREATE TRIGGER DOCUMENTOUPDATE BEFORE UPDATE ON documento FOR EACH ROW INSERT INTO DOCUMENTO_UPDATE (id, tipo, numero, cn_fk,
fecha) VALUES (OLD.nid, OLD.tipo, OLD.numero, OLD.cn_fk, NOW());

CREATE TRIGGER DOCUMENTODELETET BEFORE DELETE ON documento FOR EACH ROW INSERT INTO DOCUMENTO_DELETE (id, tipo, numero, cn_fk,
fecha) VALUES (OLD.nid, OLD.tipo, OLD.numero, OLD.cn_fk, NOW());

CREATE TRIGGER DIRECCIONINSERT AFTER INSERT ON direccion FOR EACH ROW INSERT INTO DIRECCION_INSERT (id, direccion, cd_fk,
fecha) VALUES (NEW.did, NEW.direccion, NEW.cd_fk, NOW());

CREATE TRIGGER DIRECCIONUPDATE BEFORE UPDATE ON direccion FOR EACH ROW INSERT INTO DIRECCION_UPDATE (id, direccion, cd_fk,
fecha) VALUES (OLD.did, OLD.direccion, OLD.cd_fk, NOW());

CREATE TRIGGER DIRECCIONDELETE BEFORE DELETE ON direccion FOR EACH ROW INSERT INTO DIRECCION_DELETE (id, direccion, cd_fk,
fecha) VALUES (OLD.did, OLD.direccion, OLD.cd_fk, NOW());

CREATE TRIGGER CLIENTEINSERT AFTER INSERT ON cliente FOR EACH ROW INSERT INTO CLIENTE_INSERT (id, nombres, apellidos, correo,
fecha) values (NEW.id, NEW.nombres, NEW.apellidos, NEW.correo, NOW());

CREATE TRIGGER CLIENTEUPDATE BEFORE UPDATE ON cliente FOR EACH ROW INSERT INTO CLIENTE_UPDATE (id, nombres, apellidos, correo,
fecha) values (OLD.id, OLD.nombres, OLD.apellidos, OLD.correo, NOW());

CREATE TRIGGER CLIENTEDELETE BEFORE DELETE ON cliente FOR EACH ROW INSERT INTO CLIENTE_DELETE (id, nombres, apellidos, correo,
fecha) values (OLD.id, OLD.nombres, OLD.apellidos, OLD.correo, NOW());
