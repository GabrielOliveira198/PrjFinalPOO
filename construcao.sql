DROP DATABASE IF EXISTS construcao;
CREATE DATABASE construcao;
USE construcao;

SELECT '*****************************************************************';

CREATE TABLE CLIENTE(
	codigo smallint(6) not null primary key auto_increment,
	nome varchar(80) not null,
	endereco varchar(80),
	fone varchar(80));
CREATE TABLE PRODUTO(
	codigo smallint(6) not null primary key auto_increment,
	descricao varchar(80) not null,
	preco decimal(10,2) not null);
CREATE TABLE COMPRA(
	codigo smallint(6) not null primary key auto_increment,
	qtd_produto smallint(10) not null,
	codCliente smallint(6) not null,
	codProduto smallint(6) not null,
FOREIGN KEY(codCliente) REFERENCES Cliente(codigo),
FOREIGN KEY(codProduto) REFERENCES PRODUTO(codigo));