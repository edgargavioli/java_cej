CREATE DATABASE cej;

USE cej;

CREATE TABLE itens(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(200) NOT NULL,
    unidade_medida VARCHAR(2) NOT NULL,
    quantidade_minima INT NOT NULL,
    valor_d_compra DOUBLE NOT NULL,
    valor_d_venda DOUBLE NOT NULL
);

SELECT * FROM itens; 

CREATE TABLE funcionarios(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    nome_acesso VARCHAR(200) NOT NULL,
    senha_acesso VARCHAR(11) NOT NULL
);

SELECT * FROM funcionarios; 

CREATE TABLE categorias(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    descricao VARCHAR(200) NOT NULL
);

CREATE TABLE fornecedores(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    cnpj VARCHAR(200) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    telefone VARCHAR(11) NOT NULL
);

SELECT * FROM fornecedores;